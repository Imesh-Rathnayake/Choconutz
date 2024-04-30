<%-- 
    Document   : contactus
    Created on : Apr 23, 2024, 2:21:41 PM
    Author     : S & D COMPUTERS
--%>

<%@ include file="jsp/header.jsp"%>





<style>
  
  
  .main-content {
    padding: 20px;
    max-width: 800px;
    margin: auto;
  }
  .support-form {
    background-color: #ffffff;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  }
  .form-group {
    margin-bottom: 15px;
  }



  label {
    display: block;
    margin-bottom: 5px;
  }
  input[type="text"],
  input[type="email"],
  textarea {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  placeholder {
  opacity: 100; 
}
  button {
    background-color: #363636;
    color: #ffffff;
    padding: 10px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
  }
  button:hover {
    background-color: #595959;
  }
</style>
</head>
<body>



<div class="main-content"><br><br><br><br><br><br>
  <div class="support-form">
    <h2><center>Customer Support</center></h2>
    <form action="cussup" method="POST">
      <div class="form-group">
        <label for="name">Your Name</label>
        <input type="text" id="name" name="yname"  >
      </div>
      <div class="form-group">
        <label for="email">Your Email</label>
        <input type="email" id="email" name="yemail"  >
      </div>
      <div class="form-group">
        <label for="message">Your Message</label>
        <textarea id="message" name="ymessage" rows="4"  ></textarea>
      </div>
      <button type="submit">Send Message</button>
    </form>
  </div>
</div>

</body>




<%@ include file="jsp/footer.jsp"%>