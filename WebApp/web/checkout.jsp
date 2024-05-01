<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>


<%
// Load MySQL JDBC Driver
try{
    Class.forName("com.mysql.jdbc.Driver");

// Establish database connection
String url = "jdbc:mysql://localhost:3306/choconuts";
String username = "root";
String password = ""; // Replace with your MySQL password
Connection conn = DriverManager.getConnection(url, username, password);

// Start session

Integer userId = (Integer) session.getAttribute("user_id");

// Redirect to login page if user is not logged in
if (userId == null) {
    response.sendRedirect("login.jsp");
}

if (request.getParameter("order") != null) {
    String name = request.getParameter("name");
    String number = request.getParameter("number");
    String email = request.getParameter("email");
    String method = request.getParameter("method");
    String flat = request.getParameter("flat");
    String street = request.getParameter("street");
    String city = request.getParameter("city");
    String state = request.getParameter("state");
    String province = request.getParameter("province");
    String pinCode = request.getParameter("pin_code");
    String address = "flat no. " + flat + " " + street + " " + city + " " + state + " " + province + " - " + pinCode;

    // Get cart items
    int cartTotal = 0;
    StringBuilder cartProducts = new StringBuilder();
    PreparedStatement cartStmt = conn.prepareStatement("SELECT * FROM cart WHERE user_id = ?");
    cartStmt.setInt(1, userId);
    ResultSet cartRs = cartStmt.executeQuery();
    while (cartRs.next()) {
        String productName = cartRs.getString("name");
        int productPrice = cartRs.getInt("price");
        int quantity = cartRs.getInt("quantity");
        cartProducts.append(productName).append(" (").append(productPrice).append(" x ").append(quantity).append("), ");
        int subTotal = productPrice * quantity;
        cartTotal += subTotal;
    }

    String totalProducts = cartProducts.toString();
    String placedOn = new SimpleDateFormat("dd-MMM-yyyy").format(new Date());

    if (cartTotal == 0) {
        out.println("<p class=\"empty\">Your cart is empty!</p>");
    } else {
        PreparedStatement orderStmt = conn.prepareStatement("INSERT INTO orders (user_id, name, number, email, method, address, total_products, total_price, placed_on) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
        orderStmt.setInt(1, userId);
        orderStmt.setString(2, name);
        orderStmt.setString(3, number);
        orderStmt.setString(4, email);
        orderStmt.setString(5, method);
        orderStmt.setString(6, address);
        orderStmt.setString(7, totalProducts);
        orderStmt.setInt(8, cartTotal);
        orderStmt.setString(9, placedOn);
        orderStmt.executeUpdate();

        // Delete items from cart
        PreparedStatement deleteCartStmt = conn.prepareStatement("DELETE FROM cart WHERE user_id = ?");
        deleteCartStmt.setInt(1, userId);
        deleteCartStmt.executeUpdate();

        out.println("<p>Order placed successfully!</p>");
    }
}


// Close database connectio
%>

<%@ include file="jsp/header.jsp"%>
   <% 
   int cartGrandTotal = 0;
   PreparedStatement selectCartStmt = conn.prepareStatement("SELECT * FROM cart WHERE user_id = ?");
   selectCartStmt.setInt(1, userId);
   ResultSet selectCartRs = selectCartStmt.executeQuery();
   if (selectCartRs.next()) {
       do {
           String cartItemName = selectCartRs.getString("name");
           int cartItemPrice = selectCartRs.getInt("price");
           int cartItemQuantity = selectCartRs.getInt("quantity");
           int cartTotalPrice = cartItemPrice * cartItemQuantity;
           cartGrandTotal += cartTotalPrice;
   %>
<section class="display-orders">
 <p> <%= cartItemName %> <span>(<%= "Rs" + cartItemPrice + "/- x " + cartItemQuantity %>)</span> </p>
   <% 
       } while (selectCartRs.next());
   } else {
       out.println("<p class=\"empty\">Your cart is empty!</p>");
   }


   %>
   <div class="grand-total">Grand total: <span>$<%= cartGrandTotal %>/-</span></div>
</section>

<%
  }catch(Exception e){
     System.out.println(e.getMessage());
}

%>

<section class="checkout-orders">

    <form action="" method="post" class="checkout-form">

      <h3>place your order</h3>

      <div class="flex">
         <div class="inputBox">
            <span>your name :</span>
            <input type="text" name="name" placeholder="enter your name" class="box" required>
         </div>
         <div class="inputBox">
            <span>your phone number :</span>
            <input type="number" name="number" placeholder="enter your number" class="box" required>
         </div>
         <div class="inputBox">
            <span>your email :</span>
            <input type="email" name="email" placeholder="enter your email" class="box" required>
         </div>
         <div class="inputBox">
            <span>payment method :</span>
            <select name="method" class="box" required>
               <option value="cash on delivery">cash on delivery</option>
               <option value="credit card">credit card</option>
               <option value="paytm">paytm</option>
               <option value="paypal">paypal</option>
            </select>
         </div>
         <div class="inputBox">
            <span>address line 01 :</span>
            <input type="text" name="flat" placeholder="e.g. flat number" class="box" required>
         </div>
         <div class="inputBox">
            <span>address line 02 :</span>
            <input type="text" name="street" placeholder="e.g. street name" class="box" required>
         </div>
         <div class="inputBox">
            <span>city :</span>
            <input type="text" name="city" placeholder="e.g. kaluthara" class="box" required>
         </div>
         <div class="inputBox">
            <span>state :</span>
            <input type="text" name="state" placeholder="" class="box" required>
         </div>
         <div class="inputBox">
            <span>province :</span>
            <input type="text" name="province" placeholder="e.g. westen" class="box" required>
         </div>
         <div class="inputBox">
            <span>pin code :</span>
            <input type="number" min="0" name="pin_code" placeholder="e.g. 123456" class="box" required>
         </div>
      </div>

      <input type="submit" name="order" class="btn <?= ($cart_grand_total > 1)?'':'disabled'; ?>" value="place order">

   </form>

</section>

    
<%@ include file="jsp/footer.jsp"%>