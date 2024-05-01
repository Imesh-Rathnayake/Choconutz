<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        
 <%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>


<%
   
    Integer user_id = (Integer) session.getAttribute("user_id");


    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList<String> messages = new ArrayList<String>();

    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");

        if (request.getParameter("delete") != null) {
            int delete_id =Integer.parseInt(request.getParameter("delete"));
            pstmt = conn.prepareStatement("DELETE FROM cart WHERE id = ?");
            pstmt.setInt(1, delete_id);
            pstmt.executeUpdate();
            response.sendRedirect("cart.jsp");
        }

        if (request.getParameter("delete_all") != null) {
            pstmt = conn.prepareStatement("DELETE FROM cart WHERE user_id = ?");
            pstmt.setInt(1, user_id);
            pstmt.executeUpdate();
            response.sendRedirect("cart.jsp");
        }

        if (request.getParameter("update_qty") != null) {
            String cart_id = request.getParameter("cart_id");
            String p_qty = request.getParameter("p_qty");
            pstmt = conn.prepareStatement("UPDATE cart SET quantity = ? WHERE id = ?");
            pstmt.setString(1, p_qty);
            pstmt.setString(2, cart_id);
            pstmt.executeUpdate();
            messages.add("Cart quantity updated");
        }

        pstmt = conn.prepareStatement("SELECT * FROM cart WHERE user_id = ?");
        pstmt.setInt(1, user_id);
        rs = pstmt.executeQuery();

        double grand_total = 0;

%>
<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>Shopping Cart</title>

   <!-- Font Awesome CDN link -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

   <!-- Custom CSS file link -->
   <link rel="stylesheet" href="css/style.css">

</head>
<body>
   
<%@ include file="jsp/header.jsp" %>

<section class="shopping-cart">

   <h1 class="title">Products Added</h1>

   <div class="box-container">

   <%
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");
            String image = rs.getString("image");
            int quantity = rs.getInt("quantity");
            double sub_total = price * quantity;
            grand_total += sub_total;
   %>
   <form action="" method="POST" class="box">
      <a href="cart.jsp?delete=<%=id%>" class="fas fa-times" onclick="return confirm('Delete this from cart?');"></a>

      <img src="uploaded_img/<%= image %>" alt="">
      <div class="name"><%= name %></div>
      <div class="price">$<%= price %>/-</div>
      <input type="hidden" name="cart_id" value="<%= id %>">
      <div class="flex-btn">
         <input type="number" min="1" value="<%= quantity %>" class="qty" name="p_qty">
         <input type="submit" value="update" name="update_qty" class="option-btn">
      </div>
      <div class="sub-total"> sub total : <span>$<%= sub_total %>/-</span> </div>
   </form>
   <%
        }
        if (!rs.next()) {
//            out.println("<p class=\"empty\">your cart is empty</p>");
        }
   %>
   </div>

   <div class="cart-total">
      <p>grand total : <span>$<%= grand_total %>/-</span></p>
      <a href="shop.jsp" class="option-btn">continue shopping</a>
      <a href="cart.jsp?delete_all" class="option-btn">delete all</a>
      <a href="checkout.jsp" class="option-btn">proceed to checkout</a>
   </div>

</section>



<%
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (rs != null) {
            try { rs.close(); } catch (SQLException e) { /* ignored */ }
        }
        if (pstmt != null) {
            try { pstmt.close(); } catch (SQLException e) { /* ignored */ }
        }
        if (conn != null) {
            try { conn.close(); } catch (SQLException e) { /* ignored */ }
        }
    }
%>
<%@ include file="jsp/footer.jsp" %>

<script src="js/script.js"></script>

</body>
</html>