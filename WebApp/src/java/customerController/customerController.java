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
            ResultSet rs = stm.executeQuery("select * from customers where username='"+username+"' or email='"+email+"'");
 
            if(!rs.next()){
            
            
              String insertQuery = "INSERT INTO customers(username,email,phone_number,password) VALUES(?,?,?,?)";
              
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
    
    
    public String customerUptade(int userId,String username,String email,String phoneNumber, String oldPwd , String newPwd ,String ImgURL ){
         
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts","root","");
             Statement stm =  con.createStatement();
             PreparedStatement stmt = null;
            ResultSet rs = stm.executeQuery("select * from customers where id='"+userId+"'" );
            
            if(rs.next()){
//                if(oldPwd.equals(rs.getString("password"))){
//                    
//                  String sql = "UPDATE customers SET password=? WHERE userId=?";
//                  stmt = con.prepareStatement(sql);
//                  stmt.setString(1, newPwd);
//                  stmt.executeUpdate();
//                  return "password is changed unsuccessfully";
//                  
//                }
//                else{
//                  return "password is changed unsuccessfully";
//                
//                }
                String sql2 = "UPDATE users SET username=?, email=?, phone_number=?, image_url=? WHERE id=?";
                stmt = con.prepareStatement(sql2);
                stmt.setString(1, username);
                stmt.setString(2, email);
                stmt.setString(3, phoneNumber);
                stmt.setString(4, ImgURL);
                stmt.setInt(5, userId);
                stmt.executeUpdate();
                return "Customer information updated successfully";
            }
            
            else{
                return "Update Unsuccessfully";
            }
            
        }catch(Exception e){
        
           return e.getMessage();
        }
        
       
        

    }
    
        public String customerPasswordUptade(int userId, String oldPwd,String NewPwd){
           try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/choconuts","root","");
             Statement stm =  con.createStatement();
             PreparedStatement stmt = null;
            ResultSet rs = stm.executeQuery("select * from customers where id='"+userId+"'" );
            
            if(rs.next()){
                if(oldPwd.equals(rs.getString("password"))){
                    
                  String sql = "UPDATE customers SET password=? WHERE userId=?";
                  stmt = con.prepareStatement(sql);
                  stmt.setString(1, NewPwd);
                  stmt.executeUpdate();
                  return "password is changed unsuccessfully";
                  
                }
                else{
                  return "password is changed unsuccessfully";
                
                }
             
            }
            
            else{
                return "Update Unsuccessfully";
            }
            
        }catch(Exception e){
        
           return e.getMessage();
        }
       
        }
    
   
    
}
