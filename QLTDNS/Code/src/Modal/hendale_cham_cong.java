/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

import DAO.PhongBan;
import java.sql.SQLException;
import java.util.ArrayList;
import DAO.NhanSu;
import DAO.NgayCong;
import DAO.ChamCong;
import com.mysql.cj.xdevapi.Result;
import java.sql.ResultSet;
/**
 *
 * @author nguye
 */
public class hendale_cham_cong {
    private String maTC = "";
    private static  java.sql.Connection conn = Connect_DB.sql();
    public hendale_cham_cong() {
        conn = Connect_DB.sql();
    }
//    public boolean hendeleTableNgayCong() {
//         conn = Connect_DB.sql();
//    }
    
     public  ResultSet data() {
        try {
            String query = "select nhansu.maNS, nhansu.tenNS, nhansu.diaChi, nhansu.sdt, nhansu.ngaySinh, nhansu.vitri, nhansu.maPB, "
            + "ngaycong.maNC, ngaycong.soNC from nhansu INNER JOIN cham_cong on nhansu.maNS = cham_cong.maNS "
            + "INNER JOIN ngaycong on cham_cong.maNC = ngaycong.maNC;";
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            Connect_DB.closeConnectDB();
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }
      public boolean updateNgayCong(String maNC, int soTang) {
         try {
            String query = String.format("update ngaycong set sonc = sonc +  %d where manc = '%s'", 
           soTang,maNC);
            var st = conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
                    return false; 
//            Logger.getLogger(hendle_QL_SV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public boolean updateNgayCong_giamCong(String maNC, int soGiam) {
         try {
            String query = String.format("update ngaycong set sonc = soNC -  %d where manc = '%s'", 
           soGiam, maNC);
            var st = conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
                    return false; 
//            Logger.getLogger(hendle_QL_SV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public ResultSet searchTheoTen(String name) {
          try {
            String query = String.format("select nhansu.maNS, nhansu.tenNS, nhansu.diaChi, nhansu.sdt, nhansu.ngaySinh, \n" +
            "nhansu.vitri, nhansu.maPB, ngaycong.maNC, ngaycong.soNC from nhansu INNER JOIN\n" +
            "cham_cong on nhansu.maNS = cham_cong.maNS INNER JOIN ngaycong on cham_cong.maNC\n" +
            " = ngaycong.maNC where nhansu.tenNS LIKE '%%%s%%'", name);
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            Connect_DB.closeConnectDB();
            return rs;
        } catch (SQLException ex) {
            return null;
        }
      }
      public ResultSet searchTheoMa(String ma) {
          try {
            String query = String.format("select nhansu.maNS, nhansu.tenNS, nhansu.diaChi, nhansu.sdt, nhansu.ngaySinh, \n" +
"nhansu.vitri, nhansu.maPB, ngaycong.maNC, ngaycong.soNC from nhansu INNER JOIN \n" +
"cham_cong on nhansu.maNS = cham_cong.maNS INNER JOIN ngaycong on cham_cong.maNC\n" +
" = ngaycong.maNC where nhansu.maNS = '%s'", ma);
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            Connect_DB.closeConnectDB();
            return rs;
        } catch (SQLException ex) {
            return null;
        }
      }
}
