
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;




@MultipartConfig(
        
        fileSizeThreshold = 1024 * 1024 * 1,
        maxFileSize=1024 * 1024 * 10,
        maxRequestSize = 1024 * 1024 * 100
)
  
       
public class updateCard extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateCard</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateCard at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException 
    {
        
        PrintWriter out=response.getWriter();
        
        //Get text input values
        
        int crdNo=Integer.parseInt(request.getParameter("crdNo"));
        String title=request.getParameter("Title");
        String price=request.getParameter("crdPrice");
        String discription=request.getParameter("discript");
        
        
        // To Get file_input's details and move it
        
        Part imagePart=request.getPart("file1");
        String imageName=imagePart.getSubmittedFileName();
       
        FileOutputStream outputStream = new FileOutputStream(new File("/Users/vinodrahal/NetBeansProjects/webApp1/Choconutz/web/images/cardImage/" + imageName));
        
        out.println(crdNo+"\n"+title+"\n"+price+"\n"+discription+"\n"+imageName);   //for testing parameters
        
        
        // To write moved file
        
        InputStream inputStream = imagePart.getInputStream();
        
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) 
        {
            
            outputStream.write(buffer, 0, bytesRead);
        
        }
        
        outputStream.close();
        inputStream.close();
        
        
        
        // Call CardDb class to update card
        
        CardDb card=new CardDb(crdNo,title,price,discription,imageName);
        
        try 
        {
            card.updateDatabase();
            
            
            response.sendRedirect("index.jsp");
            
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(updateCard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
