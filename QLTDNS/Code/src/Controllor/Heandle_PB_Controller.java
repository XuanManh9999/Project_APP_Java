/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllor;
import DAO.PhongBan;
import Modal.Heandle_PB;
import java.util.ArrayList;
/**
 *
 * @author nguye
 */
public class Heandle_PB_Controller {
    Heandle_PB pb = new Heandle_PB();
    public  boolean createPhongBan(PhongBan phongban) {
        return pb.Create(phongban);
    }
    public  ArrayList<PhongBan> readPhongBan() {
        return pb.Read();
    }
    public  ArrayList<PhongBan> Search_theoTen(String id) {
        return pb.Search(id);
    }
     public  ArrayList<PhongBan> Search_theoMa(String id) {
        return pb.Search_theoMa(id);
    }
    public boolean deletePhongBan(String id) {
        return pb.Delete(id);
    }
    public  boolean updatePhongBan(PhongBan sv) {
        return pb.Update(sv);
    }
}
