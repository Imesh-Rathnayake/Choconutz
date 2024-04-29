/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostomerServlet;

import customerController.customerController;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
@WebServlet(name = "customerUptadeServlet", urlPatterns = {"/customerUptadeServlet"})
public class customerUptadeServlet extends HttpServlet {

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
            out.println("<title>Servlet customerUptadeServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customerUptadeServlet at " + request.getContextPath() + "</h1>");
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

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

//        HttpSession session = request.getSession();
        int userId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("pnumber");
        String OldPwd = request.getParameter("old_pass");
        String NewPwd = request.getParameter("new_pass");
        String ImgUrl = "";
        String operation = request.getParameter("update");
       
        RequestDispatcher dispatcher;
        
//       Part file = null;
      try {
        Part profilePic = request.getPart("image");
        if (profilePic != null && profilePic.getSize() > 0) {
        String fileName = profilePic.getSubmittedFileName();
        String savePath = "C:/Users/asus/Desktop/WebApp/web/uploaded_img/" + fileName;
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
                dispatcher = request.getRequestDispatcher("user_profile.jsp");
               dispatcher.forward(request, response);// Handle the exception appropriately
     }
         
        switch (operation) {
        case "UpdatePassword":
            customerController c2 = new customerController();
           String status1 = c2.customerPasswordUptade(userId, OldPwd, NewPwd);
           request.setAttribute("message", status1);
           dispatcher = request.getRequestDispatcher("user_profile.jsp");
           dispatcher.forward(request, response);
        break;
        
         case "UpdateDetails":
         customerController c1 = new customerController();
         String status2 = c1.customerUpdate(userId, username, email, phoneNumber, ImgUrl);
         request.setAttribute("message", status2);
         dispatcher = request.getRequestDispatcher("user_profile.jsp");
         dispatcher.forward(request, response);
        break;
        
         case "Admin_UpdatePassword":
         customerController c3 = new customerController();
         String status3 = c3.customerPasswordUptade(userId, OldPwd, NewPwd);
         request.setAttribute("message", status3);
         dispatcher = request.getRequestDispatcher("admin_profile.jsp");
         dispatcher.forward(request, response);
        break;
        
         case "Admin_UpdateDetails":
         customerController c4 = new customerController();
         String status4 = c4.customerUpdate(userId, username, email, phoneNumber, ImgUrl);
         request.setAttribute("message", status4);
         dispatcher = request.getRequestDispatcher("admin_profile.jsp");
         dispatcher.forward(request, response);
        break;
        default:
        System.out.println("You are not eligible to do anything.");
        break;
       }
         
         
//         customerController c1 = new customerController();
//         String status = c1.customerUptade(userId, username, email, phoneNumber, OldPwd, NewPwd, ImgUrl);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
