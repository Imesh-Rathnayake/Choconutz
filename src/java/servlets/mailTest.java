
package servlets;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;


public class mailTest {
    
    
    public static void main(String[] args) {
        // Sender's email address and password
        final String senderEmail = "renukalakshmie@gmail.com";
        final String senderPassword = "dwmh csok wwfq hgqs";

        // Recipient's email address
        final String recipientEmail = "maxvinodrahal@gmail.com";

        // Set up mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Create a Session object
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        // Send the email
        try {
            // Create a MimeMessage object
            MimeMessage message = new MimeMessage(session);

            // Set sender and recipient email addresses
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));

            // Set email subject and body
            message.setSubject("Test Email from Java");
            message.setText("Hello,\n\nThis is a test email sent from Java.");

            // Send the email
            Transport.send(message);

            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            System.err.println("Error occurred while sending email: " + e.getMessage());
        }
    }
    
}
