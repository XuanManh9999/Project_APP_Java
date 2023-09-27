/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */
public class QuanLy_PhongBan {
    private String mqQL, maPB;   

    public QuanLy_PhongBan() {
    }
    
    public QuanLy_PhongBan(String mqQL, String maPB) {
        this.mqQL = mqQL;
        this.maPB = maPB;
    }

    public String getMqQL() {
        return mqQL;
    }

    public String getMaPB() {
        return maPB;
    }

    public void setMqQL(String mqQL) {
        this.mqQL = mqQL;
    }

    public void setMaPB(String maPB) {
        this.maPB = maPB;
    }
    
}
