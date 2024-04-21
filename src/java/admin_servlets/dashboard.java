
package admin_servlets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinodrahal
 */
public class dashboard extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet dashboard</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet dashboard at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        Connection con;
        
        PrintWriter out=response.getWriter();
        
        String url="jdbc:mysql://localhost:3306/choconuts";
        String dname="root";
        String dpass="";
        
        String[] querys;
        String[] attributeNames;
        int[] nw;
        
        querys= new String[]{"SELECT SUM(total_price) FROM Orders WHERE order_status='Processing';",
                             "SELECT SUM(total_price) FROM Orders WHERE order_status='Completed';",
                             "SELECT COUNT(id) FROM Orders WHERE order_status='Placed';",
                             "SELECT COUNT(id) FROM Products;",
                             "SELECT COUNT(id) FROM Customers;",
                             "SELECT COUNT(id) FROM Customers;"};
        
        
        attributeNames=new String[]{"TotalPendings","CompletedOrders","PlacedOrders","ProductsAdded","TotalUsers","TotalAdmins"};
        
        
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url,dname,dpass);
            
            List<PreparedStatement> psts= new ArrayList<>();

            // add prepared statements
            
            for(String query:querys)
            {
                psts.add(con.prepareStatement(query));
            }
            
            int count=0;
            
            
            // execute prepared statements using loop
            
            for(PreparedStatement pst:psts)
            {
              
                ResultSet result=pst.executeQuery();
                
                
                // save data to attributes
                 
                if(result.next())
                {
                
                    //out.println(result.getInt(1));
                    
                    request.setAttribute(attributeNames[count], result.getInt(1));
                    
            
                }
                
                count++;
                
                
            }
            
            // check attributes
            
//            out.println(request.getAttribute(attributeNames[0]));
//            out.println(request.getAttribute(attributeNames[1]));
//            out.println(request.getAttribute(attributeNames[2]));
//            out.println(request.getAttribute(attributeNames[3]));
//            out.println(request.getAttribute(attributeNames[4]));
//            out.println(request.getAttribute(attributeNames[5]));

            con.close();
                    
        }
        catch(ClassNotFoundException | SQLException e)
        {
            out.println(e.getMessage());
        }
        
        
        
        // add Dashboard's UI
        
        
        out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <title>Untitled Document</title>\n");
      out.write("        <!-- Bootstrap -->\n");
      out.write("        <link href=\"css/bootstrap-4.4.1.css\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"admin1.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("\n");
      out.write("            .align-begin {\n");
      out.write("                text-align:left;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .colour-blue{\n");
      out.write("                color:blue;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .colour-red{\n");
      out.write("                color: red;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .align-end {\n");
      out.write("                text-align:right;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .navbar-nav .nav-item.active #dashboard {\n");
      out.write("                height: 60px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .card {\n");
      out.write("                width: 350px;\n");
      out.write("                height: 200px;\n");
      out.write("                background: rgba(255, 255, 255, 0.5);\n");
      out.write("                border-radius: 10px;\n");
      out.write("\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                padding: 10px;\n");
      out.write("                flex-wrap: wrap;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .shadow {\n");
      out.write("                box-shadow: inset 0 -3em 3em rgba(0,0,0,0.1),\n");
      out.write("                    0 0  0 2px rgb(190, 190, 190),\n");
      out.write("                    0.3em 0.3em 1em rgba(0,0,0,0.3);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .container {\n");
      out.write("                display: flex;\n");
      out.write("                flex-wrap: wrap;\n");
      out.write("                justify-content:center;\n");
      out.write("                gap: 30px;/* Distribute items evenly along the row */\n");
      out.write("            }\n");
      out.write("            .nvbtn {\n");
      out.write("                color: #4B3C3C;\n");
      out.write("                background-image: -webkit-linear-gradient(270deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);\n");
      out.write("                background-image: -moz-linear-gradient(270deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);\n");
      out.write("                background-image: -o-linear-gradient(270deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);\n");
      out.write("                background-image: linear-gradient(180deg,rgba(198,248,248,1.00) 0%,rgba(141,152,224,1.00) 100%);\n");
      out.write("                border-style: none;\n");
      out.write("                margin-left: 7px;\n");
      out.write("                margin-right: 7px;\n");
      out.write("                width: 100px;\n");
      out.write("                height: 40px;\n");
      out.write("                margin-top: 25px;\n");
      out.write("                border-top-right-radius: 15px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("\n");
      out.write("            function clicked()\n");
      out.write("            {\n");
      out.write("\n");
      out.write("\n");
      out.write("                var form = document.getElementById('products');\n");
      out.write("                var confirmation = window.confirm(\"Do you want to update product?\");\n");
      out.write("\n");
      out.write("                if (confirmation)\n");
      out.write("                {\n");
      out.write("                    form.submit();\n");
      out.write("                } else\n");
      out.write("                {\n");
      out.write("                    event.preventDefault();\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body style=\"background-color:#e1f1fd\">\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light\" style=\"background-color: transparent !important;\">\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent3\"\n");
      out.write("                        aria-controls=\"navbarSupportedContent3\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse justify-content-center align-items-center\" id=\"navbarSupportedContent3\">\n");
      out.write("                    <ul class=\"navbar-nav\">\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <form action=\"Manage_Orders\">\n");
      out.write("                                <input type=\"submit\" value=\"Orders\" id=\"hm\" class=\"nvbtn\" />\n");
      out.write("                            </form>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <input type=\"button\" value=\"Products\" id=\"prd\" class=\"nvbtn\" onclick=\"window.location.href = 'index.jsp'\">\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <form action=\"feedback\">\n");
      out.write("                                <input type=\"submit\" value=\"Feedbacks\" id=\"feed\" class=\"nvbtn\" />\n");
      out.write("                            </form>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <input type=\"button\" value=\"Other\"  class=\"nvbtn\">\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <input type=\"button\" value=\"Dashboard\" id=\"dashboard\" class=\"nvbtn\">\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </nav><br><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container\">\n");
      out.write("\n");
      out.write("<!--                total pendings-->\n");
      out.write("\n");
      out.write("                <div class=\"card shadow\">\n");
      out.write("                    <br>\n");
      out.write("                    <center>\n");
      out.write("                        \n");
      out.write("                        <h4 style='margin-top:15px;'>$"+request.getAttribute(attributeNames[0])+"/-</h4>\n");
      out.write("                        \n");
      out.write("                        <span style=\"margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;\" class=\"alert alert-info\">Total Pendings</span>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" value=\"See Orders\" style=\"margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;\" class=\"btn btn-outline-info\" />\n");
      out.write("                        \n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("<!--                completed orders-->\n");
      out.write("                \n");
      out.write("                <div class=\"card shadow\">\n");
      out.write("                    <br>\n");
      out.write("                    <center>\n");
      out.write("                        \n");
      out.write("                        <h4 style=\"margin-top:15px;\">$"+request.getAttribute(attributeNames[1])+"/-</h4>\n");
      out.write("                        \n");
      out.write("                        <span style=\"margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;\" class=\"alert alert-info\">Completed Orders</span>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" value=\"See Orders\" style=\"margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;\" class=\"btn btn-outline-info\" />\n");
      out.write("                        \n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("<!--                placed orders-->\n");
      out.write("                \n");
      out.write("                <div class=\"card shadow\">\n");
      out.write("                    <br>\n");
      out.write("                    <center>\n");
      out.write("                        \n");
      out.write("                        <h4 style=\"margin-top:15px;\">"+request.getAttribute(attributeNames[2])+"</h4>\n");
      out.write("                        \n");
      out.write("                        <span style=\"margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;\" class=\"alert alert-info\">Orders Placed</span>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" value=\"See Orders\" style=\"margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;\" class=\"btn btn-outline-info\" />\n");
      out.write("                        \n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("<!--                products added-->\n");
      out.write("\n");
      out.write("                <div class=\"card shadow\">\n");
      out.write("                    <br>\n");
      out.write("                    <center>\n");
      out.write("                        \n");
      out.write("                        <h4 style=\"margin-top:15px;\">"+request.getAttribute(attributeNames[3])+"</h4>\n");
      out.write("                        \n");
      out.write("                        <span style=\"margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;\" class=\"alert alert-info\">Products Added</span>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" value=\"See Products\" style=\"margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;\" class=\"btn btn-outline-info\" />\n");
      out.write("                        \n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("<!--                total users-->\n");
      out.write("                \n");
      out.write("                <div class=\"card shadow\">\n");
      out.write("                    <br>\n");
      out.write("                    <center>\n");
      out.write("                        \n");
      out.write("                        <h4 style=\"margin-top:15px;\">"+request.getAttribute(attributeNames[4])+"</h4>\n");
      out.write("                        \n");
      out.write("                        <span style=\"margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;\" class=\"alert alert-info\">Total Users</span>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" value=\"See Accounts\" style=\"margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;\" class=\"btn btn-outline-info\" />\n");
      out.write("                        \n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("<!--                total admins-->\n");
      out.write("                \n");
      out.write("                <div class=\"card shadow\">\n");
      out.write("                    <br>\n");
      out.write("                    <center>\n");
      out.write("                        \n");
      out.write("                        <h4 style=\"margin-top:15px;\">"+request.getAttribute(attributeNames[5])+"</h4>\n");
      out.write("                        \n");
      out.write("                        <span style=\"margin-bottom:15px; margin-top:15px;   display: inline-block;  padding: 10px; width: 320px;\" class=\"alert alert-info\">Total Admins</span>\n");
      out.write("                        <br>\n");
      out.write("                        <input type=\"submit\" value=\"See Accounts\" style=\"margin-bottom:20px; display: inline-block; padding: 10px; width: 320px;\" class='btn btn-outline-info' />\n");
      out.write("                        \n");
      out.write("                    </center>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"js/jquery-3.4.1.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"js/popper.min.js\"></script>\n");
      out.write("        <script src=\"js/bootstrap-4.4.1.js\"></script>\n");
      out.write("    </body>\n");
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
