/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */
public class QuanLy_NhanSu {
    private String maQL, maNS;

    public QuanLy_NhanSu(String maQL, String maNS) {
        this.maQL = maQL;
        this.maNS = maNS;
    }

    public QuanLy_NhanSu() {
    }
    
    public String getMaQL() {
        return maQL;
    }

    public String getMaNS() {
        return maNS;
    }

    public void setMaQL(String maQL) {
        this.maQL = maQL;
    }

    public void setMaNS(String maNS) {
        this.maNS = maNS;
    }
    
}
