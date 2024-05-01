<%-- 
    Document   : signin
    Created on : Apr 4, 2024, 1:20:29 AM
    Author     : ishankacharuka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="signin.css">
        
        <title>Admin SignIn </title>
    </head>
    <body>
    <center>
        <div class="form-box">
            <form class="form" action="Signin" method="GET">
            <span class="title">Sign In</span>
            <span class="subtitle">Sign in admin account.</span>
            <div class="form-container">
                <input type="text" class="input" placeholder="Username" name="un">
                <input type="password" class="input" placeholder="Password" name="pass">
            </div>
            <button>Sign In</button>
       </form>
       <div class="form-section">
  
      <p>
        No account?
        <a href="signup.jsp">Sign up</a>
      </p>
      </div>
      </div>
    </center>

        
       

    </body>
</html>
