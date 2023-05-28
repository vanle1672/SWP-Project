/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ASUS
 */
public class Account {
    private int id;
    private String email;
    private String pass;
    private String name;
    private String phone;
    private String dob;
    private String gender;
    private String address;
    private String isUser;
    private String isDoctor;
    private String isAdmin;

    public Account() {
    }

    public Account(String email, String pass, String name, String phone) {
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.phone = phone;

    }

   
  

    public Account(int id, String email, String pass, String name, String phone, String dob, String gender, String address, String isUser, String isDoctor, String isAdmin) {
        this.id = id;
        this.email = email;
        this.pass = pass;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.isUser = isUser;
        this.isDoctor = isDoctor;
        this.isAdmin = isAdmin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIsUser() {
        return isUser;
    }

    public void setIsUser(String isUser) {
        this.isUser = isUser;
    }

    public String getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(String isDoctor) {
        this.isDoctor = isDoctor;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "id=" + id + ", email=" + email + ", pass=" + pass + ", name=" + name + ", phone=" + phone + ", dob=" + dob + ", gender=" + gender + ", address=" + address + ", isUser=" + isUser + ", isDoctor=" + isDoctor + ", isAdmin=" + isAdmin + '}';
    }
    
}
