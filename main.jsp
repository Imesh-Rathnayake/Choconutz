<%@ include file="jsp/header.jsp"%>


            <!--==================== PRODUCTS ====================-->
            <section class="products section container" id="products">
                <h2 class="section__title">
                    Products
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
