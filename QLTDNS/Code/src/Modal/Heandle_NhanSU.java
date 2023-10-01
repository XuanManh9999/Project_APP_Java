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
import DAO.NhanSu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Heandle_NhanSU  implements CRUD<NhanSu>{
    private static  java.sql.Connection conn = Connect_DB.sql();
    private String maNC = "";
    private String maNS = "";
    public Heandle_NhanSU() {
        conn = Connect_DB.sql();
    }

    @Override
    public boolean Create(NhanSu obj) {
        maNS = "";
        maNS = obj.getMa();
        try {
            String query = String.format("insert into nhansu values ('%s', '%s', '%s', '%s', '%s', '%s', '%s')", obj.getMa(), obj.getTen(),
            obj.getDiaChi(),obj.getSdt(), obj.getNgaySinh(),obj.getViTri() ,obj.getMaPB());
            var st = conn.createStatement();
            int check = st.executeUpdate(query);
            if (check > 0) {
                System.out.println("Khởi Tạo Thành Công Nhân Sự");
                if (createNgayCong()) {
                    System.out.println("Khởi Tạo Thành Công Ngày Công");
                    if (createChamCong()) {
                        System.out.println("Khởi Tạo thành Công Chấm Công");
                        return true;
                    }
                } 
            }
        } catch (SQLException ex) {
                    return false; 
//            Logger.getLogger(hendle_QL_SV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
   
    @Override
    public ArrayList<NhanSu> Read() {
        try {
            ArrayList<NhanSu> nhansu = new ArrayList<NhanSu>();
            String query = "select * from nhansu";
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            Connect_DB.closeConnectDB();
            while (rs.next()) {
                NhanSu s = new NhanSu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toString(), rs.getString(6), rs.getString(7) );
                nhansu.add(s);
            }
            return nhansu;
        } catch (SQLException ex) {
            return null;
        }
    }
    @Override
    public boolean Update(NhanSu obj) {
         try {
            String query = String.format("update  nhansu set tenns = '%s', diachi = '%s', sdt = '%s', ngaysinh = '%s', viTri = '%s', mapb = '%s' where mans = '%s'", 
            obj.getTen(), obj.getDiaChi(), obj.getSdt(), obj.getNgaySinh(), obj.getViTri(), obj.getMaPB(), obj.getMa());
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
            String getNC = getMa_NC(id);
            if(delete_chamCong(id)) {
                System.out.println("Xoa Cham Cong Done");
                int check = 0;
                String query = String.format("delete from nhansu where mans = '%s'", id);
                var st = conn.createStatement();
                check =  st.executeUpdate(query);
                if(check > 0) {
                    System.out.println("Xoa Nhan Su Done");
                    if (delete_ngayCong(getNC)) {
                        System.out.println("Xoa Ngay Cong Done");
                        return true;
                    }
                }
            }
            
        } catch (SQLException ex) {
                    return false;
        }
         return false;
    }

    @Override
    public ArrayList<NhanSu> Search(String id) {
        try {
            ArrayList<NhanSu> dsSV = new ArrayList<NhanSu>();
            String query = String.format("SELECT * FROM nhansu WHERE tenns LIKE '%%%s%%'", id);
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            Connect_DB.closeConnectDB();
            while (rs.next()) {
                NhanSu s = new NhanSu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5).toString(), rs.getString(6), rs.getString(7) );
                dsSV.add(s);
            }
            return dsSV;
        } catch (SQLException ex) {
                    return null;
        }
    }
    private ArrayList<String> getMaNgayCong() {
        try {
            ArrayList<String> dsMa = new ArrayList<String>();
            String query = "select manc from ngaycong";
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            Connect_DB.closeConnectDB();
            while (rs.next()) {
               dsMa.add(rs.getString(1));
            }
            return dsMa;
        } catch (SQLException ex) {
            return null;
        }
    }
    private boolean createChamCong() {
        try {
            String query = String.format("insert into cham_cong values ('%s', '%s', '%s')", maNS, maNC, "");
            var st = conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
                    return false; 
//            Logger.getLogger(hendle_QL_SV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean createNgayCong() {
        maNC = "";
        String ma = random_ma(getMaNgayCong());
        maNC = ma;
        try {
            String query = String.format("insert into ngaycong values ('%s', %d)", maNC, 0);
            var st = conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
                    return false; 
//            Logger.getLogger(hendle_QL_SV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private boolean delete_chamCong(String mans) {
        try {
            String query = String.format("DELETE FROM cham_cong where maNS = '%s'", mans);
            var st = conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
                    return false;
        }
        
    }
     private boolean delete_ngayCong(String NC) {
        try {
            String query = String.format("delete from ngaycong where manc = '%s'", NC);
            var st = conn.createStatement();
            return st.executeUpdate(query) > 0;
        } catch (SQLException ex) {
                    return false;
        }
    }
    private String getMa_NC (String mans) {
        // Lay ma nc 
        String manc = "";
        try {
            String query = String.format("SELECT DISTINCT ngaycong.maNC from nhansu \n" +
            "INNER JOIN cham_cong on '%s' = cham_cong.maNS\n" +
            "INNER JOIN ngaycong on cham_cong.maNC = ngaycong.maNC", mans);
            var st = conn.createStatement();
            var rs = st.executeQuery(query);
            while (rs.next()) {
               manc = rs.getString(1);
            }
            return manc;
        } catch (SQLException ex) {
            return null;
        }
        
    }
    
private static String random_ma(ArrayList<String> existingCodes) {
        String uniqueCode;
        do {
            // Tạo 3 chữ số ngẫu nhiên từ 100 đến 999
             Random random = new Random();
            int randomNumber = 100 + random.nextInt(900);
            uniqueCode = "NC" + randomNumber;
        } while (existingCodes.contains(uniqueCode)); // Kiểm tra xem mã đã tồn tại trong danh sách hay chưa

        return uniqueCode;
    }

  
   
}
