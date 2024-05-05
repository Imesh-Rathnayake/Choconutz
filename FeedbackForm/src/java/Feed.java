
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
class Feed
{
    
    static Statement st;

    void addFedd(String radio, String fname, String email, String tpNo, String Msg) {
        String query = "INSERT INTO feedback VALUES('"+radio+"','"+fname+"','"+email+"','"+tpNo+"','"+Msg+"')";
        connectToDb();
        
        try {
            st.executeUpdate(query);
            System.out.println("Record inserted");
        } catch (SQLException ex) {
            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void connectToDb() {
        String driver="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/feed";
        try{
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, "root", "");
            st = con.createStatement();
        }catch(ClassNotFoundException | SQLException ex){
            Logger.getLogger(Feed.class.getName()).log(Level.SEVERE,null, ex);
        }
    }

}
