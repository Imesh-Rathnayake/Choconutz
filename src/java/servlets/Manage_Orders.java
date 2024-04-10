package servlets;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinodrahal
 */
public class Manage_Orders extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Manage_Orders</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Manage_Orders at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Connection con;
        
        //Declare variables for connection
        
        String url="jdbc:mysql://localhost:3306/Donut";
        String dname="root";
        String dpass="";
        String query="SELECT Category, Quantity, Name, Address, Mobile, ID FROM MyOrders";
        
        PrintWriter out=response.getWriter();
        
        
        
        
        try
        {
            //create srevlet's body 
            
            out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("  <title>Untitled Document</title>\n");
      out.write("  <!-- Bootstrap -->\n");
      out.write("  <link href=\"css/bootstrap-4.4.1.css\" rel=\"stylesheet\">\n");
      out.write("  <link href=\"admin.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("  <style>\n");
      out.write("    td {\n");
      out.write("      border: 1px solid black;\n");
      out.write("      padding: 8px;\n");
      out.write("      text-align: right;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    th {\n");
      out.write("      border: 1px solid black;\n");
      out.write("      padding: 8px;\n");
      out.write("\n");
      out.write("\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .align-end {\n");
      out.write("      text-align: right;\n");
      out.write("    }\n");
      out.write("    .nav-item.active form #hm {\n");
      out.write("        \n");
      out.write("            height: 60px;\n");
      out.write("\n");
      out.write("}\n");
      out.write("  </style>\n");
      
      out.write("  <script>\n");
      out.write("      \n");
      out.write("      function clicked()\n");
      out.write("      {\n");
      out.write("          var form = document.getElementById('products');\n");
      out.write("          var confirmation = window.confirm(\"Do you need to complete this order?\");\n");
      out.write("          \n");
      out.write("          if(confirmation)\n");
      out.write("          {\n");
      out.write("              form.submit();\n");
      out.write("          }\n");
      out.write("          else\n");
      out.write("          {\n");
      out.write("              event.preventDefault();\n");
      out.write("          }\n");
      out.write("      }\n");
      out.write("      \n");
      out.write("      \n");
      out.write("  </script>\n");
      
      out.write("</head>\n");
      out.write("\n");
      out.write("<body style=\"background-color:#e1f1fd\">\n");
      out.write("  <br><br><br>\n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    <br><br><br>\n");
      out.write("\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light fixed-top\" style=\"background-color: transparent !important;\">\n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent3\"\n");
      out.write("    aria-controls=\"navbarSupportedContent3\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("  </button>\n");
      out.write("\n");
      out.write("  <div class=\"collapse navbar-collapse justify-content-center align-items-center\" id=\"navbarSupportedContent3\">\n");
      out.write("    <ul class=\"navbar-nav\">\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <form action=\"Manage_Orders\">\n");
      out.write("          <input type=\"submit\" value=\"Orders\" id=\"hm\" class=\"nvbtn\" />\n");
      out.write("        </form>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("          <input type=\"button\" value=\"Products\" id=\"prd\" class=\"nvbtn\" onclick=\"window.location.href='index.jsp'\">\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item active\">\n");
      
      out.write("        <form action=\"feedback\">\n");
      out.write("          <input type=\"submit\" value=\"Feedbacks\" id=\"feed\" class=\"nvbtn\" />\n");
      out.write("        </form>\n");
      
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <input type=\"button\" value=\"Other\" class=\"nvbtn\">\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <input type=\"button\" value=\"Web\" class=\"nvbtn\">\n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("\n");
      
      out.write("    \n");
      out.write("\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <!-- body code goes here -->\n");
            
      
            //create connection 
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,dname,dpass);
            PreparedStatement pst=con.prepareStatement(query);
            java.sql.ResultSet result=pst.executeQuery();
            
            
            //print table with values
            
            out.println("<table align=\"center\" border=\"1\">");
            out.println("<tr><th><center>Category</center></th><th><center>Quantity</center></th><th><center>Name</center></th><th><center>Address</center></th><th><center>Mobile</center></th><th>Action</th></tr>");
            
            while (result.next()) {
                
                out.println("<tr>");
                out.println("<td>" + result.getString("Category") + "</td>");
                out.println("<td>" + result.getString("Quantity") + "</td>");
                out.println("<td>" + result.getString("Name") + "</td>");
                out.println("<td>" + result.getString("Address") + "</td>");
                out.println("<td>" + result.getString("Mobile") + "</td>");
                out.println("<td><form method='Post' action='Complete_Order'><input type='hidden' name='record_id' value='" + result.getString("ID") + "'><input type='button' value='Complete' onclick=\"clicked()\" class=\"btn btn-danger\"></form></td>");
                out.println("</tr>");
            }

            out.println("</table>");
            
            
      
      //create srevlet's body
            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\n");
      out.write("  <script src=\"js/jquery-3.4.1.min.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- Include all compiled plugins (below), or include individual files as needed -->\n");
      out.write("  <script src=\"js/popper.min.js\"></script>\n");
      out.write("  <script src=\"js/bootstrap-4.4.1.js\"></script>\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
            
        con.close();  
        
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manage_Orders.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            
        }
        
         
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
