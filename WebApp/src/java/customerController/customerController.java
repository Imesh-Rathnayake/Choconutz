/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerController;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.http.HttpSession;

/**
 *
 * @author asus
 */
public class customerController {
    
    public String customerRegister(String username,String email,String phone,String password){
      
      try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts","root","");
           
            //get data from login table using query
            Statement stm =  con.createStatement();
            ResultSet rs = stm.executeQuery("select * from users where name='"+username+"' or email='"+email+"'");
 
            if(!rs.next()){
            
            
              String insertQuery = "INSERT INTO users(name,email,phone_number,password) VALUES(?,?,?,?)";
              
              PreparedStatement preparedStatement = con.prepareStatement(insertQuery);
              
              preparedStatement.setString(1,username);
              preparedStatement.setString(2,email);
              preparedStatement.setString(3,phone);
              preparedStatement.setString(4,password);
              
               preparedStatement.executeUpdate();
               return "true";
            
            }
            else{
             return "false";
            
            }
         
      
      }
      catch(Exception e){
               
                  return e.getMessage();
      }
        
     
  
    }
    
    
    public String customerUpdate(int userId, String username, String email, String phoneNumber, String imgURL) {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");

        // Check if user with given userId exists
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE id=?");
        stmt.setInt(1, userId);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Update user information
            String sql = "UPDATE users SET name=?, email=?, phone_number=?, image=? WHERE id=?";
            PreparedStatement updateStmt = con.prepareStatement(sql);
            updateStmt.setString(1, username);
            updateStmt.setString(2, email);
            updateStmt.setString(3, phoneNumber);
            updateStmt.setString(4, imgURL);
            updateStmt.setInt(5, userId);
            int rowsAffected = updateStmt.executeUpdate();

            if (rowsAffected > 0) {
                return "Customer information updated successfully";
            } else {
                return "Failed to update customer information";
            }
        } else {
            return "User with ID " + userId + " not found";
        }
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
}

        public String customerPasswordUptade(int userId, String oldPwd,String NewPwd){
          try {
        // Establish database connection
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts", "root", "");

        // Check if old password matches
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM users WHERE id=? AND password=?");
        stmt.setInt(1, userId);
        stmt.setString(2, oldPwd);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            // Update password if old password matches
            PreparedStatement updateStmt = con.prepareStatement("UPDATE users SET password=? WHERE id=?");
            updateStmt.setString(1, NewPwd);
            updateStmt.setInt(2, userId);
            int rowsAffected = updateStmt.executeUpdate();

            if (rowsAffected > 0) {
                return "Password updated successfully";
            } else {
                return "Failed to update password";
            }
        } else {
            return "Incorrect old password";
        }
    } catch (Exception e) {
        e.printStackTrace();
        return "Error: " + e.getMessage();
    }
    
        }
    
}
