/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
import java.time.LocalDate;

/**
 *
 * @author vinodrahal
 */
public class feedback extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet feedback</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet feedback at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
      PrintWriter out=response.getWriter();
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      //out.write("  <link href=\"admin.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      
      out.write("    td {\n");
      //out.write("      border: 1px solid black;\n");
      out.write("      padding: 8px;\n");
      out.write("      text-align: right;\n");
      out.write("\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    th {\n");
      //out.write("      border: 1px solid black;\n");
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
      out.write("            .navbar-nav .nav-item.active #feed {\n");
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
      out.write("  \n");
      out.write("  \n");
      
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
      out.write("\n");
      out.write("    <div class=\"container\">\n");
      out.write("        \n");
      out.write("       <form action=\"feedback\" method=\"GET\">\n");
      out.write("        \n");
      out.write("           <label><b>Select Date :</b></label><input type=\"date\" class='transparent' name=\"date\" value=\"\" />\n");
      out.write("           <input type=\"submit\" class=\"btn btn-info\" value=\"Search\" />\n");
      out.write("    </form> \n");
      out.write("        \n");
      
      
      
      
        Connection con;
        
        //Declare variables for connection
        
        String url="jdbc:mysql://localhost:3306/Donut";
        String dname="root";
        String dpass="";
        String query="SELECT Email,Feedback FROM Feedbacks";
        String query2="SELECT Email,Feedback FROM Feedbacks WHERE Date=?";
        
//        String query="SELECT Email,Feedback FROM Feedbacks";
        
        try
        {
            String date=request.getParameter("date");
      
             if(date.equals(""))
              {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection(url,dname,dpass);
                PreparedStatement pst=con.prepareStatement(query);
                java.sql.ResultSet result=pst.executeQuery();
                out.println("<br><h6>All feedbacks</h6>");
                
                
                out.println("<table align=\"center\" class='table table-bordered  card shadow'>");
                out.println("<tr><th><center>Email</center></th><th><center>Feedback</center></th><th><center>Action</center></th></tr>");
            
            while (result.next()) 
            {
                
                out.println("<tr>");
                out.println("<td>" + result.getString("Email") + "</td>");
                out.println("<td>" + result.getString("Feedback") + "</td>");
                
                out.println("<td><form method='GET' action='sendMail'><input type='hidden' name='Email' value='" + result.getString("Email") + "'>Subject: <input type='text' name='subject' class='transparent'><br><br>Body :<textarea class='transparent' name='body' rows='3' cols='20'></textarea><br><input type='submit' value='Reply'  class=\"btn btn-primary\"></form></td>");
                out.println("</tr>");
            }

            out.println("</table>");
              }
             else
              {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con=DriverManager.getConnection(url,dname,dpass);
                PreparedStatement pst=con.prepareStatement(query2);
                pst.setString(1,date);
                java.sql.ResultSet result=pst.executeQuery();
                out.println("<br><h6>Selected date : "+date+"</h6>");
                
                out.println("<table class='table table-bordered  card shadow' align=\"center\">");
                out.println("<tr><th><center>Email</center></th><th><center>Feedback</center></th><th><center>Action</center></th></tr>");
            
                 while (result.next()) 
                 {
                
                    out.println("<tr>");
                    out.println("<td>" + result.getString("Email") + "</td>");
                    out.println("<td>" + result.getString("Feedback") + "</td>");

                    out.println("<td><form method='GET' action='sendMail'><input type='hidden' name='Email' value='" + result.getString("Email") + "'>Subject: <input type='text' name='subject' class='transparent'><br><br>Body :<textarea class='transparent' name='body' rows='3' cols='20'></textarea><br><input type='submit' value='Reply'  class=\"btn btn-primary\"></form></td>");
                    out.println("</tr>");
                 }

                out.println("</table>");
              }
            
            con.close();
            
            
            
            
            
            
            
            
        
        }
        catch(ClassNotFoundException | SQLException e)
        {
        
        }
      
      out.write("    </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    \n");
      out.write("\n");
      out.write("  </div>\n");
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
        
        
        
//        LocalDate currentDate=LocalDate.now();
//        
//        String date=request.getParameter("date");
//        
//        PrintWriter out= response.getWriter();
//        
//        out.println("Today is : "+date);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
