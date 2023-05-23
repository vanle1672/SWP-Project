/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Bacsi {
    private int doctorID;
    private String doctorName;
    private String specialization;
    private String degree;
    private int experience;
    private int specialtyID;
     private String image;

    public Bacsi() {
    }

    public Bacsi(int doctorID, String doctorName, String specialization, String degree, int experience, int specialtyID, String image) {
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.degree = degree;
        this.experience = experience;
        this.specialtyID = specialtyID;
        this.image = image;
    }

    public int getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(int doctorID) {
        this.doctorID = doctorID;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getSpecialtyID() {
        return specialtyID;
    }

    public void setSpecialtyID(int specialtyID) {
        this.specialtyID = specialtyID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Bacsi{" + "doctorID=" + doctorID + ", doctorName=" + doctorName + ", specialization=" + specialization + ", degree=" + degree + ", experience=" + experience + ", specialtyID=" + specialtyID + ", image=" + image + '}';
    }
          
}
