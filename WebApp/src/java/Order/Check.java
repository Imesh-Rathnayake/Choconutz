/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 94781
 */
class Check {

    static Statement st;

    private void connectToDb() {
        String driver="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/choconutz";
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, "root", "");
            st = con.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Check.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

    void addOrder(String name, String number, String email, int method, String flat, String street, String city, String state, String country, String pin_code) {
       
        String query = "INSERT INTO customers (customer_id,fname,number,email,shipp_address,pin_code) VALUES('"+method+"','"+name+"','"+number+"','"+email+"','"+flat+","+street+","+city+","+state+","+country+",'"+pin_code+"')";
        connectToDb();
        
        try {
            st.executeUpdate(query);
            System.out.println("Record inserted");
        } catch (SQLException ex) {
            Logger.getLogger(Check.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
