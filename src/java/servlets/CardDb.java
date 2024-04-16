package servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CardDb {
    
    public int id,category_ID;
    public String name,description,imageName;
    boolean active;
    double price;
    
    //constructor - get values
    
    public CardDb(int id,int category_ID,String name,double price,String description,String imageName,boolean active)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.description=description;
        this.imageName=imageName;
        this.active=active;
        this.category_ID=category_ID;
        
    }
    
    public void updateDatabase() throws ClassNotFoundException
    {
        
        //declare variables
        
        Connection con;
        
        String url="jdbc:mysql://localhost:3306/choconuts";
        String dname="root";
        String dpass="";
        String query="INSERT INTO Products (id,name,description,price,image_url,category_id,is_active) VALUES(?,?,?,?,?,?,?)";
        
        
        try
        {
            //create connection
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url,dname,dpass);
            PreparedStatement pst=con.prepareStatement(query);
            
            //set values for prepared statement
            
            pst.setInt(1, id);
            pst.setString(2, name);
            pst.setString(3,description);
            pst.setDouble(4, price);
            pst.setString(5, imageName);
            pst.setInt(6,category_ID);
            pst.setBoolean(7, active);
            pst.execute();
            
            
            
        
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
