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


/**
 *
 * @author vinodrahal
 */
public class Complete_Order extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Complete_Order</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Complete_Order at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        java.sql.Connection con;
        
        //declare variables
        
        String url="jdbc:mysql://localhost:3306/choconuts";
        String dname="root";
        String dpass="";
        String query="UPDATE Orders SET order_status='Completed' WHERE id=?";
        int id=Integer.parseInt(request.getParameter("order_id"));
        
        
        
        try
        {
            //create connection & execute query
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,dname,dpass);
            PreparedStatement pst=con.prepareStatement(query);
            
            
            pst.setInt(1, id);
            
            pst.execute();
            
            String redirectURL = request.getContextPath() + "/Manage_Orders";
            response.sendRedirect(redirectURL);
            con.close();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
