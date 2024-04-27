/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomerServlet;

import CustomerController.customerController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebServlet(name = "customerRegisterServlet", urlPatterns = {"/customerRegisterServlet"})
public class customerRegisterServlet extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet customerRegisterServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customerRegisterServlet at " + request.getContextPath() + "</h1>");
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
          String username = request.getParameter("uname");
          String email = request.getParameter("email");
          String phone = request.getParameter("phone");
          String password = request.getParameter("pwd");
          
          
          
          customerController c1 = new customerController();
          String massage = c1.customerRegister(username,email,phone,password);
          
          if(massage.equals("true")){
           request.setAttribute("message", "Register successfully");
             RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
             dispatcher.forward(request, response);


          }else if(massage.equals("false")); {
                
                request.setAttribute("message", "user already register");
                RequestDispatcher dispatcher=request.getRequestDispatcher("register.jsp");
                dispatcher.forward(request,response);
            }
          
          else {
                  request.setAttribute("message", message);
                  RequestDispatcher dispatcher=request.getRequestDispatcher("register.jsp");
                  dispatcher.forward(request, response);
                  }
          
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}