<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>
<%@ include file="jsp/header.jsp"%>

<%

String name = request.getParameter("name");
String email = request.getParameter("email");
String number = request.getParameter("number");
String msg = request.getParameter("msg");


Integer user_id = (Integer)session.getAttribute("user_id");

Connection conn = null;
Statement stmt = null;

try {
  Class.forName("com.mysql.jdbc.Driver");
     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts","root","");

    
    stmt = conn.createStatement();

    
    String sql = "INSERT INTO message(user_id,name, email, number, message) VALUES ('" + user_id + "','" + name + "', '" + email + "', '" + number + "', '" + msg + "')";

   
    stmt.executeUpdate(sql);

    
    stmt.close();
    conn.close();

    
    response.sendRedirect("contact.jsp");

} catch (SQLException se) {
   
    se.printStackTrace();
} catch (Exception e) {
   
    e.printStackTrace();
} finally {
   
    try {
        if (stmt != null) stmt.close();
    } catch (SQLException se2) {
    } 
    try {
        if (conn != null) conn.close();
    } catch (SQLException se) {
        se.printStackTrace();
    }
}
%>


<section class="contact">

   <h1 class="title_contact">get in touch</h1>

   <form action="" method="POST" class="contact-form">
      <input type="text" name="name" class="box_contact" required placeholder="Name">
      <input type="email" name="email" class="box_contact" required placeholder="Email">
      <input type="tel" name="number" min="0" class="box_contact" required placeholder="Phone">
      <textarea name="msg" class="box_contact" required placeholder="TELL US..." cols="30" rows="10"></textarea>
      <input type="submit" value="send message" class="btn_contact" name="send">
   </form>

</section>





<%@ include file="jsp/footer.jsp"%>
