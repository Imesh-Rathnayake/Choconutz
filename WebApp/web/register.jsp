<%@ include file="jsp/header.jsp"%>
<div class="login-container">
<div class="wrapper">
    <%
String message = (String)request.getAttribute("message");
out.println("<p>" + message + "</p>");
%>

<form action="customerRegisterServlet" method="post">
      <h1>Register</h1>
      <div class="input-box">
          <input type="text" placeholder="user name" name="uname" required="">
      </div>
      <div class="input-box">
          <input type="email" placeholder="email" name="email" required="">
      </div>  
       <div class="input-box">
          <input type="text" placeholder="phone number" name="phone" required="">
      </div>
      <div class="input-box">
          <input type="password" placeholder="Enter Password" name="pwd" required="">
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