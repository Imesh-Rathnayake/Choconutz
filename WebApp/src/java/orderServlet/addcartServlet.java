/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orderServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class addcartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addcartServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addcartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

         response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
//        
//        // Retrieve form parameters
  
        
//         out.println(quantity);

  try{
        int userId =Integer.parseInt( request.getParameter("user_id"));
        int productId = Integer.parseInt(request.getParameter("pId"));
        String name = request.getParameter("name");
        String image = request.getParameter("image");
         String category = request.getParameter("cate");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
           System.out.println(request.getParameter("quantity"));
           System.out.println(request.getParameter("pId"));
           System.out.println(request.getParameter("user_id"));
      
       
        String url = "jdbc:mysql://localhost:3306/choconuts";
        String username = "root";
        String password = "";
        
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Establish the database connection
            Connection conn = DriverManager.getConnection(url, username, password);
            
            // SQL query to insert data into the cart table
            String sql = "INSERT INTO cart(user_id, pid,name,price,quantity,image) VALUES (?, ?, ?,?,?,?)";
            
            // Create a PreparedStatement object to execute the SQL query
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setInt(2, productId);
            pstmt.setString(3, name);
            pstmt.setInt(4, price);
            pstmt.setInt(5, quantity);
            pstmt.setString(6, image);
            
            // Execute the query
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                
               
              
               request.setAttribute("message","Item added to cart successfully!");
//               response.sendRedirect("category.jsp?category="+category+"");
                RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp?category="+category+"");
                dispatcher.forward(request, response);
                
            } else {
              
                 request.setAttribute("message","Failed to add item to cart!");
                 
//                 response.sendRedirect("category.jsp?category="+category+"");
                 RequestDispatcher dispatcher = request.getRequestDispatcher("category.jsp?category="+category+"");
                dispatcher.forward(request, response);
            }
            
            // Close the PreparedStatement and Connection objects
            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException ex) {
//            out.println("<h2>Error: " + ex.getMessage() + "</h2>");
        } finally {
//            out.close();
        }
  
  }
  
  catch(Exception e){
                
                 System.out.println(e.getMessage());
             }
        
         


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
