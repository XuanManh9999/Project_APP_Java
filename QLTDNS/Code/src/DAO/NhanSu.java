/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */
public class NhanSu extends Nguoi{
    private String maPB;

    public NhanSu() {
    }

    public NhanSu(String ma, String ten, String diaChi, String sdt, String ngaySinh, String maPB) {
        super(ma, ten, diaChi, sdt, ngaySinh);
        this.maPB = maPB;
    }

    public String getMaPB() {
        return maPB;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    
    
}
