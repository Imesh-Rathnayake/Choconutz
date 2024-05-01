<%-- 
    Document   : signup
    Created on : Apr 4, 2024, 1:49:37 AM
    Author     : ishankacharuka
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="signup.css"/>
        
        <title>Admin sign up</title>
        <script>
        function validateForm() {
            var email = document.getElementById("email").value;
            var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            if (!emailRegex.test(email)) {
                alert("Please enter a valid email address");
                return false;
            }
            return true;
        }
    </script>
    </head>
    <body>
     <center><div class="form-box">
             <form class="form" action="Signup" method="GET">
        <span class="title">Sign up</span>
        <span class="subtitle">Create admin account.</span>
        <div class="form-container">
            <input type="text" class="input" placeholder="Userame" name="un">
            <input type="email" class="input" placeholder="E mail" name="email">
            <input type="password" class="input" placeholder="Password" name="pass">
            <input type="password" class="input" placeholder="Confirm Password" name="con_pass">
            
        </div>
        <input type="submit" value="sub" />
        </form>
         <div class="form-section">
         <p>Have an account? <a href="signin.jsp">Sign in </a> </p>
         </div>
     </div></center>
    </body>
</html>
<!--onsubmit="return validateForm()-->