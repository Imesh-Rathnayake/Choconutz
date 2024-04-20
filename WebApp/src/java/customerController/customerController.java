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
    
    
   
    
}
