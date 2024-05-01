//package admin_servlets;
//
//import javax.mail.Authenticator;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.AddressException;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author vinodrahal
// */
//public class sendMail extends HttpServlet {
//
//    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet sendMail</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet sendMail at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        //processRequest(request, response);
//        
//        String mail=request.getParameter("Email");
//        String subject=request.getParameter("subject");
//        String body=request.getParameter("body");
//    
//        final String senderEmail = "renukalakshmie@gmail.com";
//        final String senderPassword = "dwmhcsokwwfqhgqs";
//
//        // Recipient's email address
//        final String recipientEmail = mail;
//
//        // Set up mail server properties
//        Properties props = new Properties();
//        props.put("mail.smtp.auth", "true");
//        props.put("mail.smtp.starttls.enable", "true");
//        props.put("mail.smtp.host", "smtp.gmail.com");
//        props.put("mail.smtp.port", "587");
//
//        // Create a Session object
//        Session session = Session.getInstance(props, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication(senderEmail, senderPassword);
//            }
//        });
//
//        // Send the email
//        try {
//            // Create a MimeMessage object
//            MimeMessage message = new MimeMessage(session);
//
//            // Set sender and recipient email addresses
//            message.setFrom(new InternetAddress(senderEmail));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
//
//            // Set email subject and body
//            message.setSubject(subject);
//            message.setText(body);
//
//            // Send the email
//            Transport.send(message);
//
//            // Set response content type
//            response.setContentType("text/html");
//
//            // Write response message
//            PrintWriter out = response.getWriter();
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Alert!</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<script type=\"text/javascript\">");
//            out.println("alert('Email sent completed.');");
//            out.println("window.location.href = 'index.jsp';"); 
//            out.println("</script>");
//            out.println("</body>");
//            out.println("</html>");
//        } catch (MessagingException e) {
//            // Set response content type
//            response.setContentType("text/html");
//
//            // Write error message
//            PrintWriter out = response.getWriter();
//            out.println("<html><body>");
//            out.println("<h3>Error occurred while sending email: " + e.getMessage() + "</h3>");
//            out.println("</body></html>");
//        }
//    }
//        
//        
//    
//
//    
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
