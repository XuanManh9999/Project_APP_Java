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
import DAO.PhongBan;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Heandle_PB  implements CRUD<PhongBan>{
    private static  java.sql.Connection conn = Connect_DB.sql();
    public Heandle_PB() {
        conn = Connect_DB.sql();
    }

    @Override
    public boolean Create(PhongBan obj) {
        try {
            String query = String.format("insert into phongban values ('%s', '%s', '%s')", obj.getMaPB(), obj.getTenPB(), obj.getDiaChi());
            var st = conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
                    return false; 
//            Logger.getLogger(hendle_QL_SV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<PhongBan> Read() {
        try {
            ArrayList<PhongBan> phongban = new ArrayList<PhongBan>();
            String query = "select * from phongban";
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            Connect_DB.closeConnectDB();
            while (rs.next()) {
                PhongBan s = new PhongBan(rs.getString(1), rs.getString(2), rs.getString(3) );
                phongban.add(s);
            }
            return phongban;
        } catch (SQLException ex) {
            return null;
        }
    }

    @Override
    public boolean Update(PhongBan obj) {
         try {
            String query = String.format("update  phongban set tenpb = '%s', diachi = '%s' where mapb = '%s'", 
            obj.getTenPB(), obj.getDiaChi(), obj.getMaPB());
            var st = conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
                    return false; 
//            Logger.getLogger(hendle_QL_SV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean Delete(String id) {
         try {
            String query = String.format("delete from phongban where mapb = '%s'", id);
            var st = conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
                    return false;
        }
    }

    @Override
    public ArrayList<PhongBan> Search(String id) {
        try {
            ArrayList<PhongBan> dsSV = new ArrayList<PhongBan>();
            String query = String.format("SELECT * FROM phongban WHERE tenPB LIKE '%%%s%%'", id);
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            Connect_DB.closeConnectDB();
            while (rs.next()) {
                PhongBan s = new PhongBan(rs.getString(1), rs.getString(2), rs.getString(3) );
                dsSV.add(s);
            }
            return dsSV;
        } catch (SQLException ex) {
                    return null;
        }
    }
    public ArrayList<PhongBan> Search_theoMa(String id) {
        try {
            ArrayList<PhongBan> dsSV = new ArrayList<PhongBan>();
            String query = String.format("SELECT * FROM nhansu WHERE mapb = '%s'", id);
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            Connect_DB.closeConnectDB();
            while (rs.next()) {
                PhongBan s = new PhongBan(rs.getString(1), rs.getString(2), rs.getString(3) );
                dsSV.add(s);
            }
            return dsSV;
        } catch (SQLException ex) {
                    return null;
        }
    }
}
