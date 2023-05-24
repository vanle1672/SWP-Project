/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Chuyenkhoa {
    private int specialtyID;
    private String specialtyName;

    public Chuyenkhoa() {
    }

    public Chuyenkhoa(int specialtyID, String specialtyName) {
        this.specialtyID = specialtyID;
        this.specialtyName = specialtyName;
    }

    public int getSpecialtyID() {
        return specialtyID;
    }

    public void setSpecialtyID(int specialtyID) {
        this.specialtyID = specialtyID;
    }

    public String getSpecialtyName() {
        return specialtyName;
    }

    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    @Override
    public String toString() {
        return "Chuyenkhoa{" + "specialtyID=" + specialtyID + ", specialtyName=" + specialtyName + '}';
    }
    
}
