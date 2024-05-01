<%@ include file="jsp/header.jsp"%>




<section class="review-form">

   <h1 class="form-title">Leave a Review</h1>

   <form action="" method="POST" class="review-form-container">
      <div class="form-group">
          <label for="name" class="review-label">Your Name:</label>
         <input type="text" name="name" id="name" class="form-control" required placeholder="Enter your name">
      </div>
      <div class="form-group">
         <label for="email" class="review-label">Your Email:</label>
         <input type="email" name="email" id="email" class="form-control" required placeholder="Enter your email">
      </div>
      <div class="form-group">
         <label class="review-label">Your Rating:</label>
         <div class="rating">
            <input type="radio" id="star5" name="rating" value="5" required onclick="changeColor('star5')" />
            <label for="star5"></label>
            <input type="radio" id="star4" name="rating" value="4" onclick="changeColor('star4')" />
            <label for="star4"></label>
            <input type="radio" id="star3" name="rating" value="3" onclick="changeColor('star3')" />
            <label for="star3"></label>
            <input type="radio" id="star2" name="rating" value="2" onclick="changeColor('star2')" />
            <label for="star2"></label>
            <input type="radio" id="star1" name="rating" value="1" onclick="changeColor('star1')" />
            <label for="star1"></label>
         </div>
      </div>
      <div class="form-group">
         <label for="message" class="review-label">Your Review:</label>
         <textarea name="message" id="message" class="form-control" required placeholder="Enter your review" rows="4"></textarea>
      </div>
      <input type="submit" value="Submit Review" class="btn-submit" name="send">
   </form>

</section>

<script>
function changeColor(radioId) {
    const stars = ['star1', 'star2', 'star3', 'star4', 'star5'];
    
    // Reset all stars to default color
    stars.forEach(star => {
        const label = document.querySelector(`label[for=${star}]`);
        label.style.color = 'black';
    });
    
    // Set color for clicked star and previous stars
    let clicked = false;
    for (let i = 0; i < stars.length; i++) {
        const label = document.querySelector(`label[for=${stars[i]}]`);
        
        if (stars[i] === radioId) {
            clicked = true;
        }
        
        if (clicked) {
            label.style.color = 'gold';
        }
    }
}
</script>









<section class="reviews">

   <h1 class="review-title">clients reivews</h1>

   <div class="review-container">

      <div class="review_box">
         <img src="images/testimonial1.jpg" alt="">
         <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Et voluptates sit earum, neque non cupiditate amet deserunt aperiam quas ex.</p>
         <div class="stars">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
         </div>
         <h3 class="review-h3">john deo</h3>
      </div>
       <div class="review_box">
         <img src="images/testimonial2.jpg" alt="">
         <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Et voluptates sit earum, neque non cupiditate amet deserunt aperiam quas ex.</p>
         <div class="stars">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
         </div>
         <h3 class="review-h3">john deo</h3>
      </div>
       <div class="review_box">
         <img src="images/testimonial3.jpg" alt="">
         <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Et voluptates sit earum, neque non cupiditate amet deserunt aperiam quas ex.</p>
         <div class="stars">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
         </div>
         <h3 class="review-h3">john deo</h3>
      </div>
       <div class="review_box">
         <img src="images/testimonial1.jpg" alt="">
         <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Et voluptates sit earum, neque non cupiditate amet deserunt aperiam quas ex.</p>
         <div class="stars">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
         </div>
         <h3 class="review-h3">john deo</h3>
      </div>
       <div class="review_box">
         <img src="images/testimonial2.jpg" alt="">
         <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Et voluptates sit earum, neque non cupiditate amet deserunt aperiam quas ex.</p>
         <div class="stars">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
         </div>
         <h3 class="review-h3">john deo</h3>
      </div>
       <div class="review_box">
         <img src="images/testimonial3.jpg" alt="">
         <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Et voluptates sit earum, neque non cupiditate amet deserunt aperiam quas ex.</p>
         <div class="stars">
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star"></i>
            <i class="fas fa-star-half-alt"></i>
         </div>
         <h3 class="review-h3">john deo</h3>
      </div>

      

</section>
<%@ include file="jsp/footer.jsp"%>
