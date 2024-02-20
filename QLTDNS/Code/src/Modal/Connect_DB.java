/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nguye
 */
public class Connect_DB {
    private static  java.sql.Connection conn;
    public Connect_DB() {
        
    }
    public static java.sql.Connection sql() {
         try { 
            Class.forName("com.sun.jdi.connect.spi.Connection");
        
             conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/qlns?useSSL=false", "root", "");
             return  conn;
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void closeConnectDB() {
        conn = null;
    }
}
