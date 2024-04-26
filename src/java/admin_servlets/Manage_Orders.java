package admin_servlets;


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
        
      PrintWriter out=response.getWriter();
      
      
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
      
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("  <style>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("    .align-begin {\n");
      out.write("      text-align:left;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .colour-blue{\n");
      out.write("        color:blue;\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .colour-red{\n");
      out.write("        color: red;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .align-end {\n");
      out.write("      text-align:right;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .navbar-nav .nav-item.active #hm {\n");
      out.write("    height: 60px;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .card {\n");
      out.write("     width: auto;\n");
      out.write("     height: auto;\n");
      out.write("     background: rgba(255, 255, 255, 0.5);\n");
      out.write("     border-radius: 10px;\n");
      out.write("     \n");
      out.write("     margin-bottom: 20px;\n");
      out.write("     padding: 10px;\n");
      out.write("     flex-wrap: wrap;\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .shadow {\n");
      out.write("     box-shadow: inset 0 -3em 3em rgba(0,0,0,0.1),\n");
      out.write("                 0 0  0 2px rgb(190, 190, 190),\n");
      out.write("                 0.3em 0.3em 1em rgba(0,0,0,0.3);\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    .container {\n");
      out.write("      display: flex;\n");
      out.write("      flex-wrap: wrap;\n");
      out.write("      justify-content:center;\n");
      out.write("      gap: 30px;\n");
      out.write("    }\n");
      out.write("    .nvbtn {\n");
      out.write("    color: #4B3C3C;\n");
      out.write("    background-image: -webkit-linear-gradient(270deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);\n");
      out.write("    background-image: -moz-linear-gradient(270deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);\n");
      out.write("    background-image: -o-linear-gradient(270deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);\n");
      out.write("    background-image: linear-gradient(180deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);\n");
      out.write("    border-style: none;\n");
      out.write("    margin-left: 7px;\n");
      out.write("    margin-right: 7px;\n");
      out.write("    width: 100px;\n");
      out.write("    height: 40px;\n");
      out.write("    margin-top: 25px;\n");
      out.write("    border-top-right-radius: 15px;\n");
      out.write("}\n");
      
      out.write("            .modal-dialog-top-right \n");
      out.write("            \n");
      out.write("            {\n");
      out.write("              position: fixed;\n");
      out.write("              top: 120px; \n");
      out.write("              right: 50px; \n");
      out.write("              margin: 0;\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            .account-position \n");
      out.write("            \n");
      out.write("            {\n");
      out.write("              position: fixed;\n");
      out.write("              top: 40px; \n");
      out.write("              right: 70px; \n");
      out.write("              margin: 0;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .add-transparent\n");
      out.write("            {\n");
      out.write("                background:rgba(255, 255, 255, 0.5);\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("    \n");
      out.write("  </style>\n");
      
      out.write("  <script>\n");
      out.write("      \n");
      out.write("      function clicked1()\n");
      out.write("      {\n");
      out.write("          var form = document.getElementById('delete_order');\n");
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
      
      out.write("      function clicked2()\n");
      out.write("      {\n");
      out.write("          var form = document.getElementById('Process_Order');\n");
      out.write("          var confirmation = window.confirm(\"Do you need to change this order?\");\n");
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
      out.write("  \n");
      out.write("<div class=\"container-fluid\">\n");
      out.write("    \n");
      out.write("\n");
      out.write("    <nav class=\"navbar navbar-expand-lg navbar-light \" style=\"background-color: transparent !important;\">\n");
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
      
      out.write("        <form action=\"Add_Products\">\n");
      out.write("          <input type=\"submit\" value=\"Products\" id=\"prd\" class=\"nvbtn\" />\n");
      out.write("        </form>\n");
      
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
      out.write("                            <form action=\"dashboard\" method=\"GET\">\n");
      out.write("                                <input type=\"submit\" value=\"Dashboard\" id=\"dashboard\" class=\"nvbtn\">\n");
      out.write("                            </form>\n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      
      out.write("                    <a href=\"#\" data-toggle=\"modal\" data-target=\"#exampleModal\" class=\"account-position \" >\n");
      out.write("                        <center>\n");
      out.write("                            <script src=\"https://cdn.lordicon.com/lordicon.js\"></script>\n");
      out.write("                            \n");
      out.write("                            <lord-icon\n");
      out.write("                                src=\"https://cdn.lordicon.com/hrjifpbq.json\"\n");
      out.write("                                \n");
      out.write("                                colors=\"primary:#66a1ee\"\n");
      out.write("                                style=\"width:50px;height:50px\">\n");
      out.write("                            </lord-icon>\n");
      out.write("                            \n");
      out.write("                        </center>\n");
      out.write("                    </a>\n");
      
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("<br><br>\n");
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
        
        
        
        Connection con;
        
        //Declare variables for connection
        
        String url="jdbc:mysql://localhost:3306/choconuts";
        String dname="root";
        String dpass="";
        String query="SELECT Order_items.id,Orders.id,Products.name,Order_items.quantity,Orders.total_price,Customers.username,Customers.shipping_address,Customers.email,Orders.payment_method,Orders.order_status,Orders.created_at FROM Order_items JOIN Orders ON Order_items.order_id=Orders.id JOIN Customers ON Orders.customer_id=Customers.id JOIN Products ON Order_items.product_id=Products.id";
        
        try
        {
            //create connection 
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,dname,dpass);
            PreparedStatement pst=con.prepareStatement(query);
            java.sql.ResultSet result=pst.executeQuery();
            
            
            //print table with values
           out.write("            <div class=\"container\">\n"); 
            
            while (result.next()) {
                
               
                
                
                out.write("\n");
                out.write("\n");
                out.write("                <div class=\"card shadow\">\n");
                out.write("                    <table style=\"width: 300px;\" border=\"0\" class=\"table table-bordered border-primary\">\n");
                out.write("\n");
                out.write("                        <tbody>\n");
                out.write("                            <tr>\n");
                out.write("                                <td class=\"align-begin\">Order ID</td>\n");
                out.write("                                <td class=\"align-begin colour-red\">"+result.getString("id")+"</td>\n");
                out.write("                            </tr>\n");
                out.write("                            <tr>\n");
                out.write("                                <td class=\"align-begin\">Customer Name</td>\n");
                out.write("                                <td class=\"align-begin colour-blue\">"+result.getString("username")+"</td>\n");
                out.write("                            </tr>\n");
                out.write("                            <tr>\n");
                out.write("                                <td class=\"align-begin\">Placed On</td>\n");
                out.write("                                <td class=\"align-begin colour-blue\">"+result.getString("created_at")+"</td>\n");
                out.write("                            </tr>\n");
                out.write("                            <tr>\n");
                out.write("                                <td class=\"align-begin\">Address</td>\n");
                out.write("                                <td class=\"align-begin colour-blue\">"+result.getString("shipping_address")+"</td>\n");
                out.write("                            </tr>\n");
                out.write("                            <tr>\n");
                out.write("                                <td class=\"align-begin\">Product</td>\n");
                out.write("                                <td class=\"align-begin colour-blue\">"+result.getString("name")+"</td>\n");
                out.write("                            </tr>\n");
                out.write("                            <tr>\n");
                out.write("                                <td class=\"align-begin\">Quantity</td>\n");
                out.write("                                <td class=\"align-begin colour-blue\">"+result.getInt("quantity")+"</td>\n");
                out.write("                            </tr>\n");
                out.write("                            <tr>\n");
                out.write("                                <td class=\"align-begin\">Price</td>\n");
                out.write("                                <td class=\"align-begin colour-blue\">$ "+result.getBigDecimal("total_price")+"</td>\n");
                out.write("                            </tr>\n");
                out.write("                            <tr>\n");
                out.write("                                <td class=\"align-begin\">Payment Type</td>\n");
                out.write("                                <td class=\"align-begin colour-blue\">"+result.getString("payment_method")+"</td>\n");
                out.write("                            </tr>\n");
                out.write("                            <tr>\n");
                out.write("                                <td class=\"align-begin\">Status</td>\n");
                out.write("                                <td class=\"align-begin colour-red\">"+result.getString("order_status")+"</td>\n");
                out.write("                            </tr>\n");
                out.write("\n");
                out.write("                            <tr>\n");
                out.write(" <td><form method='POST' id='Process_Order' action='Process_Order'><input type='hidden' name='order_id' value='" + result.getInt("Orders.id") + "'><input type='button' value='Processing' title='Process Order' onclick=\"clicked2()\" class=\"btn btn-outline-primary\"></form></td>\n");
                out.write("<td><form method='POST' id='delete_order' action='Complete_Order'><input type='hidden' name='order_id' value='" + result.getInt("Orders.id") + "'><input type='button' value='Completed' title='Complete Order' onclick=\"clicked1()\" class=\"btn btn btn-outline-warning\"></form></td>\n");
                out.write("                            </tr>\n");
                out.write("                        </tbody>\n");
                out.write("                    </table>\n");
                out.write("</div>\n");
                
                
                
                
            }

            out.write("                </div>\n");
            
            
      
            
            
      
      
            
      
            
        con.close();  
        
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manage_Orders.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
      //create srevlet's body
        
      out.write("\n");
      
      out.write("<!-- Modal -->\n");
      out.write("<div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("  <div class=\"modal-dialog modal-dialog-top-right add-transparent\" role=\"document\">\n");
      out.write("    <div class=\"modal-content add-transparent\">\n");
      out.write("      <div class=\"modal-header\">\n");
      out.write("          <h5 class=\"modal-title\" id=\"exampleModalLabel\"><center>Current Account</center></h5>\n");
      out.write("        <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("          <span aria-hidden=\"true\">&times;</span>\n");
      out.write("        </button>\n");
      out.write("      </div>\n");
      out.write("        \n");
      out.write("        <div class=\"alert alert-warning\" role=\"alert\">\n");
      out.write("            User Name : Vinod Rahal<br><br>\n");
      out.write("            Account Type : Admin\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("      \n");
      out.write("      <div class=\"modal-footer\">\n");
      out.write("        <button type=\"button\" class=\"btn btn-outline-dark\" data-dismiss=\"modal\">Close</button>\n");
      out.write("        <button type=\"button\" class=\"btn btn-outline-danger\">Log Out</button>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</div>\n");
      
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
