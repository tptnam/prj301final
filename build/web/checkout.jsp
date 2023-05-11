<%@page import="product.productDTO"%>
<%@page import="shopping.Cart"%>
<%@page import="user.userDTO"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

        <!-- title -->
        <title>Check Out</title>

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

        <!--PreLoader-->
        <div class="loader">
            <div class="loader-inner">
                <div class="circle"></div>
            </div>
        </div>
        <!--PreLoader Ends-->

        <jsp:include page="header.jsp"/>

        <!-- breadcrumb-section -->
        <div class="breadcrumb-section breadcrumb-bg">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 offset-lg-2 text-center">
                        <div class="breadcrumb-text">
                            <p>Fresh and Organic</p>
                            <h1>Check Out Product</h1>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end breadcrumb section -->

        <!-- check out section -->
        <div class="checkout-section mt-150 mb-150">
            <div class="container">
                <div class="row">
                    <div class="col-lg-8">
                        <div class="checkout-accordion-wrap">
                            <div class="accordion" id="accordionExample">
                                <div class="card single-accordion">
                                    <div class="card-header" id="headingOne">
                                        <h5 class="mb-0">
                                            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                Billing Address
                                            </button>
                                        </h5>
                                    </div>

                                    <%
                                        userDTO usLogin = (userDTO) session.getAttribute("LOGIN_USER");
                                        if (usLogin == null) {
                                    %>

                                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="billing-address-form">
                                               <form action="MainController">
                                                    <p><input type="text" placeholder="Name" name="name" ></p>
                                                    <p><input type="email" placeholder="Email"name="email" ></p>
                                                    <p><input type="text" placeholder="Address" name="address"></p>
                                                    <p><input type="tel" placeholder="Phone" name="phone"></p>
<!--                                                    <p><textarea  name="note" id="bill" cols="30" rows="10" placeholder="Say Something"></textarea></p>-->
                                                    
                                                    <p><input type="text" name="note" id="bill" cols="30" rows="10" placeholder="Say hoho"></p>
                                                     <input class="afake"  type="submit" name="action" value="SUBMIT" />
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                    <%
                                    } else {
                                    %>


                                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="billing-address-form">
                                                <form action="MainController">
                                                    <p><input type="text" placeholder="Name" name="name" value="<%= usLogin.getName()%>" ></p>
                                                    <p><input type="email" placeholder="Email"name="email" value="<%= usLogin.getEmail()%>" ></p>
                                                    <p><input type="text" placeholder="Address" name="address" ></p>
                                                    <p><input type="tel" placeholder="Phone" name="phone"></p>
<!--                                                    <p><textarea name="bill" id="bill" cols="30" rows="10" placeholder="Say Something"></textarea></p>-->
                                                     <p><input type="text" name="note" id="bill" cols="30" rows="10" placeholder="Say hoho"></p>
                                                    <!--                                                     <a href="#" class="boxed-btn">SUBMIT</a>-->
                                                    <input class="afake"  type="submit" name="action" value="SUBMIT" />
                                            </form>
                                        </div>
                                    </div>
                                </div>


                                <%
                                    }
                                %>
                            </div>

                        </div>

                    </div>
                </div>

                <%
                    double total = 0;
                    Cart cart = (Cart) session.getAttribute("CART");
                    if (cart == null) {
                %>

                <div class="col-lg-4">
                    <div class="order-details-wrap">
                        <table class="order-details">
                            <thead>
                                <tr>
                                    <th>Your order Details</th>
                                    <th>Price</th>
                                </tr>
                            </thead>
                            <tbody class="order-details-body">
                                <tr>
                                    <td>Product</td>
                                    <td>Total</td>
                                </tr>
                            </tbody>
                            <tbody class="checkout-details">
                                <tr>
                                    <td>Subtotal</td>
                                    <td>$0</td>
                                </tr>
                                <tr>
                                    <td>Shipping</td>
                                    <td>$0</td>
                                </tr>
                                <tr>
                                    <td>Total</td>
                                    <td>$0</td>
                                </tr>
                            </tbody>
                        </table>
                        <%
                        } else {
                        %>
                        <div class="col-lg-4">
                            <div class="order-details-wrap">
                                <table class="order-details">
                                    <thead>
                                        <tr>
                                            <th>Your order Details</th>
                                            <th></th>
                                            <th>Price</th>
                                        </tr>
                                    </thead>
                                    <tbody class="order-details-body">
                                        <tr>
                                            <td>Product</td>
                                            <td>Quantity</td>
                                            <td>Total</td>
                                        </tr>
                                        <%
                                            for (productDTO pro : cart.getCart().values()) {
                                                total = total + (pro.getQuantity() * pro.getPrice());


                                        %>
                                        <tr>
                                            <td><%= pro.getProName()%></td>
                                            <td><%= pro.getQuantity()%></td>
                                            <td><%= pro.getPrice()%></td>
                                        </tr>

                                    </tbody>
                                    <%
                                            }
                                        }
                                    %>
                                    <tbody class="checkout-details">
                                        <tr>
                                            <td>Subtotal</td>
                                            <td>$<%= total%></td>
                                        </tr>
                                        <tr>
                                            <td>Shipping</td>
                                            <td>$45</td>
                                        </tr>
                                        <tr>
                                            <td>Total</td>
                                            <td>$<%= total + 45%></td>
                                        </tr>
                                    </tbody>
                                </table>






                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end check out section -->

            <!-- logo carousel -->
            <div class="logo-carousel-section">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="logo-carousel-inner">
                                <div class="single-logo-item">
                                    <img src="assets/img/company-logos/1.png" alt="">
                                </div>
                                <div class="single-logo-item">
                                    <img src="assets/img/company-logos/2.png" alt="">
                                </div>
                                <div class="single-logo-item">
                                    <img src="assets/img/company-logos/3.png" alt="">
                                </div>
                                <div class="single-logo-item">
                                    <img src="assets/img/company-logos/4.png" alt="">
                                </div>
                                <div class="single-logo-item">
                                    <img src="assets/img/company-logos/5.png" alt="">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end logo carousel -->

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