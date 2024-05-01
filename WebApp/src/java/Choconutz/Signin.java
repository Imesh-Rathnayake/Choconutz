package Choconutz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Signin extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Signin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Signin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String un = request.getParameter("un");
        String pass = request.getParameter("pass");

        PrintWriter out = response.getWriter();

       

        String url = "jdbc:mysql://localhost:3308/user";
        Connection con1;
        
         //Use a parameterized query
        String query = "SELECT * FROM members WHERE name =? AND password =?";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection(url, "root", "");
            PreparedStatement pst=con1.prepareStatement(query);
            
            
            pst.setString(1, un);
            pst.setString(2, pass);
            
            
            
            ResultSet result=pst.executeQuery();
            
            if(result.next())
            {
                out.println(result.getString("name"));
                out.println(result.getString("password"));
            }
            else
            {
                response.sendRedirect("login-error.jsp");
            }
            
            
            con1.close();
            

           
            

        } catch (ClassNotFoundException | SQLException e) {
                out.println("Error: " + e.getMessage());
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
    }// </editor-fold>

}
