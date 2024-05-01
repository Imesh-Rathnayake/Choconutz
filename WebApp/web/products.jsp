<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ include file="jsp/header.jsp"%>



<section class="p section container" id="p">
            <h2 class="section__title">
                DONUTS
            </h2>
      <div class="p__container grid">
<%
// Establish connection to the database

  Integer userId = (Integer) session.getAttribute("user_id");
Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

try {
    // Get a DataSource using JNDI lookup
   // Update 'your_datasource' with your actual DataSource name

    // Establish a connection
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");


    // Prepare SQL query
    String query = "SELECT * FROM products WHERE category = ?";
    pstmt = conn.prepareStatement(query);
    pstmt.setString(1, "donuts");

    // Execute the query
    rs = pstmt.executeQuery();

    // Iterate through the result set
    while (rs.next()) {
        String productName = rs.getString("name");
        double productPrice = rs.getInt("price");
        String productImage = rs.getString("image");
         String productDetails = rs.getString("details");

        // Output the retrieved data (you can format it as needed)
%>
        
                 
          
                <article class="p__card1">
                    <img src="uploaded_img/<%= productImage %>" alt="" class="p__img">

                    <h3 class="p__title"><%= productName %></h3>
                    <h5 style="color:#b45f06;"><%=productDetails %></h5>
                    <span class="p__price">Rs <%= productPrice %></span>

                    <button class="p__button">
                        <i class='bx bx-shopping-bag'></i>
                    </button>
                </article>
           
        
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
 
 <section class="p section container" id="p">
            <h2 class="section__title">
                CAKES
            </h2>
      <div class="p__container grid">
<%
// Establish connection to the database
        
try {
    // Get a DataSource using JNDI lookup
   // Update 'your_datasource' with your actual DataSource name

    // Establish a connection
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");


    // Prepare SQL query
    String query = "SELECT * FROM products WHERE category = ?";
    pstmt = conn.prepareStatement(query);
    pstmt.setString(1, "cakes");

    // Execute the query
    rs = pstmt.executeQuery();

    // Iterate through the result set
    while (rs.next()) {
        String productName = rs.getString("name");
        double productPrice = rs.getInt("price");
        String productImage = rs.getString("image");
         String productDetails = rs.getString("details");

        // Output the retrieved data (you can format it as needed)
%>
        
                 
          
                <article class="p__card1">
                    <img src="uploaded_img/<%= productImage %>" alt="" class="p__img">

                    <h3 class="p__title"><%= productName %></h3>
                    <h5 style="color:#b45f06;"><%=productDetails %></h5>
                    <span class="p__price">Rs <%= productPrice %></span>

                    <button class="p__button">
                        <i class='bx bx-shopping-bag'></i>
                    </button>
                </article>
           
        
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
 
 
 <section class="p section container" id="p">
            <h2 class="section__title">
               BEVERAGES
            </h2>
      <div class="p__container grid">
<%
// Establish connection to the database


try {
    // Get a DataSource using JNDI lookup
   // Update 'your_datasource' with your actual DataSource name

    // Establish a connection
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");


    // Prepare SQL query
    String query = "SELECT * FROM products WHERE category = ?";
    pstmt = conn.prepareStatement(query);
    pstmt.setString(1, "beverages");

    // Execute the query
    rs = pstmt.executeQuery();

    // Iterate through the result set
    while (rs.next()) {
        String productName = rs.getString("name");
        double productPrice = rs.getInt("price");
        String productImage = rs.getString("image");
         String productDetails = rs.getString("details");

        // Output the retrieved data (you can format it as needed)
%>
        
                 
          
                <article class="p__card1">
                    <img src="uploaded_img/<%= productImage %>" alt="" class="p__img">

                    <h3 class="p__title"><%= productName %></h3>
                    <h5 style="color:#b45f06;"><%=productDetails %></h5>
                    <span class="p__price">Rs <%= productPrice %></span>

                    <button class="p__button">
                        <i class='bx bx-shopping-bag'></i>
                    </button>
                </article>
           
        
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
 
 
 <section class="p section container" id="p">
            <h2 class="section__title">
               SUNDAES
            </h2>
      <div class="p__container grid">
<%
// Establish connection to the database

try {
    // Get a DataSource using JNDI lookup
   // Update 'your_datasource' with your actual DataSource name

    // Establish a connection
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");


    // Prepare SQL query
    String query = "SELECT * FROM products WHERE category = ?";
    pstmt = conn.prepareStatement(query);
    pstmt.setString(1, "sundaes");

    // Execute the query
    rs = pstmt.executeQuery();

    // Iterate through the result set
    while (rs.next()) {
        String productName = rs.getString("name");
        double productPrice = rs.getInt("price");
        String productImage = rs.getString("image");
         String productDetails = rs.getString("details");

        // Output the retrieved data (you can format it as needed)
%>
        
                 
          
                <article class="p__card1">
                    <img src="uploaded_img/<%= productImage %>" alt="" class="p__img">

                    <h3 class="p__title"><%= productName %></h3>
                    <h5 style="color:#b45f06;"><%=productDetails %></h5>
                    <span class="p__price">Rs <%= productPrice %></span>

                    <button class="p__button">
                        <i class='bx bx-shopping-bag'></i>
                    </button>
                </article>
           
        
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
 
 
 

    
<%@ include file="jsp/footer.jsp"%>