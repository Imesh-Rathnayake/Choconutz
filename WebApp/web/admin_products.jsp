<%-- 
    Document   : admin_products
    Created on : Apr 28, 2024, 8:59:14 PM
    Author     : asus
--%>

<%@page import="java.io.File"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>





<%
        try {
            // Replace with your actual database connection details
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");

            if (request.getParameter("delete") != null) {
                int deleteId = Integer.parseInt(request.getParameter("delete"));

                // Get the image filename associated with the product
                PreparedStatement selectDeleteImage = conn.prepareStatement("SELECT image FROM products WHERE id = ?");
                selectDeleteImage.setInt(1, deleteId);
                ResultSet fetchDeleteImage = selectDeleteImage.executeQuery();
                if (fetchDeleteImage.next()) {
                    String imageToDelete = fetchDeleteImage.getString("image");

                    // Delete the image file from the server
                    File imageFile = new File(getServletContext().getRealPath("/") + "uploaded_img/" + imageToDelete);
                    if (imageFile.exists()) {
                        imageFile.delete();
                    }

                    // Delete the product from the database
                    PreparedStatement deleteProducts = conn.prepareStatement("DELETE FROM products WHERE id = ?");
                    deleteProducts.setInt(1, deleteId);
                    deleteProducts.executeUpdate();

                    // Also delete related entries from wishlist and cart tables
                    PreparedStatement deleteWishlist = conn.prepareStatement("DELETE FROM wishlist WHERE pid = ?");
                    deleteWishlist.setInt(1, deleteId);
                    deleteWishlist.executeUpdate();

                    PreparedStatement deleteCart = conn.prepareStatement("DELETE FROM cart WHERE pid = ?");
                    deleteCart.setInt(1, deleteId);
                    deleteCart.executeUpdate();

                    // Redirect to the product list page
                    response.sendRedirect("admin_products.jsp");
                } else {
                    out.println("Product not found.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>
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
   <title>products</title>

   <!-- font awesome cdn link  -->
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">

   <!-- custom css file link  -->
   <link rel="stylesheet" href="css/admin_style.css">

</head>
<body>
   
<%@ include file="admin_header.jsp" %>

<section class="add-products">
   <p><center>${requestScope.massage}</center></p>
   <h1 class="title">add new product</h1>

   <form action="adminServlets" method="POST" enctype="multipart/form-data">
      <div class="flex">
         <div class="inputBox">
         <input type="text" name="name" class="box" required placeholder="enter product name">
         <select name="category" class="box" required>
            <option value="" selected disabled>select category</option>
               <option value="vegitables">vegitables</option>
               <option value="fruits">fruits</option>
               <option value="meat">meat</option>
               <option value="fish">fish</option>
         </select>
         </div>
         <div class="inputBox">
         <input type="number" min="0" name="price" class="box" required placeholder="enter product price">
         <input type="file" name="image" required class="box" accept="image/jpg, image/jpeg, image/png">
         </div>
      </div>
      <textarea name="details" class="box" required placeholder="enter product details" cols="30" rows="10"></textarea>
      <input type="submit" class="btn" value="add product" name="add_product">
   </form>

</section>

 <section class="show-products">
        <h1 class="title">Products Added</h1>

        <%
            try {
                // Replace with your actual database connection details
              Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");
                PreparedStatement showProducts = conn.prepareStatement("SELECT * FROM products");
                ResultSet fetchProducts = showProducts.executeQuery();

                while (fetchProducts.next()) {
                    String name = fetchProducts.getString("name");
                    String category = fetchProducts.getString("category");
                    String details = fetchProducts.getString("details");
                    int price = fetchProducts.getInt("price");
                    String image = fetchProducts.getString("image");

                    // Print product details (for debugging)
//                    out.println("Name: " + name + ", Category: " + category + ", Price: $" + price);

                    // Display product information (modify as needed)
        %>
                    <div class="box-container">
                        <div class="box">
                            <div class="price">$<%= price %>/-</div>
                            <img src="uploaded_img/<%= image %>" alt="<%= name %>">
                            <div class="name"><%= name %></div>
                            <div class="cat"><%= category %></div>
                            <div class="details"><%= details %></div>
                            <div class="flex-btn">
                                <a href="admin_update_product.jsp?update=<%= fetchProducts.getInt("id") %>" class="option-btn">Update</a>
                                <a href="admin_products.jsp?delete=<%= fetchProducts.getInt("id") %>" class="delete-btn" onclick="return confirm('Delete this product?');">Delete</a>
                            </div>
                        </div>
                    </div>
        <%
                }
            
            } catch (SQLException e) {
                e.printStackTrace();
            }
        %>
    </section>










<script src="js/script.js"></script>

</body>
</html>
