<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="product.productDAO"%>
<%@page import="user.userDTO"%>
<%@page import="product.productDTO"%>
<%@page import="shopping.Cart"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

        <!-- title -->
        <title>Cart</title>

        <!-- favicon -->
        <link rel="shortcut icon" type="image/png" href="assets/img/favicon.png">
        <!-- google font -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css?family=Poppins:400,700&display=swap" rel="stylesheet">
        <!-- fontawesome -->
        <link rel="stylesheet" href="assets/css/all.min.css">
        <!-- bootstrap -->
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <!-- owl carousel -->
        <link rel="stylesheet" href="assets/css/owl.carousel.css">
        <!-- magnific popup -->
        <link rel="stylesheet" href="assets/css/magnific-popup.css">
        <!-- animate css -->
        <link rel="stylesheet" href="assets/css/animate.css">
        <!-- mean menu css -->
        <link rel="stylesheet" href="assets/css/meanmenu.min.css">
        <!-- main style -->
        <link rel="stylesheet" href="assets/css/main.css">
        <!-- responsive -->
        <link rel="stylesheet" href="assets/css/responsive.css">

    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>



            <!-- breadcrumb-section -->
            <div class="breadcrumb-section breadcrumb-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 offset-lg-2 text-center">
                            <div class="breadcrumb-text">
                                <p>Fresh and Organic</p>
                                <h1>Cart</h1>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end breadcrumb section -->

        <%
           
            Cart cart = (Cart) session.getAttribute("CART");
            
            if (cart == null) {


        %>
        <div class="cart-section mt-150 mb-150">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 col-md-12">
                        <div class="cart-table-wrap">
                            <table class="cart-table">
                                <thead class="cart-table-head">
                                    <tr class="table-head-row">
                                        <th class="product-remove"></th>
                                        <th class="product-image">Product Image</th>
                                        <th class="product-name">Name</th>
                                        <th class="product-price">Price</th>
                                        <th class="product-quantity">Quantity</th>
                                        <th class="product-total">Total</th>
                                        <th class="product-update">Update</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <h1>Your Cart is empty</h1>
                                <a href="index.jsp">Back To Shopping</a>
                                </tbody>
                            </table>
                        </div> 
                    </div>

                    <div class="col-lg-4">
                        <div class="total-section">
                            <table class="total-table">
                                <thead class="total-table-head">
                                    <tr class="table-total-row">
                                        <th>Total</th>
                                        <th>Price</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr class="total-data">
                                        <td><strong>Subtotal: </strong></td>
                                        <td>$0</td>
                                    </tr>
                                    <tr class="total-data">
                                        <td><strong>Shipping: </strong></td>
                                        <td>$0</td>
                                    </tr>
                                    <tr class="total-data">
                                        <td><strong>Total: </strong></td>
                                        <td>$0</td>
                                    </tr>
                                </tbody>
                            </table>
                            <div class="cart-buttons">
                                <a href="checkout.jsp" class="boxed-btn black">Check Out</a>
                            </div>
                        </div>

                        <div class="coupon-section">
                            <h3>Apply Coupon</h3>
                            <div class="coupon-form-wrap">
                                <form action="index.html">
                                    <p><input type="text" placeholder="Coupon"></p>
                                    <p><input type="submit" value="Apply"></p>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <% } else {%>

            <div class="cart-section mt-150 mb-150">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-8 col-md-12">
                            <div class="cart-table-wrap">
                                <table class="cart-table">
                                    <thead class="cart-table-head">
                                        <tr class="table-head-row">
                                            <th class="product-remove"></th>
                                            <th class="product-image">Product Image</th>
                                            <th class="product-name">Name</th>
                                            <th class="product-price">Price</th>
                                            <th class="product-quantity">Quantity</th>
                                            <th class="product-total">Total</th>
                                             <th class="product-total">Update</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="table-body-row">
                                            <%
                                                double total = 0;
                                                for (productDTO pro : cart.getCart().values()) {
                                                    total = total + (pro.getQuantity() * pro.getPrice());

                                            %>
                                    <form action="MainController">
                                        <input type="text" name="id" value="<%= pro.getProID()%>" hidden=""/>
                                        <td class="product-remove"><button class="far fa-window-close" type="submit" name="action" value="remove" ></button></td>
                                    </form>
                                    <form action="MainController"> 
                                        <td class="product-image"><img src="<%= pro.getPath()%>" alt=""></td>
                                        <td class="product-name"><%= pro.getProName()%></td>
                                        <td class="product-price">$<%= pro.getPrice()%></td>
                                        <td class="product-quantity"><input type="number" name="quantityChange"  value="<%= pro.getQuantity()%>" ></td>
                                        <td class="product-total"> $<%= pro.getQuantity() * pro.getPrice()%></td>
                                        <input type="text" name="id" value="<%= pro.getProID()%>" hidden=""/>
                                        <td class="product-remove"><button class="afake" type="submit" name="action" value="change" >Change</button></td>
                                    </form>

                                    </tr>
                                    <%}%>
                                    </tbody>
                                </table>
                            </div> 
                        </div>

                        <div class="col-lg-4">
                            <div class="total-section">
                                <table class="total-table">
                                    <thead class="total-table-head">
                                        <tr class="table-total-row">
                                            <th>Total</th>
                                            <th>Price</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="total-data">
                                            <td><strong>Subtotal: </strong></td>
                                            <td>$<%= total%></td>
                                        </tr>
                                        <tr class="total-data">
                                            <td><strong>Shipping: </strong></td>
                                            <td>$ ${45}</td>
                                        </tr>
                                        <tr class="total-data">
                                            <td><strong>Total: </strong></td>
                                            <td>$<%= total + 45%></td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="cart-buttons">
<!--                                    <a href="cart.html" class="boxed-btn">Update Cart</a>-->
                                    <a href="checkout.jsp" class="boxed-btn black">Check Out</a>
                                </div>
                            </div>

                            <div class="coupon-section">
                                <h3>Apply Coupon</h3>
                                <div class="coupon-form-wrap">
                                    <form action="index.html">
                                        <p><input type="text" placeholder="Coupon"></p>
                                        <p><input type="submit" value="Apply"></p>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%}%>

                <jsp:include page="footer.jsp"/>

                <!-- jquery -->
                <script src="assets/js/jquery-1.11.3.min.js"></script>
                <!-- bootstrap -->
                <script src="assets/bootstrap/js/bootstrap.min.js"></script>
                <!-- count down -->
                <script src="assets/js/jquery.countdown.js"></script>
                <!-- isotope -->
                <script src="assets/js/jquery.isotope-3.0.6.min.js"></script>
                <!-- waypoints -->
                <script src="assets/js/waypoints.js"></script>
                <!-- owl carousel -->
                <script src="assets/js/owl.carousel.min.js"></script>
                <!-- magnific popup -->
                <script src="assets/js/jquery.magnific-popup.min.js"></script>
                <!-- mean menu -->
                <script src="assets/js/jquery.meanmenu.min.js"></script>
                <!-- sticker js -->
                <script src="assets/js/sticker.js"></script>
                <!-- main js -->
                <script src="assets/js/main.js"></script>

                </body>
                </html>