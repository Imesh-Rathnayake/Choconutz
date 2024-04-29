<%-- 
    Document   : admin_users
    Created on : Apr 29, 2024, 12:14:04 PM
    Author     : asus
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Include your database configuration file here
    // ...

    // Check if the admin is logged in
//    if (session.getAttribute("admin_id") == null) {
//        response.sendRedirect("login.jsp"); // Redirect to login page
//        return; // Stop further execution
//    }
%>

<%
    
//    String admin_id = (String) session.getAttribute("admin_id");

//    if(admin_id == null) {
//        response.sendRedirect("login.jsp");
//    }

    if(request.getParameter("delete") != null) {
        int delete_id = Integer.parseInt(request.getParameter("delete"));
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
            PreparedStatement delete_users = conn.prepareStatement("DELETE FROM users WHERE id = ?");
            delete_users.setInt(1, delete_id);
            delete_users.executeUpdate();
            response.sendRedirect("admin_users.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
%>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>users</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/admin_style.css">

</head>
<body>
   
<%@ include file="admin_header.jsp" %>





  <section class="user-accounts">
        <h1 class="title">User Accounts</h1>
        <div class="box-container">
            <%
//                int admin_id =(Integer) session.getAttribute("admin_id");
        int admin_id = 123;
    try {
        Class.forName("com.mysql.jdbc.Driver");
        // Establish database connection (replace with your actual database details)
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts","root","");
        PreparedStatement selectUsers = conn.prepareStatement("SELECT * FROM users");
        ResultSet usersResultSet = selectUsers.executeQuery();
        
        while (usersResultSet.next()) {
            int userId = usersResultSet.getInt("id");
            String name = usersResultSet.getString("name");
            String email = usersResultSet.getString("email");
             String phoneNumber = usersResultSet.getString("phone_number");
            String userType = usersResultSet.getString("user_type");
            String image = usersResultSet.getString("image");
%>
<div class="box" style="<%= (userId == admin_id) ? "display:none;" : "" %>">
    <img src="uploaded_img/<%= image %>" alt="">
    <p> user id : <span><%= userId %></span></p>
    <p> username : <span><%= name %></span></p>
    <p> email : <span><%= email %></span></p>
    <p> phone number : <span><%= phoneNumber %></span></p>
    <p> user type : <span style=" color:<%= (userType.equals("admin")) ? "orange" : "" %>"><%= userType %></span></p>
    <a href="admin_users.jsp?delete=<%= userId %>" onclick="return confirm('delete this user?');" class="delete-btn">delete</a>
</div>
<%
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
        </div>
    </section>















<script src="js/script.js"></script>

</body>
</html>
