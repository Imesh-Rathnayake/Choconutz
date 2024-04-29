<%-- 
    Document   : user_profile
    Created on : Apr 29, 2024, 11:31:19 PM
    Author     : asus
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<%@ include file="jsp/header.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>update user profile</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/components.css">

</head>
<body>
   

<p><center>${requestScope.message}</center></p>

<%
// Database connection
int userId =(Integer) session.getAttribute("user_id");
try {
    Class.forName("com.mysql.jdbc.Driver");
   Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");

    // Fetching data from database
    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users where id ='"+userId+"'"); // Update with your actual table name
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
        String name = rs.getString("name");
        String email = rs.getString("email");
        String phoneNumber =rs.getString("phone_number");
        String image = rs.getString("image");
%>

<section class="update-profile">
   <h1 class="title">Update Profile</h1>
   
   <form action="customerUptadeServlet" method="POST" enctype="multipart/form-data">
      <img src="uploaded_img/<%= image %>" alt="">
      <div class="flex">
         <div class="inputBox">
            
            <span>Username:</span>
            <input type="text" name="name" value="<%= name %>" placeholder="Update username" required class="box">
            
            <input type="hidden" name="id" value="<%= userId %>" placeholder=""  class="box">
            <span>Email:</span>
            <input type="email" name="email" value="<%= email %>" placeholder="Update email" required class="box">
            <span>Phone Number:</span>
            <input type="text" name="pnumber" value="<%= phoneNumber %>" placeholder="Update email" required class="box">
            <span>Update Pic:</span>
            <input type="file" name="image" accept="image/jpg, image/jpeg, image/png" class="box">
            <input type="hidden" name="old_image" value="<%= image %>">
         </div>
          <div class="inputBox">
            <!-- Assuming password is not fetched from database for security reasons -->
            <span>Old Password:</span>
            <input type="password" name="old_pass" placeholder="Enter previous password" class="box">
            <span>New Password:</span>
            <input type="password" name="new_pass" placeholder="Enter new password" class="box">
            <span>Confirm Password:</span>
            <input type="password" name="confirm_pass" placeholder="Confirm new password" class="box">
         </div>
        
      </div>
      <div class="flex-btn">
         <input type="submit" class="btn" value="UpdateDetails" name="update">
         <input type="submit" class="btn" value="UpdatePassword" name="update">
         <a href="index.jsp" class="option-btn">Go Back</a>
      </div>
   </form>
      
</section>

<%
    }
    rs.close();
    stmt.close();
    conn.close();
} catch (Exception e) {
    e.printStackTrace();
}
%>










<%@ include file="jsp/footer.jsp"%>


<script src="js/script.js"></script>

</body>
</html>
