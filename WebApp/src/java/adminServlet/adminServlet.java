/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adminServlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author asus
 */
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024, // 1MB
    maxFileSize = 1024 * 1024 * 5,    // 5MB
    maxRequestSize = 1024 * 1024 * 10 // 10MB
)
public class adminServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminServlet at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
//        response.setContentType("text/html;charset=UTF-8");
//        PrintWriter out = response.getWriter();

        // Get form data
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        String details = request.getParameter("details");

        
        String ImgUrl = "";
//        String operation = request.getParameter("operation");
        
        RequestDispatcher dispatcher;
//      try {
//        Part profilePic = request.getPart("image");
//        if (profilePic != null && profilePic.getSize() > 0) {
//        String fileName = profilePic.getSubmittedFileName();
//        String savePath = "C:/Users/asus/Desktop/AdminPanal/web/uploaded_img/" + fileName;
//        
//        
//        profilePic.write(savePath);
//        ImgUrl = savePath; // Update image URL
//    }
//     } catch (IOException | ServletException e) {
//              request.setAttribute("message", e.getMessage());
//                dispatcher = request.getRequestDispatcher("admin_products.jsp");
//               dispatcher.forward(request, response);// Handle the exception appropriately
//     }

      

        
       Part file = null;
      try {
        Part profilePic = request.getPart("image");
        if (profilePic != null && profilePic.getSize() > 0) {
        String fileName = profilePic.getSubmittedFileName();
        String savePath = "C:/Users/asus/Desktop/AdminPanal/web/uploaded_img/" + fileName;
            String uploadPath;
          try (FileOutputStream fos = new FileOutputStream(savePath);
                        InputStream is = profilePic.getInputStream()) {
                    byte[] data = new byte[is.available()];
                    is.read(data);
                    fos.write(data);
//                    out.println("Image successfully saved in folder location.");
                }
        ImgUrl = fileName; // Update image URL
    }
     } catch (IOException | ServletException e) {
              request.setAttribute("message", e.getMessage());
                dispatcher = request.getRequestDispatcher("admin_products.jsp");
               dispatcher.forward(request, response);// Handle the exception appropriately
     }
   
        // Validate and sanitize input
//        name = name.trim();
//        price = price.trim();
//        category = category.trim();
//        details = details.trim();

        // Database connection details
        String dbUrl = "jdbc:mysql://localhost:3306/shop_db";
        String dbUser = "root";
        String dbPassword = "";

        try {
            // Establish database connection
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);

            // Check if product name already exists
            PreparedStatement selectProducts = conn.prepareStatement("SELECT * FROM products WHERE name = ?");
            selectProducts.setString(1, name);
            if (selectProducts.executeQuery().next()) {
                 request.setAttribute("message", "Product name already exists!");
                 dispatcher = request.getRequestDispatcher("admin_products.jsp");
                 dispatcher.forward(request, response);
//                out.println("Product name already exists!");
            } else {
                // Insert new product
                PreparedStatement insertProducts = conn.prepareStatement(
                        "INSERT INTO products (name, category, details, price, image) VALUES (?, ?, ?, ?, ?)");
                insertProducts.setString(1, name);
                insertProducts.setString(2, category);
                insertProducts.setString(3, details);
                insertProducts.setString(4, price);
                insertProducts.setString(5, ImgUrl); // Assuming image extension is .jpg
                insertProducts.executeUpdate();

                // Upload image (you can implement this logic)
                // ...
                 request.setAttribute("message", "New product added");
                dispatcher = request.getRequestDispatcher("admin_products.jsp");
               dispatcher.forward(request, response);
//                out.println("New product added!");
            }

            
        } catch (SQLException e) {
            request.setAttribute("message", e.getMessage());
                dispatcher = request.getRequestDispatcher("admin_products.jsp");
               dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(adminServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
