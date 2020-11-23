/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package purchase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.PreparedStatement;
/**
 *
 * @author asus
 */
public class SeConnecter {

    private PreparedStatement st ; 
    public static Connection con;

    
  
      String url = "jdbc:mysql://localhost/bookstore?useUnicode=true&use"+
               "JDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
     String login = "root";
     String password="";
       public SeConnecter(String url, String login, String password) throws ClassNotFoundException, SQLException {
        try
      {  
          Class.forName("com.mysql.cj.jdbc.Driver");
          con=DriverManager.getConnection(url,login, password);
          
          System.out.println("Your are connected now !!");
      }catch(SQLException ex) {
          
          
            Logger.getLogger(SeConnecter.class.getName()).log(Level.SEVERE, null, ex);
    }
       }
 public static Connection getConnection(){
        return con;
    }

}
