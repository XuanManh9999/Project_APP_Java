/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */
public class PhongBan {
    private String maPB;
    private String tenPB;
    private String diaChi;

    public PhongBan() {
    }

    public PhongBan(String maPB, String tenPB, String diaChi) {
        this.maPB = maPB;
        this.tenPB = tenPB;
        this.diaChi = diaChi;
    }

    public String getMaPB() {
        return maPB;
    }

    public String getTenPB() {
        return tenPB;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public void setTenPB(String tenPB) {
        this.tenPB = tenPB;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
}
