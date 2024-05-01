
package admin_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;


public class Add_Products extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Add_Products</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Add_Products at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out =response.getWriter();
       
       String url="jdbc:mysql://localhost:3306/choconuts";
       String dname="root";
       String dpass="";
       String query="SELECT id,name FROM Categories";
       
       Connection con,con2;
       
       int count = 0;
       
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection(url,dname,dpass);
           PreparedStatement pst=con.prepareStatement(query);
           java.sql.ResultSet result=pst.executeQuery();
           
           
           //create attributes for categories
           
           count=0;
           
           while(result.next())
           {
               
              String id="selectID"+count;
              String value="selectVAL"+count;
             
              request.setAttribute(id,result.getInt("id"));
              request.setAttribute(value,result.getString("name"));
              
              count++;
           }
           
           con.close();
       
       }
       catch(ClassNotFoundException | SQLException e)
       {
           out.println(e.getMessage());
          
       }
       
       
       
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
      out.write("        <style>\n");
      
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
      
      out.write("    .transparent {\n");
      out.write("      background: rgba(255, 255, 255, 0.5);\n");
      out.write("    }\n");
      
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
      out.write("            .navbar-nav .nav-item.active #prd {\n");
      out.write("                height: 60px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .card {\n");
      out.write("                width: auto;\n");
      out.write("                height: auto;\n");
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
      
      
      out.write("   <script>\n");
      out.write("      \n");
      out.write("      function clicked()\n");
      out.write("      {\n");
      out.write("          \n");
      out.write("          \n");
      out.write("          var form = document.getElementById('products');\n");
      out.write("          var confirmation = window.confirm(\"Do you want to update product?\");\n");
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
      out.write("\n");
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
      out.write("        <input type=\"button\" value=\"Web\" class=\"nvbtn\">\n");
      out.write("      </li>\n");
      out.write("    </ul>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("<br><br><center><h4>ADD - PRODUCTS</h4></center>");
      out.write("    \n");
      out.write(" <br> \n");
      out.write("    <form  action=\"updateCard\" method=\"POST\" enctype=\"multipart/form-data\" id=\"products\">\n");
      out.write("      <center>\n");
      
      out.write("        <table class='table table-bordered  card shadow' style='width:750px;'>\n");
      out.write("          <tr>\n");
      out.write("            <th >Select Category :</th>\n");
      out.write("            <td><select id=\"crdNo\" name=\"category_ID\" class='transparent'>\n");
      
      
              // category selection with (concat) attributes
              
              for(int i=0;i<count;i++)
              {
                  
                  String concatVAL="selectVAL"+i;
                  String concatID="selectID"+i;
                  
                  String value= (String)request.getAttribute(concatVAL);
                  int id = (int) request.getAttribute(concatID);
                    
              
                    out.write("<option value="+id+">"+value+"</option>");
                
               }

              
      
      out.write("              </select></td>\n");
      out.write("          </tr>\n");
      out.write("\n");
      out.write("<tr>");
      out.write("<th>Set Product ID : </th>");
      out.write("<td><input class='transparent' type='text' name='id'></td>");
      out.write("</tr>\n");
      out.write("          <tr>\n");
      out.write("            <th>Set Product Name :</th>\n");
      out.write("            <td><input type=\"text\" name=\"name\" class='transparent' ></td>\n");
      out.write("          </tr>\n");
      out.write("\n");
      out.write("          <tr>\n");
      out.write("            <th>Set Price :</th>\n");
      out.write("            <td><input type=\"text\" name=\"price\" class='transparent'  ></td>\n");
      out.write("          </tr>\n");
      out.write("\n");
      out.write("          <tr>\n");
      out.write("            <th>Set Discription:</th>\n");
      out.write("            <td><textarea  name=\"discription\" rows=\"4\" cols=\"50\" class='transparent'\n");
      out.write("                ></textarea></td>\n");
      out.write("          </tr>\n");
      out.write("\n");
      out.write("          <tr>\n");
      out.write("            <th>Select Product Image:</th>\n");
      out.write("            <td><input type=\"file\" name=\"file1\" class='transparent'></td>\n");
      out.write("          </tr>\n");
      
      out.write("          <tr>\n");
      out.write("              <th>Is active?</th>\n");
      out.write("              <td><input class='transparent' type=\"checkbox\" name=\"active\" value=\"TRUE\" />   <small>Active Product</small></td>\n");
      out.write("          </tr>\n");
      
      out.write("\n");
      out.write("          <tr>\n");
      out.write("\n");
      out.write("            <td colspan=\"2\">\n");
      out.write("            <button type=\"reset\" class=\"btn btn-warning\">Clear</button>\n");
      out.write("            <button class=\"btn btn-success\" onclick=\"clicked()\" >Update</button>   </td>\n");
      out.write("          </tr>\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("      </center>\n");
      out.write("    </form>\n");
      out.write("\n");
      out.write("  </div>\n");
      
      out.write("<br><br><center><h4>PRODUCTS - ADDED</h4></center><br>");
      
      // adding now availble products
      
      
      String query1="SELECT id,name,price,image_url FROM Products";
      
      try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con2=DriverManager.getConnection(url,dname,dpass);
           PreparedStatement pst2=con2.prepareStatement(query1);
           java.sql.ResultSet result2=pst2.executeQuery();
           
           
         out.write("            <div class=\"container\">\n");  
           
           while(result2.next())
           {
               
                out.write("\n");
                out.write("\n");
                out.write("                <div class=\"card shadow\">\n");
                out.write("                    <img src='images/cardImage/"+result2.getString("image_url")+"' width=\"250\" height=\"200\" alt=\"1f95ba10-b00a-4521-9d13-bcac4b669518\"/>\n");
                out.write("                    <span style=\"position: absolute; top: 10px; left: 10px; background-color:red; padding: 5px; color:whitesmoke; \"><b>RS "+result2.getInt("price")+"/=</b></span>\n");
                out.write("                    <br>\n");
                out.write("                    <center>\n");
                out.write("                        \n");
                out.write("                        <h5>"+result2.getString("name")+"</h5>\n");
                out.write("                        \n");
                out.write("                    </center>\n");
                out.write("                </div>\n");
                out.write("\n");
                
              
           }
           
           
           
           con2.close();
       
       }
       catch(ClassNotFoundException | SQLException e)
       {
           out.println(e.getMessage());
          
       }
      
      
      
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("  <script src=\"js/jquery-3.4.1.min.js\"></script>\n");
      out.write("\n");
      out.write("  \n");
      out.write("  \n");
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
    }// </editor-fold>

}
