package Choconutz;

import java.sql.DriverManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class Signup extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Signup</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Signup at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        String un = request.getParameter("un");
        String em = request.getParameter("email");
        String pass = request.getParameter("pass");
        String con_pass = request.getParameter("con_pass");

        PrintWriter out = response.getWriter();

        if (pass.equals(con_pass)) {
            String url = "jdbc:mysql://localhost:3308/user";
            Connection con2;

            try {

                Class.forName("com.mysql.cj.jdbc.Driver");

                con2 = DriverManager.getConnection(url, "root", "");

                String query = "INSERT INTO members (id,name,email,password) VALUES (?,?,?,?)";

                PreparedStatement pst = con2.prepareStatement(query);

                pst.setInt(1, 3);
                pst.setString(2, un);
                pst.setString(3, em);
                pst.setString(4, pass);

                pst.execute();

                

                con2.close();

                // Close resources
            } catch (ClassNotFoundException | SQLException e) {
                out.println("Error: " + e.getMessage());
            }

            response.sendRedirect("signin.jsp");
        } else {
            
            response.setContentType("text/html;charset=UTF-8");
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet alert</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<script>");
            out.println("alert('password doesn\\'t match!');");
            out.println("window.location.href = 'signup.jsp';");
            out.println("</script>");
            out.println("</body>");
            out.println("</html>");
            
            

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
