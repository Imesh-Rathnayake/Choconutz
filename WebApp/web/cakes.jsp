<%@ include file="jsp/header.jsp"%>
<section class="cake-form">

        <h1 class="form-title">Cake Inquires</h1>

        <form action="#" method="POST" class="cake-form-container" id="cakeForm">
            <div class="form-group">
                <label for="name" class="cake-label">Your Name:</label>
                <input type="text" name="name" id="name" class="form-control" required placeholder="Enter your name">
            </div>
            <div class="form-group">
                <label for="email" class="cake-label">Your Email:</label>
                <input type="email" name="email" id="email" class="form-control" required placeholder="Enter your email">
            </div>
            <div class="form-group">
                <label for="phone" class="cake-label">Your Phone Number:</label>
                <input type="tel" name="phone" id="phone" class="form-control" required placeholder="Enter your phone number">
            </div>
            <div class="form-group">
                <label for="cake-type" class="cake-label">Cake Type:</label>
                <select name="cake-type" id="cake-type" class="form-control" required>
                    <option value="">Select Cake Type</option>
                    <option value="birthday-cake">Birthday Cake</option>
                    <option value="wedding-cake">Wedding Cake</option>
                    <option value="custom-cake">Custom Cake</option>
                </select>
            </div>
            <div class="form-group">
                <label for="cake-size" class="cake-label">Cake Size:</label>
                <select name="cake-size" id="cake-size" class="form-control" required>
                    <option value="">Select Cake Size</option>
                    <option value="small">Small</option>
                    <option value="medium">Medium</option>
                    <option value="large">Large</option>
                </select>
            </div>
            <div class="form-group">
                <label for="cake-flavor" class="cake-label">Cake Flavor:</label>
                <input type="text" name="cake-flavor" id="cake-flavor" class="form-control" required placeholder="Enter cake flavor">
            </div>
            <div class="form-group">
                <label for="cake-message" class="cake-label">Cake Message:</label>
                <textarea name="cake-message" id="cake-message" class="form-control" required placeholder="Enter cake message" rows="4"></textarea>
            </div>
            <div class="form-group">
                <input type="submit" value="Submit Inquiry" class="btn-submit" name="submit">
            </div>
        </form>

    </section>

<%@ include file="jsp/footer.jsp"%>