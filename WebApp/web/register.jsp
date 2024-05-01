<%@ include file="jsp/header.jsp"%>
<div class="login-container">
<div class="wrapper">
    
    
    <form action="customerRegisterServlet" method="post">
        <p><center> ${requestScope.message}<center></p>

      <h1>Register</h1>
      <div class="input-box">
          <input type="text" placeholder="User Name" required="" name="uname">
      </div>
      <div class="input-box">
          <input type="email" placeholder="Enter Email" required="" name="email" >
      </div> 
      <div class="input-box">
          <input type="phone" placeholder="Enter phone number" required="" name="phone" >
      </div>  
      <div class="input-box">
          <input type="password" placeholder="Enter Password" required="" name="pwd">
      </div>
      <div class="input-box">
        <input type="password" placeholder="Re-Enter Password" required="">
        
      </div>
      <div class="remember-forgot">
        <label><input type="checkbox">Remember Me</label>
      </div>
      <button type="submit" class="btn">Register</button>
    </form>
  </div>
   </div>
    
<%@ include file="jsp/footer.jsp"%>