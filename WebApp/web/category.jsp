<%-- 
    Document   : category
    Created on : Apr 30, 2024, 6:51:59 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        
 <%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ include file="jsp/header.jsp"%>



<section class="p section container" id="p">
    <h2 class="section__title">
        <%=request.getParameter("category")%>
        <p><center>${requestScope.message}</center></p>
    </h2>
        
    <div class="p__container grid" >
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
            String query = "SELECT * FROM products WHERE category = ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, category);

            // Execute the query
            rs = pstmt.executeQuery();

            // Iterate through the result set
            while (rs.next()) {
                String productName = rs.getString("name");
                int productPrice = rs.getInt("price");
                String productImage = rs.getString("image");
                String productDetails = rs.getString("details");
                int productId = rs.getInt("id");
                String cate = rs.getString("category");
        %>

        <form action="addcartServlet" method="post" onsubmit="return addToCart('<%= userId %>')">
            <article class="p__card1" >
                <img  src="uploaded_img/<%= productImage %>" alt=""
                    class="p__img">
                <input type="hidden" name="user_id" value="<%= userId %>">
                <input type="hidden" name="pId" value="<%= productId %>">
                <input type="hidden" name="image" value="<%= productImage %>">
                <input type="hidden" name="name" value="<%= productName %>">
                <input type="hidden" name="price" value="<%= productPrice %>">
                 <input type="hidden" name="cate" value="<%= cate %>">
                <input style="border: none;border-radius: 5px; padding:5px;margin:7px 9px; " type="number" name="quantity" value="1" min="1">
                <h3 class="p__title"><%=productName %></h3>
                <h5 style="color:#b45f06;"><%=productDetails %></h5>
                <span  class="p__price">Rs <%= productPrice %></span>

                <button class="p__button" type="submit">
                    <i class='bx bx-shopping-bag'></i>
                </button>
            </article>
        </form>

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
    </div>
</section>

<script>
    function addToCart(userId) {
        if (!userId) {
            alert("Please login to add items to the cart.");
            return false; // Prevent form submission
        }
        return true; // Allow form submission
    }
</script>
 
 <%@ include file="jsp/footer.jsp"%>
