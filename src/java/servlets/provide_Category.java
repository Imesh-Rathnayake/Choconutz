
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


public class provide_Category extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet provide_Category</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet provide_Category at " + request.getContextPath() + "</h1>");
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
       
       
       
       Connection con;
       
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           con=DriverManager.getConnection(url,dname,dpass);
           PreparedStatement pst=con.prepareStatement(query);
           java.sql.ResultSet result=pst.executeQuery();
           
           while(result.next())
           {
              int count=0;
              
             
              request.setAttribute("selectID"+count,result.getInt("id"));
              request.setAttribute("selectVAL"+count,result.getString("name"));
              
              count++;
           }
           
           
       
       }
       catch(ClassNotFoundException | SQLException e)
       {
           out.println(e.getMessage());
       }
       
       request.setAttribute("selectID1","Sample1");
       response.sendRedirect("index.jsp");
       
        
       // processRequest(request, response);
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
