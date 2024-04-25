/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CostomerServlet;

import customerController.customerController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
@WebServlet(name = "customerLoginServlet", urlPatterns = {"/customerLoginServlet"})
public class customerLoginServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet customerLoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet customerLoginServlet at " + request.getContextPath() + "</h1>");
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
          String password = request.getParameter("pwd");
          HttpSession session = request.getSession();
          
       
           try{
              
               Class.forName("com.mysql.jdbc.Driver");
               Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts","root","");
           
                //get data from login table using query
               Statement stm =  con.createStatement();
               String  query = "select * from customers where username='"+username+"' AND password='"+password+"'";
               ResultSet rs = stm.executeQuery(query);
               
               if(rs.next()){
                   String userType=rs.getString("user_type");
                   int userId = rs.getInt("id");
                   
                   if(userType.equals("admin"))
                   {
                       session.setAttribute("admin_id",userId);
                       response.sendRedirect("Manage_Orders");
                       
                   }
                   else if(userType.equals("user"))
                   {
                       session.setAttribute("user_id", userId);
//                       response.sendRedirect("main.jsp");
                         response.sendRedirect("main2.jsp");
//                       response.sendRedirect("profile.jsp");
                   }
                   else{
                   
                         request.setAttribute("message","User Not Founded");
                         RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                         dispatcher.forward(request, response);

                   }
               
               }else{
                         request.setAttribute("message","Incorrect email or password!");
                         RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                         dispatcher.forward(request, response);
                   
               }
           
           }catch(Exception e){
              
               String m = e.getMessage();
               request.setAttribute("message", m);
               RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
              dispatcher.forward(request, response);
           
           }
        
          
    }

   
    @Override
    public String getServletInfo() {
        
        return "Short description";
    }

}
