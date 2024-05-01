<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.Connection"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%
    // Include your database configuration file here
    // ...

    // Check if the admin is logged in
//    Object adminIdObj = session.getAttribute("admin_id");
//    if (adminIdObj == null) {
//        response.sendRedirect("login.jsp"); // Redirect to login page
//        return; // Stop further execution
//    }
//    String adminId = adminIdObj.toString();
%>
<%
    // Establish database connection (replace with your actual database details)
    String dbUrl = "jdbc:mysql://localhost:3306/choconuts";
    String dbUser = "root";
    String dbPassword = "";

    Connection connection = null;
    PreparedStatement updateStatement = null;
    PreparedStatement deleteStatement = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

        // Update operation (if update_order parameter is present)
        if (request.getParameter("update_order") != null) {
            String order_id = request.getParameter("order_id");
            String update_payment = request.getParameter("update_payment");
            // Sanitize update_payment if needed
            String updateQuery = "UPDATE orders SET payment_status = ? WHERE id = ?";
            updateStatement = connection.prepareStatement(updateQuery);
            updateStatement.setString(1, update_payment);
            updateStatement.setString(2, order_id);
            updateStatement.executeUpdate();
            // Add relevant messages to the message list
        }

        // Delete operation (if delete parameter is present)
        if (request.getParameter("delete") != null) {
            String delete_id = request.getParameter("delete");
            String deleteQuery = "DELETE FROM orders WHERE id = ?";
            deleteStatement = connection.prepareStatement(deleteQuery);
            deleteStatement.setString(1, delete_id);
            deleteStatement.executeUpdate();
            response.sendRedirect("admin_orders.jsp"); // Redirect to admin_orders.jsp
        }
    }
  catch (Exception e) {
        e.printStackTrace();
    } 
%>


<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>orders</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/admin_style.css">

</head>
<body>
   
<%@ include file="admin_header.jsp" %>

<section class="placed-orders">

   <h1 class="title">placed orders</h1>

   <div class="box-container">

      <%-- Display orders --%>
      <%
         try {
            // Establish database connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
            System.out.println(conn);
            PreparedStatement select_orders = conn.prepareStatement("SELECT * FROM orders");
            ResultSet ordersResultSet = select_orders.executeQuery();
            
            boolean hasOrders = false; // Flag to track if there are orders
            
            while (ordersResultSet.next()) {
               hasOrders = true; // Set the flag to true if there are orders
               
               int orderId = ordersResultSet.getInt("id");
               String userId = ordersResultSet.getString("user_id");
               String placedOn = ordersResultSet.getString("placed_on");
               String name = ordersResultSet.getString("name");
               String email = ordersResultSet.getString("email");
               String number = ordersResultSet.getString("number");
               String address = ordersResultSet.getString("address");
               String totalProducts = ordersResultSet.getString("total_products");
               double totalPrice = ordersResultSet.getDouble("total_price");
               String paymentMethod = ordersResultSet.getString("method");
               String paymentStatus = ordersResultSet.getString("payment_status");
                RequestDispatcher dispatcher;
                
               System.out.println(orderId);
      %>
      <div class="box">
         <p> user id : <span><%= userId %></span> </p>
         <p> placed on : <span><%= placedOn %></span> </p>
         <p> name : <span><%= name %></span> </p>
         <p> email : <span><%= email %></span> </p>
         <p> number : <span><%= number %></span> </p>
         <p> address : <span><%= address %></span> </p>
         <p> total products : <span><%= totalProducts %></span> </p>
         <p> total price : <span>$<%= totalPrice %>/-</span> </p>
         <p> payment method : <span><%= paymentMethod %></span> </p>
         <form action="" method="POST">
            <input type="hidden" name="order_id" value="<%= orderId %>">
            <select name="update_payment" class="drop-down">
               <option value="" selected disabled><%= paymentStatus %></option>
               <option value="pending">pending</option>
               <option value="completed">completed</option>
            </select>
            <div class="flex-btn">
               <input type="submit" name="update_order" class="option-btn" value="udate">
               <a href="admin_orders.jsp?delete=<%= orderId %>" class="delete-btn" onclick="return confirm('delete this order?');">delete</a>
            </div>
         </form>
      </div>
      <%
            }
            
            if (!hasOrders) {
      %>
      <p class="empty">no orders placed yet!</p>
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
