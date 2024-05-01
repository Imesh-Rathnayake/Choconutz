<%@page import="java.sql.SQLException"%>
<%@ include file="jsp/header.jsp"%>




<section class="placed-orders">

    <h1 class="title">PLACED ORDERS</h1>
  
       <%
        // Establish connection to the database
        Integer userId = (Integer) session.getAttribute("user_id");
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String category = request.getParameter("category");
        try {
            // Get a DataSource using JNDI lookup
           // Update 'your_datasource' with your actual DataSource name

            // Establish a connection
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");


            // Prepare SQL query
            String query = "SELECT * FROM orders WHERE user_id = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, userId);
            rs =pstmt.executeQuery();
            while(rs.next())
            {
             %>
       
    <div class="box-container">
    <div class="box">
      <p>Placed on: <span><%= rs.getString("placed_on") %></span></p>
      <p>Name: <span><%= rs.getString("name") %></span></p>
      <p>Number: <span><%=rs.getString("number") %></span></p>
      <p>Email: <span><%= rs.getString("email") %></span></p>
      <p>Address: <span><%= rs.getString("address") %></span></p>
      <p>Payment Method: <span><%= rs.getString("method") %></span></p>
      <p>Your Orders: <span><%= rs.getString("total_products") %></span></p>
      <p>Total Price: <span>$<%= rs.getInt("total_price") %>/-</span></p>
      <p>Payment Status: <span style="color:<%= rs.getString("payment_status").equals("pending") ? "red" : "green" %>;"><%= rs.getString("payment_status") %></span></p>
   </div>
   
   </div>  
      
    <%
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        %>


</section>



    
<%@ include file="jsp/footer.jsp"%>