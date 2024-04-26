/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memberpackage;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author DELL
 */
class member {
    Statement st;

    void addmember(String name, String city, String tele, String email) {
        String query ="INSERT INTO member(name,city,tele,email) VALUES('"+name"','"+city"','"+tele"','"+email"')";
        connectToDb();
        try{
           st.executeUpdate(query); 
        }catch (SQLException ex){
            Logger.getLogger(member.class.getName().log(Level.SEVERE,null,ex));
        }
        
    }
  
    private void connectToDb(){
        String driver="com.mysql.jdbc.Driver";
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url,"root","");
            st = con.createStatement();
        }catch(ClassNotFoundException ex){
            Logger.getGlobal(member.class.getName().log(Level.SEVERE,null,ex));
        }
    }
}
