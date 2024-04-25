/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostomerServlet;

import customerController.customerController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
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
        processRequest(request, response);

        HttpSession session = request.getSession();
        String username = request.getParameter("uname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String OldPwd = request.getParameter("oldPwd");
        String NewPwd = request.getParameter("newPwd");
        String ImgUrl = "";
        String operation = request.getParameter("operation");
        int userId = 1;
        RequestDispatcher dispatcher;
        Part profilePic = request.getPart("profilePic");
         if (profilePic != null && profilePic.getSize() > 0) {
            String fileName = profilePic.getSubmittedFileName();
            String savePath = "UserProfilePic/" + fileName;
            profilePic.write(savePath);
            ImgUrl = savePath; // Update image URL
        }
         
        switch (operation) {
        case "update password":
            customerController c2 = new customerController();
           String status1 = c2.customerPasswordUptade(userId, OldPwd, NewPwd);
           request.setAttribute("message", status1);
           dispatcher = request.getRequestDispatcher("profile.jsp");
           dispatcher.forward(request, response);
        ;
        break;
         case "update details":
         customerController c1 = new customerController();
         String status2 = c1.customerUptade(userId, username, email, phoneNumber, OldPwd, NewPwd, ImgUrl);
         request.setAttribute("message", status2);
         dispatcher = request.getRequestDispatcher("profile.jsp");
         dispatcher.forward(request, response);
        break;
        default:
        System.out.println("You are not eligible to do anything.");
        break;
       }
         
         
         customerController c1 = new customerController();
         String status = c1.customerUptade(userId, username, email, phoneNumber, OldPwd, NewPwd, ImgUrl);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
