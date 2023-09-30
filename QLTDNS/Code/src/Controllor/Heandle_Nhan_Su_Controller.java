/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllor;
import DAO.NhanSu;
import Modal.Heandle_NhanSU;
import java.util.ArrayList;
/**
 *
 * @author nguye
 */
public class Heandle_Nhan_Su_Controller {
    Heandle_NhanSU ns = new Heandle_NhanSU();
    public  boolean createNhanSu(NhanSu nhansu) {
        return ns.Create(nhansu);
    }
    public  ArrayList<NhanSu> readNhanSu() {
        return ns.Read();
    }
    public  ArrayList<NhanSu> Search(String id) {
        return ns.Search(id);
    }
    public boolean deleteNhanSu(String id) {
        return ns.Delete(id);
    }
    public  boolean updateNhanSu(NhanSu sv) {
        return ns.Update(sv);
    }
}
