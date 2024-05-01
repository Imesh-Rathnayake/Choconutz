<%-- 
    Document   : admin_contacts
    Created on : Apr 29, 2024, 12:42:19 PM
    Author     : asus
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Include the configuration file
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
        
//        HttpSession session = request.getSession();
//        String admin_id = (String) session.getAttribute("admin_id");
//
//        if(admin_id == null) {
//            response.sendRedirect("login.jsp");
//        }

        if(request.getParameter("delete") != null) {
            int delete_id = Integer.parseInt(request.getParameter("delete"));
            PreparedStatement delete_message = conn.prepareStatement("DELETE FROM message WHERE id = ?");
            delete_message.setInt(1, delete_id);
            delete_message.executeUpdate();
            response.sendRedirect("admin_contacts.jsp");
        }
        
        conn.close(); // Close the database connection
    } catch (Exception e) {
        e.printStackTrace();
    }
%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>messages</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/admin_style.css">

</head>
<body>
   
<%@ include file="admin_header.jsp" %>

<section class="messages">

   <h1 class="title">messages</h1>

   <div class="box-container">

   <%
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
        
        PreparedStatement select_message = conn.prepareStatement("SELECT * FROM message");
        ResultSet messageResultSet = select_message.executeQuery();
        
        boolean hasMessages = false; // Flag to track if there are messages
        
        while (messageResultSet.next()) {
            hasMessages = true; // Set the flag to true if there are messages
            
            int messageId = messageResultSet.getInt("id");
            String userId = messageResultSet.getString("user_id");
            String name = messageResultSet.getString("name");
            String number = messageResultSet.getString("number");
            String email = messageResultSet.getString("email");
            String message = messageResultSet.getString("message");
%>
<div class="box">
    <p> user id : <span><%= userId %></span> </p>
    <p> name : <span><%= name %></span> </p>
    <p> number : <span><%= number %></span> </p>
    <p> email : <span><%= email %></span> </p>
    <p> message : <span><%= message %></span> </p>
    <a href="admin_contacts.jsp?delete=<%= messageId %>" onclick="return confirm('delete this message?');" class="delete-btn">delete</a>
</div>
<%
        }
        
        if (!hasMessages) {
%>
<p class="empty">you have no messages!</p>
<%
        }
        
        conn.close(); // Close the database connection
    } catch (Exception e) {
        e.printStackTrace();
    }
%>

   </div>

</section>













<script src="js/script.js"></script>

</body>
</html>
