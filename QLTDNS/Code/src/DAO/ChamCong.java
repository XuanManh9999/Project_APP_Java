/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */
public class ChamCong {
    private String maNS;
    private String maNC;
    private String ghiChu;

    public ChamCong() {
    }

    public ChamCong(String maNS, String maNC, String ghiChu) {
        this.maNS = maNS;
        this.maNC = maNC;
        this.ghiChu = ghiChu;
    }

    public String getMaNS() {
        return maNS;
    }

    public String getMaNC() {
        return maNC;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setMaNS(String maNS) {
        this.maNS = maNS;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
}
