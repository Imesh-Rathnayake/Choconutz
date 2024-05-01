<%@ include file="jsp/header.jsp"%>
<!--==================== MAIN ====================-->
        <main class="main">
            <!--==================== HOME ====================-->
            <section class="home" id="home">
                <div class="home__container container grid">
                    <div class="home__img-bg">
                        <img src="images/home.png" alt="" class="home__img">
                    </div>
    
                    <div class="home__social">
                        <a href="https://www.facebook.com/" target="_blank" class="home__social-link">
                            Facebook
                        </a>
                        <a href="https://twitter.com/" target="_blank" class="home__social-link">
                            Twitter
                        </a>
                        <a href="https://www.instagram.com/" target="_blank" class="home__social-link">
                            Instagram
                        </a>
                    </div>
    
                    <div class="home__data">
                        <h1 class="home__title">NEW DONUT <br> COLLECTIONS </h1>
                        <p class="home__description">
                            Latest arrival of the new Oreo Caramel donuts, with a decadent and irresistible flavor.
                        </p>
                        <span class="home__price">RS 220</span>

                        <div class="home__btns">
                            <a href="main.jsp#new" class="button button--gray button--small">
                                Discover
                            </a>

                            <button class="button home__button">ADD TO CART</button>
                        </div>
                    </div>
                </div>
            </section>

            <!--==================== categories ====================-->
            <section class="featured section container" id="featured">
                <h2 class="section__title">
                    SHOP BY CATEGORY
                </h2>

                <div class="featured__container grid">
                    <article class="featured__card">
                        

                        <img src="images/featured1.png" alt="" class="featured__img">

                        <div class="featured__data">
                            <h3 class="featured__title">Donuts</h3>
                            <br>
                            <br>                            
                        </div>

                      <a href="category.jsp?category=donuts" class="featured__button"> Explore</a>  
                    </article>

                    <article class="featured__card">
                        

                        <img src="images/black-forest-cake-half-kg_1.jpg" alt="" class="featured__img">

                        <div class="featured__data">
                            <h3 class="featured__title">Cakes</h3>
                            <br>
                            <br>
                        </div>

                        <a href="category.jsp?category=cakes" class="featured__button"> Explore</a>
                    </article>

                    <article class="featured__card">
                        

                        <img src="images/orange-juice-oranges.jpeg" alt="" class="featured__img">

                        <div class="featured__data">
                            <h3 class="featured__title">Beverages</h3>
                            <br>
                            <br>
                        </div>

                        <a href="category.jsp?category=beverages" class="featured__button"> Explore</a>
                    </article>
                     <article class="featured__card">
                        

                        <img src="images/ice-cream-sundae-with-homemade-caramel-FT-RECIPE0721-a3f7998964104a8094eccfd3b827cc56.jpg" alt="" class="featured__img">

                        <div class="featured__data">
                            <h3 class="featured__title">Sundae</h3>
                            <br>
                            <br>
                        </div>

                        <a href="category.jsp?category=sundaes" class="featured__button"> Explore</a>
                    </article>
                </div>
            </section>

            <!--==================== STORY ====================-->
            <section class="story section container">
                <div class="story__container grid">
                    <div class="story__data">
                        <h2 class="section__title story__section-title">
                            Our Journey
                        </h2>
    
                        <h1 class="story__title">
                            The Signature Donut Of <br> This Year
                        </h1>
    
                        <p class="story__description">
                            Embark on a flavorful adventure with our latest and most delectable donuts of the year. Each crafted with passion and available in a variety of irresistible flavors, come savor the story with us today.
                        </p>
    
                        <a href="aboutus.jsp" class="button button--small">Discover</a>
                    </div>

                    <div class="story__images">
                        <img src="images/story.png" alt="" class="story__img">
                        <div class="story__square"></div>
                    </div>
                </div>
            </section>

            <!--==================== PRODUCTS ====================-->
            <section class="products section container" id="products">
                <h2 class="section__title">
                    Most Popular
                </h2>

                <div class="products__container grid">
                    <article class="products__card">
                        <img src="images/product1.png" alt="" class="products__img">

                        <h3 class="products__title">ButterScotch</h3>
                        <span class="products__price">Rs 395</span>

                        <button class="products__button">
                            <i class='bx bx-shopping-bag'></i>
                        </button>
                    </article>

                    <article class="products__card">
                        <img src="images/product2.png" alt="" class="products__img">

                        <h3 class="products__title">Strawberry Cream</h3>
                        <span class="products__price">Rs 350</span>

                        <button class="products__button">
                            <i class='bx bx-shopping-bag'></i>
                        </button>
                    </article>

                    <article class="products__card">
                        <img src="images/product3.png" alt="" class="products__img">

                        <h3 class="products__title">Blueberry Blaster</h3>
                        <span class="products__price">Rs 370</span>

                        <button class="products__button">
                            <i class='bx bx-shopping-bag'></i>
                        </button>
                    </article>

                    <article class="products__card">
                        <img src="images/product4.png" alt="" class="products__img">

                        <h3 class="products__title">Cappucino</h3>
                        <span class="products__price">Rs 250</span>

                        <button class="products__button">
                            <i class='bx bx-shopping-bag'></i>
                        </button>
                    </article>

                    <article class="products__card">
                        <img src="images/product5.png" alt="" class="products__img">

                        <h3 class="products__title">Oreo Caramel</h3>
                        <span class="products__price">Rs 390</span>

                        <button class="products__button">
                            <i class='bx bx-shopping-bag'></i>
                        </button>
                    </article>
                </div>
            </section>

            <!--==================== TESTIMONIAL ====================-->
            <section class="testimonial section container">
                <div class="testimonial__container grid">
                    <div class="swiper testimonial-swiper">
                        <div class="swiper-wrapper">
                            <div class="testimonial__card swiper-slide">
                                <div class="testimonial__quote">
                                    <i class='bx bxs-quote-alt-left' ></i>
                                </div>
                                <p class="testimonial__description">
                                    Every bite of these donuts is like a little piece of heaven! The flavors are incredibly rich and the texture is just perfect. My favorite spot for indulging in sweet delights.
                                </p>
                                <h3 class="testimonial__date">March 27. 2021</h3>
        
                                <div class="testimonial__perfil">
                                    <img src="images/testimonial1.jpg" alt="" class="testimonial__perfil-img">
        
                                    <div class="testimonial__perfil-data">
                                        <span class="testimonial__perfil-name">Imesh Rathnayake</span>
                                        <span class="testimonial__perfil-detail">Director of a company</span>
                                    </div>
                                </div>
                            </div>

                            <div class="testimonial__card swiper-slide">
                                <div class="testimonial__quote">
                                    <i class='bx bxs-quote-alt-left' ></i>
                                </div>
                                <p class="testimonial__description">
                                    I've tried donuts from many places, but none compare to the unique and mouthwatering creations at this shop. A must-visit for any donut lover!
                                </p>
                                <h3 class="testimonial__date">March 27. 2021</h3>
        
                                <div class="testimonial__perfil">
                                    <img src="images/testimonial2.jpg" alt="" class="testimonial__perfil-img">
        
                                    <div class="testimonial__perfil-data">
                                        <span class="testimonial__perfil-name">Micheal Jackson</span>
                                        <span class="testimonial__perfil-detail">Director of a company</span>
                                    </div>
                                </div>
                            </div>

                            <div class="testimonial__card swiper-slide">
                                <div class="testimonial__quote">
                                    <i class='bx bxs-quote-alt-left' ></i>
                                </div>
                                <p class="testimonial__description">
                                    The atmosphere, the service, and most importantly, the donuts - everything is top-notch! I'm always excited to see what new flavors they come up with. Highly recommend!
                                </p>
                                <h3 class="testimonial__date">March 27. 2021</h3>
        
                                <div class="testimonial__perfil">
                                    <img src="images/testimonial3.jpg" alt="" class="testimonial__perfil-img">
        
                                    <div class="testimonial__perfil-data">
                                        <span class="testimonial__perfil-name">Justin Beiber</span>
                                        <span class="testimonial__perfil-detail">Director of a company</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        <div class="swiper-button-next">
                            <i class='bx bx-right-arrow-alt' ></i>
                        </div>
                        <div class="swiper-button-prev">
                            <i class='bx bx-left-arrow-alt' ></i>
                        </div>
                    </div>

                    <div class="testimonial__images">
                        <div class="testimonial__square"></div>
                        <img src="images/testimonia.png" alt="" class="testimonial__img">
                    </div>
                </div>
            </section>

            <!--==================== NEW ====================-->
            <section class="new section container" id="new">
                <h2 class="section__title">
                    New Arrivals
                </h2>
                
                <div class="new__container">
                    <div class="swiper new-swiper">
                        <div class="swiper-wrapper">
                            <article class="new__card swiper-slide">
                                <span class="new__tag">New</span>
        
                                <img src="images/new1.png" alt="" class="new__img">
        
                                <div class="new__data">
                                    <h3 class="new__title">Kikkat,Cherry & Nutella</h3>
                                    <span class="new__price">Rs 480</span>
                                </div>
        
                                <button class="button new__button">ADD TO CART</button>
                            </article>

                            <article class="new__card swiper-slide">
                                <span class="new__tag">New</span>
        
                                <img src="images/new2.png" alt="" class="new__img">
        
                                <div class="new__data">
                                    <h3 class="new__title">Sneakers & Dark<br>chocolate</h3>
                                    <span class="new__price">Rs 550</span>
                                </div>
        
                                <button class="button new__button">ADD TO CART</button>
                            </article>

                            <article class="new__card swiper-slide">
                                <span class="new__tag">New</span>
        
                                <img src="images/new.png" alt="" class="new__img">
        
                                <div class="new__data">
                                    <h3 class="new__title">Huzelnut</h3>
                                    <span class="new__price">RS 350</span>
                                </div>
        
                                <button class="button new__button">ADD TO CART</button>
                            </article>

                            <article class="new__card swiper-slide">
                                <span class="new__tag">New</span>
        
                                <img src="images/new4.png" alt="" class="new__img">
        
                                <div class="new__data">
                                    <h3 class="new__title">Pineapple Jelly</h3>
                                    <span class="new__price">Rs 280</span>
                                </div>
        
                                <button class="button new__button">ADD TO CART</button>
                            </article>                       
                        </div>
                    </div>
                </div>
            </section>

            <!--==================== NEWSLETTER ====================-->
            <section class="newsletter section container">
                <div class="newsletter__bg grid">
                    <div>
                        <h2 class="newsletter__title">Subscribe Our <br> Newsletter</h2>
                        <p class="newsletter__description">
                            Don't miss out on your discounts. Subscribe to our email 
                            newsletter to get the best offers, discounts, coupons, 
                            gifts and much more.
                        </p>
                    </div>

                    <form action="" class="newsletter__subscribe">
                        <input type="email" placeholder="Enter your email" class="newsletter__input">
                        <button class="button">
                            SUBSCRIBE
                        </button>
                    </form>
                </div>
            </section>
        </main>
<%@ include file="jsp/footer.jsp"%>
