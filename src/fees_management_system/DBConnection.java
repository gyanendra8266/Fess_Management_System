/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fees_management_system;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Gyanendra
 */
public class DBConnection {
    public static Connection getConnection(){
     Connection con=null;  
     try{
       Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        con=DriverManager.getConnection("jdbc:derby://localhost:1527/fees_management2","root","root");     
     }
     catch(Exception e){
         e.printStackTrace();
     }
     return con;
    }
}
