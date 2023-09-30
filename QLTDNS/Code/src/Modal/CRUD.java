/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modal;

import java.util.ArrayList;

/**
 *
 * @author nguye
 */
public interface CRUD <T>{
    boolean Create(T obj);
    ArrayList<T> Read();
    boolean Update (T obj);
    boolean Delete(String id);
    ArrayList<T> Search(String id);
}
