/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author nguye
 */
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
public class Heandle_QuanLy {
    private static  java.sql.Connection conn = Connect_DB.sql();
    public Heandle_QuanLy() {
        conn = Connect_DB.sql();
    }
    
}
