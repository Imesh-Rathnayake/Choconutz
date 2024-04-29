<%-- 
    Document   : admin_page
    Created on : Apr 28, 2024, 7:56:39 PM
    Author     : asus
--%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    // Include your database configuration file here
    // ...

    // Check if the admin is logged in
//    if (session.getAttribute("admin_id") == null) {
//        response.sendRedirect("login.jsp"); // Redirect to login page
//        return; // Stop further execution
//    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>admin page</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/admin_style.css">

</head>
<body>
   
<%@ include file="admin_header.jsp" %>

<section class="dashboard">

   <h1 class="title">dashboard</h1>

   <div class="box-container">

   <%
    double totalPendings = 0;
    try {
        // Replace this with your actual database connection and query
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
        PreparedStatement selectPendings = conn.prepareStatement("SELECT * FROM orders WHERE payment_status = ?");
        selectPendings.setString(1, "pending");
        ResultSet fetchPendings = selectPendings.executeQuery();
        while (fetchPendings.next()) {
            totalPendings += fetchPendings.getDouble("total_price");
        }
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
   %>

    <div class="box">
        <h3>$<%= totalPendings %>/-</h3>
        <p>total pendings</p>
        <a href="admin_orders.jsp" class="btn">see orders</a>
    </div>              

     <%
    double totalCompleted = 0;
    try {
        // Replace this with your actual database connection and query
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
        PreparedStatement selectCompleted = conn.prepareStatement("SELECT * FROM orders WHERE payment_status = ?");
        selectCompleted.setString(1, "completed");
        ResultSet fetchCompleted = selectCompleted.executeQuery();
        while (fetchCompleted.next()) {
            totalCompleted += fetchCompleted.getDouble("total_price");
        }
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
%>

        <div class="box">
            <h3>$<%= totalCompleted %>/-</h3>
            <p>completed orders</p>
            <a href="admin_orders.jsp" class="btn">see orders</a>
        </div>

            <%
           try {
               // Replace this with your actual database connection and query
               Class.forName("com.mysql.jdbc.Driver");
               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "username");
               PreparedStatement selectOrders = conn.prepareStatement("SELECT * FROM orders");
               ResultSet fetchOrders = selectOrders.executeQuery();
               int numberOfOrders = 0;
               while (fetchOrders.next()) {
                   numberOfOrders++;
               }
               conn.close();
       %>

       <div class="box">
           <h3><%= numberOfOrders %></h3>
           <p>orders placed</p>
           <a href="admin_orders.jsp" class="btn">see orders</a>
       </div>
       <%
           } catch (SQLException e) {
               e.printStackTrace();
           }
       %>

            <%
           try {
               // Replace this with your actual database connection and query
               Class.forName("com.mysql.jdbc.Driver");
               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
               PreparedStatement selectProducts = conn.prepareStatement("SELECT * FROM products");
               ResultSet fetchProducts = selectProducts.executeQuery();
               int numberOfProducts = 0;
               while (fetchProducts.next()) {
                   numberOfProducts++;
               }
               conn.close();
       %>

       <div class="box">
           <h3><%= numberOfProducts %></h3>
           <p>products added</p>
           <a href="admin_products.jsp" class="btn">see products</a>
       </div>
       <%
           } catch (SQLException e) {
               e.printStackTrace();
           }
       %>

       <%-- PHP code block for users count --%>
       <%
           try {
               // Replace this with your actual database connection and query
               Class.forName("com.mysql.jdbc.Driver");
               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
               PreparedStatement selectUsers = conn.prepareStatement("SELECT * FROM users WHERE user_type = ?");
               selectUsers.setString(1, "user");
               ResultSet fetchUsers = selectUsers.executeQuery();
               int numberOfUsers = 0;
               while (fetchUsers.next()) {
                   numberOfUsers++;
               }
               conn.close();
       %>

       <div class="box">
           <h3><%= numberOfUsers %></h3>
           <p>total users</p>
           <a href="admin_users.jsp" class="btn">see accounts</a>
       </div>
       <%
           } catch (SQLException e) {
               e.printStackTrace();
           }
       %>

            <%
          try {
              // Replace this with your actual database connection and query
              Class.forName("com.mysql.jdbc.Driver");
              Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
              PreparedStatement selectAdmins = conn.prepareStatement("SELECT * FROM users WHERE user_type = ?");
              selectAdmins.setString(1, "admin");
              ResultSet fetchAdmins = selectAdmins.executeQuery();
              int numberOfAdmins = 0;
              while (fetchAdmins.next()) {
                  numberOfAdmins++;
              }
              conn.close();
      %>

        <div class="box">
            <h3><%= numberOfAdmins %></h3>
            <p>total admins</p>
            <a href="admin_users.jsp" class="btn">see accounts</a>
        </div>
        <%
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>

<%-- PHP code block for total accounts count --%>
        <%
            try {
                // Replace this with your actual database connection and query
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
                PreparedStatement selectAccounts = conn.prepareStatement("SELECT * FROM users");
                ResultSet fetchAccounts = selectAccounts.executeQuery();
                int numberOfAccounts = 0;
                while (fetchAccounts.next()) {
                    numberOfAccounts++;
                }
                conn.close();
        %>

        <div class="box">
            <h3><%= numberOfAccounts %></h3>
            <p>total accounts</p>
            <a href="admin_users.jsp" class="btn">see accounts</a>
        </div>
        <%
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>

        <%-- PHP code block for total messages count --%>
        <%
            try {
                // Replace this with your actual database connection and query
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
                PreparedStatement selectMessages = conn.prepareStatement("SELECT * FROM message");
                ResultSet fetchMessages = selectMessages.executeQuery();
                int numberOfMessages = 0;
                while (fetchMessages.next()) {
                    numberOfMessages++;
                }
                conn.close();
        %>

        <div class="box">
            <h3><%= numberOfMessages %></h3>
            <p>total messages</p>
            <a href="admin_contacts.jsp" class="btn">see messages</a>
        </div>
        <%
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>

   </div>

</section>













<script src="js/script.js"></script>

</body>
</html>
