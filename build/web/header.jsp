<%-- 
    Document   : header
    Created on : Feb 28, 2023, 7:57:37 AM
    Author     : Alienware M15 R3
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="user.userDTO"%>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="Responsive Bootstrap4 Shop Template, Created by Imran Hossain from https://imransdesign.com/">

        <!-- title -->
        <title>Fruitkha</title>

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
      <%
            userDTO usLogin = (userDTO) session.getAttribute("LOGIN_USER");
        %>
        
        <c:set value="${LOGIN_USER}" var = "login"/>

        <!--PreLoader-->
        <div class="loader">
            <div class="loader-inner">
                <div class="circle"></div>
            </div>
        </div>
        <!--PreLoader Ends-->

        <!-- header -->
        <div class="top-header-area" id="sticker">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12 col-sm-12 text-center">
                        <div class="main-menu-wrap">
                            <!-- logo -->
                            <div class="site-logo">
                                <a href="index.jsp">
                                    <img src="assets/img/logo.png" alt="">
                                </a>
                            </div>
                            <!-- logo -->

                            <!-- menu start -->
                            <nav class="main-menu">
                                <ul>
                                    <li class="current-list-item"><a href="index.jsp">Home</a></li>
                                    <li><a href="about.jsp">About</a></li>
                                    <li><a href="#">Pages</a>
                                        <ul class="sub-menu">
                                            <li><a href="404.html">404 page</a></li>
                                            <li><a href="about.html">About</a></li>
                                            <li><a href="cart.jsp">Cart</a></li>
                                            <li><a href="checkout.jsp">Check Out</a></li>
                                            <li><a href="contact.html">Contact</a></li>
                                            <li><a href="news.html">News</a></li>
                                            <li><a href="shop.jsp">Shop</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="news.html">News</a>
                                        <ul class="sub-menu">
                                            <li><a href="news.html">News</a></li>
                                            <li><a href="single-news.html">Single News</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="contact.html">Contact</a></li>
                                    <li><a href="shop.jsp">Shop</a>
                                        <ul class="sub-menu">
                                            <li><a href="shop.jsp">Shop</a></li>
                                            <li><a href="checkout.jsp">Check Out</a></li>
                                            <li><a href="single-product.html">Single Product</a></li>
                                            <li><a href="cart.jsp">Cart</a></li>
                                        </ul>
                                    </li>
                                    <%
                                        if (usLogin != null) {
                                    %>
                                    <li><a href="#">Hello: ${login.name}</a>
                                        <ul class="sub-menu">
                                            <form action="MainController">
                                                <li> <input class="afake" type="submit" name="action" value="Logout" /> </li>
                                            </form>
                                        </ul>
                                    </li>
                                    <%
                                    } else {
                                    %>
                                    <li><a href="login.jsp">Login</a></li>
                                        <%
                                            }
                                        %>

                                    <li>
                                        <div class="header-icons">
                                            <a class="shopping-cart" href="cart.jsp"><i class="fas fa-shopping-cart"></i></a>
                                            <a class="mobile-hide search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                                        </div>
                                    </li>
                                </ul>
                            </nav>
                            <a class="mobile-show search-bar-icon" href="#"><i class="fas fa-search"></i></a>
                            <div class="mobile-menu"></div>
                            <!-- menu end -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end header -->

        <!-- search area -->
        <div class="search-area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <span class="close-btn"><i class="fas fa-window-close"></i></span>
                        <div class="search-bar">
                            <div class="search-bar-tablecell">
                                <h3>Search For:</h3>
                                <input type="text" placeholder="Keywords">
                                <button type="submit">Search <i class="fas fa-search"></i></button> 
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- end search area -->
    </body>
</html>
