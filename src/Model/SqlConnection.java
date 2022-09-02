/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Hadaragama
 */
public class SqlConnection {
    public static Connection getCon(){
        
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/harith","root","");
            return con;
            
        } catch (Exception e) {
            
            return null;
        }
    
}
}
