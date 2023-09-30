/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllor;
import Modal.hendale_cham_cong;
import java.sql.ResultSet;
/**
 *
 * @author nguye
 */
public class Heandle_ChamCong {
    hendale_cham_cong cc = new hendale_cham_cong();
    public ResultSet readData() {
        return cc.data();
    }
    public boolean chamCongController (String matc, int soTang) {
        return cc.updateNgayCong(matc, soTang);
    }
    public boolean giamCongController (String matc, int soGiam) {
        return cc.updateNgayCong_giamCong(matc, soGiam);
    }
    public ResultSet search_Name(String name) {
        return cc.searchTheoTen(name);
    }
    public ResultSet search_id(String ma) {
        return cc.searchTheoMa(ma);
    }
}
