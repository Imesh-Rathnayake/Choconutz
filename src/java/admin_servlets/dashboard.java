
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

            
            
            for(String query:querys)
            {
                psts.add(con.prepareStatement(query));
            }
            
            int count=0;
            for(PreparedStatement pst:psts)
            {
              
                ResultSet result=pst.executeQuery();
                
                
                
                if(result.next())
                {
                
                    //out.println(result.getInt(1));
                    
                    request.setAttribute(attributeNames[count], result.getInt(1));
                    
            
                }
                
                count++;
                
            }
            
            
            out.println(request.getAttribute(attributeNames[0]));
            out.println(request.getAttribute(attributeNames[1]));
            out.println(request.getAttribute(attributeNames[2]));
            out.println(request.getAttribute(attributeNames[3]));
            out.println(request.getAttribute(attributeNames[4]));
            out.println(request.getAttribute(attributeNames[5]));
            
            
            
            
            
            
            
            
            
            
            
            
                
        }
        catch(ClassNotFoundException | SQLException e)
        {
            out.println(e.getMessage());
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
