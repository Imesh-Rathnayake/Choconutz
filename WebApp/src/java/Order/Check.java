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
    
    void addOrder(int bookid, String title, String author) throws SQLException {
        
        String query = "INSERT INTO book VALUES("+bookid+",'"+title+"','"+author+"')";
        connectToDb();
        
        try {
            st.executeUpdate(query);
            System.out.println("Record inserted");
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        }

    private void connectToDb() {
        String driver="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/choconutz";
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, "root", "");
            st = con.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
    
}
