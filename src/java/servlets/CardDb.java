
package servlets;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;



public class CardDb {
    
    public int no;
    public String title,price,description,imageName;
    
    
    //constructor - get values
    
    public CardDb(int no,String title,String price,String description,String imageName)
    {
        this.no=no;
        this.title=title;
        this.price=price;
        this.description=description;
        this.imageName=imageName;                
    }
    
    public void updateDatabase() throws ClassNotFoundException
    {
        
        //declare variables
        
        Connection con;
        
        String url="jdbc:mysql://localhost:3306/Donut";
        String dname="root";
        String dpass="";
        String query="UPDATE Products SET Title=?,Price=?,Image=?,Description=? WHERE PID=?";
        
        
        
        
        try
        {
            //create connection
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,dname,dpass);
            PreparedStatement pst=con.prepareStatement(query);
            
            //set values for prepared statement
            
            pst.setString(1, title);
            pst.setString(2, price);
            pst.setString(3,imageName);
            pst.setString(4,description);
            pst.setInt(5, no);
            
            pst.execute();
            
            
            
        
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
