/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import dao.CounselorDAO;
import java.util.ArrayList;
import model.Counselor;

/**
 *
 * @author reina
 */
public class CounselorController {
    //Method to retrieve all counselor names
    public static ArrayList<String> getAllCounselorNames() {
        CounselorDAO dao = new CounselorDAO();
        return dao.getAllCounselorNames();
    }
    // Method to retrieve all counselors
    public static ArrayList<Counselor> getAllCounselors() {
        CounselorDAO dao = new CounselorDAO();
        return dao.getAllCounselors();
    }
    //Method to add a new counselor
    public static boolean addCounselor(String name, String specialization,String availability) {
        CounselorDAO dao = new CounselorDAO();
        Counselor newCounselor = new Counselor(0, name, specialization, availability);
        try {
            dao.insertCounselor(newCounselor);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    
    //Method to delete a counselor by name
    public static boolean deleteCounselor(String name){
        CounselorDAO dao = new CounselorDAO();
        boolean success = dao.deleteCounselorByName(name);
        return success;
    }
    //Method to update counselor details    
    public static boolean updateCounselor(String originalName, String newName, String specialization, String availability) {
        CounselorDAO dao = new CounselorDAO();
        int id = dao.getCounselorIdByName(originalName);

        if (id == -1) {
            return false;
        }

        Counselor updated = new Counselor(id, newName, specialization, availability);
        try {
            dao.updateCounselor(updated);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }    
}
