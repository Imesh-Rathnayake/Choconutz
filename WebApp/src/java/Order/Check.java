/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Order;

/**
 *
 * @author 94781
 */
class Check {

    void addOrder(String name, String number, String email, String method, String flat, String street, String city, String state, String country, String pin_code) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        connectToDb();
    }

    private void connectToDb() {
        String driver="com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/mysq";//data base name eka danna
        
        
    }
    
}
