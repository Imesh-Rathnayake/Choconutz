/*=============== SHOW MENU ===============*/
const navMenu = document.getElementById('nav-menu'),
      navToggle = document.getElementById('nav-toggle'),
      navClose = document.getElementById('nav-close')

/*===== MENU SHOW =====*/
/* Validate if constant exists */
if(navToggle){
    navToggle.addEventListener('click', () =>{
        navMenu.classList.add('show-menu')
    })
}

/*===== MENU HIDDEN =====*/
/* Validate if constant exists */
if(navClose){
    navClose.addEventListener('click', () =>{
        navMenu.classList.remove('show-menu')
    })
}

/*=============== REMOVE MENU MOBILE ===============*/
const navLink = document.querySelectorAll('.nav__link')

const linkAction = () =>{
    const navMenu = document.getElementById('nav-menu')
    // When we click on each nav__link, we remove the show-menu class
    navMenu.classList.remove('show-menu')
}
navLink.forEach(n => n.addEventListener('click', linkAction))

/*=============== CHANGE BACKGROUND HEADER ===============*/
const scrollHeader = () =>{
    const header = document.getElementById('header')
    // When the scroll is greater than 50 viewport height, add the scroll-header class to the header tag
    this.scrollY >= 50 ? header.classList.add('scroll-header') 
                       : header.classList.remove('scroll-header')
}
window.addEventListener('scroll', scrollHeader)

/*=============== TESTIMONIAL SWIPER ===============*/
let testimonialSwiper = new Swiper(".testimonial-swiper", {
    spaceBetween: 30,
    loop: 'true',

    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
});

/*=============== NEW SWIPER ===============*/
let newSwiper = new Swiper(".new-swiper", {
    spaceBetween: 24,
    loop: 'true',

    breakpoints: {
        576: {
          slidesPerView: 2,
        },
        768: {
          slidesPerView: 3,
        },
        1024: {
          slidesPerView: 4,
        },
    },
});

/*=============== SCROLL SECTIONS ACTIVE LINK ===============*/
const sections = document.querySelectorAll('section[id]')
    
const scrollActive = () =>{
  	const scrollDown = window.scrollY

	sections.forEach(current =>{
		const sectionHeight = current.offsetHeight,
			  sectionTop = current.offsetTop - 58,
			  sectionId = current.getAttribute('id'),
			  sectionsClass = document.querySelector('.nav__menu a[href*=' + sectionId + ']')

		if(scrollDown > sectionTop && scrollDown <= sectionTop + sectionHeight){
			sectionsClass.classList.add('active-link')
		}else{
			sectionsClass.classList.remove('active-link')
		}                                                    
	})
}
window.addEventListener('scroll', scrollActive)

/*=============== SHOW SCROLL UP ===============*/ 
const scrollUp = () =>{
	const scrollUp = document.getElementById('scroll-up')
    // When the scroll is higher than 350 viewport height, add the show-scroll class to the a tag with the scrollup class
	this.scrollY >= 350 ? scrollUp.classList.add('show-scroll')
						: scrollUp.classList.remove('show-scroll')
}
window.addEventListener('scroll', scrollUp)

/*=============== SHOW CART ===============*/
const cart = document.getElementById('cart'),
      cartShop = document.getElementById('cart-shop'),
      cartClose = document.getElementById('cart-close')

/*===== CART SHOW =====*/
/* Validate if constant exists */
if(cartShop){
    cartShop.addEventListener('click', () =>{
        cart.classList.add('show-cart')
    })
}

/*===== CART HIDDEN =====*/
/* Validate if constant exists */
if(cartClose){
    cartClose.addEventListener('click', () =>{
        cart.classList.remove('show-cart')
    })
}

/*=============== DARK LIGHT THEME ===============*/ 
const themeButton = document.getElementById('theme-button')
const darkTheme = 'dark-theme'
const iconTheme = 'bx-sun'

// Previously selected topic (if user selected)
const selectedTheme = localStorage.getItem('selected-theme')
const selectedIcon = localStorage.getItem('selected-icon')

// We obtain the current theme that the interface has by validating the dark-theme class
const getCurrentTheme = () => document.body.classList.contains(darkTheme) ? 'dark' : 'light'
const getCurrentIcon = () => themeButton.classList.contains(iconTheme) ? 'bx bx-moon' : 'bx bx-sun'

// We validate if the user previously chose a topic
if (selectedTheme) {
  // If the validation is fulfilled, we ask what the issue was to know if we activated or deactivated the dark
  document.body.classList[selectedTheme === 'dark' ? 'add' : 'remove'](darkTheme)
  themeButton.classList[selectedIcon === 'bx bx-moon' ? 'add' : 'remove'](iconTheme)
}

// Activate / deactivate the theme manually with the button
themeButton.addEventListener('click', () => {
    // Add or remove the dark / icon theme
    document.body.classList.toggle(darkTheme)
    themeButton.classList.toggle(iconTheme)
    // We save the theme and the current icon that the user chose
    localStorage.setItem('selected-theme', getCurrentTheme())
    localStorage.setItem('selected-icon', getCurrentIcon())
})



    // Function to toggle sign in link and user icon based on sign-in status
    function toggleSignIn() {
      var signInLink = document.getElementById('signin-link');
      var userIcon = document.querySelector('.fa fa-user');

      // Check if user is signed in (you can replace this with your actual sign-in logic)
      var isSignedIn = false; // Example: Assume user is not signed in initially

      if (isSignedIn) {
        signInLink.style.display = 'none'; // Hide sign in link
        userIcon.style.display = 'inline-block'; // Display user icon
      } else {
        signInLink.style.display = 'inline-block'; // Display sign in link
        userIcon.style.display = 'none'; // Hide user icon
      }
    }

    // Call toggleSignIn function when the page loads
    window.onload = toggleSignIn;
  
  
  
//  reivew form star selection

const products = {
    "donuts": ["Glazed Donut", "Chocolate Donut", "Strawberry Donut"],
    "cakes": ["Chocolate Cake", "Vanilla Cake", "Strawberry Cake"],
    "beverages": ["Coffee", "Tea", "Juice"],
    "sundae": ["Chocolate Sundae", "Strawberry Sundae", "Vanilla Sundae"]
};

function showCategories() {
    const categoriesDiv = document.getElementById("categories");
    let html = "";

    ['donuts', 'cakes', 'beverages', 'sundae'].forEach(category => {
        html += `
            <div class="category">
                <label class="category-label">${category.charAt(0).toUpperCase() + category.slice(1)}</label>
                <select name="${category}" class="category-select" onchange="showProducts(this)">
                    <option value="0">Select ${category.charAt(0).toUpperCase() + category.slice(1)}</option>
                    ${products[category].map(product => `<option value="${product}">${product}</option>`).join('')}
                </select>
                <div class="products" id="${category}-products" style="display: none;">
                    <!-- Products will be displayed here -->
                </div>
            </div>
        `;
    });

    categoriesDiv.innerHTML = html;
}

function showProducts(selectElement) {
    const category = selectElement.value;
    const productsDiv = document.getElementById(`${selectElement.name}-products`);
    const categoryProducts = products[selectElement.name];

    if (category !== "0") {
        let html = '<div class="product">';
        categoryProducts.forEach(product => {
            html += `
                <label for="${product}">${product}:</label>
                <input type="number" name="${product}" id="${product}" min="0" placeholder="Quantity">
            `;
        });
        html += '</div>';
        productsDiv.innerHTML = html;
        productsDiv.style.display = "block";
    } else {
        productsDiv.style.display = "none";
    }
}

document.addEventListener("DOMContentLoaded", () => {
    showCategories();

    const eventForm = document.getElementById("eventForm");
    eventForm.addEventListener("submit", (event) => {
        event.preventDefault();
        let isValid = true;

        ['donuts', 'cakes', 'beverages', 'sundae'].forEach(category => {
            const categorySelect = eventForm.elements[category];
            const productsDiv = document.getElementById(`${category}-products`);

            if (categorySelect.value !== "0") {
                const selectedProducts = categorySelect.value.split(",");
                selectedProducts.forEach(product => {
                    const quantity = eventForm.elements[product.trim()].value;
                    if (quantity === "" || parseInt(quantity) <= 0) {
                        isValid = false;
                        alert(`Please enter a valid quantity for ${product.trim()}`);
                    }
                });
            }
        });

        if (isValid) {
            eventForm.submit();
        }
    });
});



//cake inquires
document.addEventListener("DOMContentLoaded", () => {
    const cakeForm = document.getElementById("cakeForm");

    cakeForm.addEventListener("submit", (event) => {
        event.preventDefault();

        const name = cakeForm.elements["name"].value;
        const email = cakeForm.elements["email"].value;
        const phone = cakeForm.elements["phone"].value;
        const cakeType = cakeForm.elements["cake-type"].value;
        const cakeSize = cakeForm.elements["cake-size"].value;
        const cakeFlavor = cakeForm.elements["cake-flavor"].value;
        const cakeMessage = cakeForm.elements["cake-message"].value;
        const cakeImage = cakeForm.elements["cake-image"].files[0];

        if (name === "" || email === "" || phone === "" || cakeType === "" || cakeSize === "" || cakeFlavor === "" || cakeMessage === "" || !cakeImage) {
            alert("Please fill in all fields and upload an image.");
            return;
        }

        const inquiryDetails = {
            Name: name,
            Email: email,
            Phone: phone,
            "Cake Type": cakeType,
            "Cake Size": cakeSize,
            "Cake Flavor": cakeFlavor,
            "Cake Message": cakeMessage,
            "Cake Image": cakeImage.name
        };

        console.log("Inquiry Details:", inquiryDetails);
        alert("Your inquiry has been submitted successfully!");
        cakeForm.reset();
    });
});

