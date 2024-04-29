<%-- 
    Document   : admin_header
    Created on : Apr 28, 2024, 8:02:25 PM
    Author     : asus
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- Assuming you have the necessary JSP tags and imports set up --%>

<%-- PHP code block --%>


<%-- Header section --%>
<header class="header">
    <div class="flex">
        <a href="admin_page.jsp" class="logo">Admin<span>Panel</span> Choconuts</a>
        <nav class="navbar">
            <a href="admin_page.jsp">home</a>
            <a href="admin_products.jsp">products</a>
            <a href="admin_orders.jsp">orders</a>
            <a href="admin_users.jsp">users</a>
            <a href="admin_contacts.jsp">messages</a>
        </nav>
        <div class="icons">
            <div id="menu-btn" class="fas fa-bars"></div>
            <div id="user-btn" class="fas fa-user"></div>
        </div>
        <div class="profile">
            <%-- Fetch user profile data from the database --%>
            <%
                // Replace this with your actual database query to fetch user profile
                int adminId = (Integer)session.getAttribute("admin_id");
                try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts","root","");
           
            //get data from login table using query
            Statement stm =  con.createStatement();
            ResultSet rs = stm.executeQuery("select * from users where id='"+adminId+"'");
 
            if(rs.next()){
            
              String adminName = rs.getString("name"); // Example name
              String profileImage = rs.getString("image");
            %>
              
             <img src="uploaded_img/<%= profileImage %>" alt="Profile Image">
            <p><%= adminName %></p>
            <a href="admin_profile.jsp" class="btn">update profile</a>
            <a href="./logoutServlet" class="delete-btn">logout</a>
            <div class="flex-btn">
                <a href="login.jsp" class="option-btn">login</a>
                <a href="register.jsp" class="option-btn">register</a>
            </div>
               
           <%
            }
            else{
            %>
              <img src="" alt="Profile Image">
            <p>none</p>
            <a href="admin_profile.jsp" class="btn">update profile</a>
            <a href="./logoutServlet" class="delete-btn">logout</a>
            <div class="flex-btn">
                <a href="login.jsp" class="option-btn">login</a>
                <a href="register.jsp" class="option-btn">register</a>
            </div>
            <%
            }
         
      
      }
      catch(Exception e){
               
                   e.getMessage();
      }
               
            %>
           
        </div>
    </div>
</header>

