/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author nguye
 */
public class NgayCong {
    private String maNC;
    private int soNC;

    public NgayCong() {
    }

    public NgayCong(String maNC, int soNC) {
        this.maNC = maNC;
        this.soNC = soNC;
    }

    public String getMaNC() {
        return maNC;
    }

    public int getSoNC() {
        return soNC;
    }

    public void setSoNC(int soNC) {
        this.soNC = soNC;
    }

    public void setMaNC(String maNC) {
        this.maNC = maNC;
    }
    
}
