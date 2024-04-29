<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <!--=============== FAVICON ===============-->
        
        <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
        
        <!--=============== BOXICONS ===============-->
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        
        <!--=============== SWIPER CSS ===============-->
        <link rel="stylesheet" href="css/swiper-bundle.min.css">
        
        <!--=============== CSS ===============-->
        
        <link rel="stylesheet" href="css/styles.css">
        

        <title>Choco Nutz&trade;</title>
        
    </head>
    <body>
        <!--==================== HEADER ====================-->
        <header class="header" id="header">
            <nav class="nav container">
                <a href="index.jsp" class="nav__logo">
                    <img src="images/favicon.png" alt="alt"/> Choco Nutz&trade;
                </a>

                <div class="nav__menu" id="nav-menu">
                    <ul class="nav__list">
                        <li class="nav__item">
                            <a href="index.jsp" class="nav__link">Home</a>
                        </li>
                        <li class="nav__item">
                            <a href="#" class="nav__link">Categories</a>
                            <div class="cat-list">
                            <ul>
                            <li class="cat-items"><a href="products.jsp#Donuts" class="cat__link">Donuts</a></li>
                            <li class="cat-items"><a href="products.jsp#Cakes" class="cat__link">Cakes</a></li>
                            <li class="cat-items"><a href="products.jsp#Beverages" class="cat__link">Beverages</a></li>
                            <li class="cat-items"><a href="products.jsp#Beverages" class="cat__link">Sundae</a></li>
                            </ul>
                            </div>
                        </li>
                        <li class="nav__item">
                            <a href="aboutus.jsp" class="nav__link">About us</a>
                        </li>
                        <li class="nav__item">
                            <a href="order.jsp" class="nav__link">Orders</a>
                        </li>
                    </ul>

                    <div class="nav__close" id="nav-close">
                        <i class='bx bx-x' ></i>
                    </div>
                </div>

                <div class="nav__btns">
                    <!-- Theme change button -->
                    <i class='bx bx-moon change-theme' id="theme-button"></i>

                    <div class="nav__shop" id="cart-shop">
                        <i class='bx bx-shopping-bag' ></i>
                        <span class="qnty">3</span>
                    </div>
                   <div class="nav__signup" id="signup">
                        <c:if test="${empty sessionScope.user_id}">  <a href="login.jsp" class='login_btn change-theme' id="theme-button">Sign in</a>
                        </c:if>
                        <c:if test="${not empty sessionScope.user_id}">  
                            <a href="user_profile.jsp" class='login_btn change-theme' id="theme-button"><img src="images/account.png" width="30px" height="30px" alt="non"></a>
                            <a href="./logoutServlet" class='login_btn change-theme' id="theme-button"><img src="images/icons8-logout-48.png" width="30px" height="30px" alt="non"></a>
                        </c:if>
                    </div>

					

                    <div class="nav__toggle" id="nav-toggle">
                        <i class='bx bx-grid-alt' ></i>
                    </div>
                </div>
            </nav>
        </header>
        
    <!--==================== CART ====================-->
        <div class="cart" id="cart">
            <i class='bx bx-x cart__close' id="cart-close"></i>

            <h2 class="cart__title-center">My Cart</h2>

            <div class="cart__container">
                <article class="cart__card">
                    <div class="cart__box">
                        <img src="images/featured1.png" alt="" class="cart__img">
                    </div>

                    <div class="cart__details">
                        <h3 class="cart__title">Glazed</h3>
                        <span class="cart__price">Rs 225</span>

                        <div class="cart__amount">
                            <div class="cart__amount-content">
                                <input type="number" min="1" value="1" class="qty" name="p_qty">
                            </div>

                            <i class='bx bx-trash-alt cart__amount-trash' ></i>
                        </div>
                    </div>
                </article>
                
                <article class="cart__card">
                    <div class="cart__box">
                        <img src="images/featured3.png" alt="" class="cart__img">
                    </div>

                    <div class="cart__details">
                        <h3 class="cart__title">Nutella</h3>
                        <span class="cart__price">Rs 320</span>

                        <div class="cart__amount">
                            <div class="cart__amount-content">
                                <input type="number" min="1" value="1" class="qty" name="p_qty">
                            </div>

                            <i class='bx bx-trash-alt cart__amount-trash' ></i>
                        </div>
                    </div>
                </article>

                <article class="cart__card">
                    <div class="cart__box">
                        <img src="images/new1.png" alt="" class="cart__img">
                    </div>

                    <div class="cart__details">
                        <h3 class="cart__title">Kikkat,Cherry & Nutella</h3>
                        <span class="cart__price">Rs 480</span>

                        <div class="cart__amount">
                            <div class="cart__amount-content">
                                <input type="number" min="1" value="1" class="qty" name="p_qty">
                            </div>

                            <i class='bx bx-trash-alt cart__amount-trash' ></i>
                        </div>
                    </div>
                </article>
            </div>

            <div class="cart__prices">
                <span class="cart__prices-item">3 items</span>
                <span class="cart__prices-total">Rs 1050</span>
            </div>
            <div class="cart_proceed">
                <input type="submit" class="c-cart" value="Continue Shopping">
                <input type="submit" class="c-cart" value="Delete All">
                <input type="submit" class="c-cart" value="Proceed">
            </div>
        </div>

    