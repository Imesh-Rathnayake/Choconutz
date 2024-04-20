<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">  
        <!--=============== FAVICON ===============-->
        
        <link rel="shortcut icon" href="images/favicon.png" type="image/x-icon">
        
        <!--=============== BOXICONS ===============-->
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/boxicons@latest/css/boxicons.min.css">
        
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
                            <a href="index.jsp" class="nav__link active-link">Home</a>
                        </li>
                        <li class="nav__item">
                            <a href="index.jsp#featured" class="nav__link">Categories</a>
                        </li>
                        <li class="nav__item">
                            <a href="produts.jsp" class="nav__link">Products</a>
                        </li>
                        <li class="nav__item">
                            <a href="index.jsp#new" class="nav__link">Orders</a>
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
                    </div>
                    <div class="nav__signup" id="signup">
                        <a href="login.jsp" class='login_btn change-theme' id="theme-button">Sign in</a>
                        <i class="fa fa-user" aria-hidden="true"></i>
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
