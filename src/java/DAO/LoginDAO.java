/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Account;
import contact.ContactDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class LoginDAO {

    Connection con = null;
    PreparedStatement p1 = null;
    ResultSet re = null;
    private final ArrayList<Account> resultac = new ArrayList<>();

    public Account login(String email, String pass) {
        String stm1 = "SELECT * FROM accounts\n"
                + "WHERE email = ?\n"
                + "AND pass = ?";

        try {
            this.con = ContactDB.makeConnection();
            p1 = con.prepareStatement(stm1);
            p1.setString(1, email);
            p1.setString(2, pass);
            re = p1.executeQuery();
            while (re.next()) {
                return new Account(re.getInt(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5),
                        re.getString(6), re.getString(7), re.getString(8), re.getString(9), re.getString(10), re.getString(11));

            }
        } catch (Exception e) {
        }

        return null;
    }

    public Account checkAccountExist(String email) {
        String stm1 = "select * from accounts where email = ?";

        try {
            this.con = ContactDB.makeConnection();
            p1 = con.prepareStatement(stm1);
            p1.setString(1, email);
            re = p1.executeQuery();
            while (re.next()) {
                return new Account(re.getInt(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5),
                        re.getString(6), re.getString(7), re.getString(8), re.getString(9), re.getString(10), re.getString(11));

            }
        } catch (Exception e) {
        }

        return null;
    }

    public void signup(String email, String pass, String name, String phone) {
        String stm1 = "INSERT INTO accounts (email, pass, [name], phoneNumber, dob, gender, address, isUser, isDoctor, isAdmin) "
                + "VALUES (?, ?, ?, ?, NULL, NULL, NULL, 1, 0, 0)";

        try {
            this.con = ContactDB.makeConnection();
            PreparedStatement p1 = con.prepareStatement(stm1);
            p1.setString(1, email);
            p1.setString(2, pass);
            p1.setString(3, name);
            p1.setString(4, phone);
            p1.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Account> getID(String cid) throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "select * from accounts\n"
                    + "where ID = ?";

            p1 = con.prepareStatement(stm1);
            p1.setString(1, cid);
            re = p1.executeQuery();
            while (re.next()) {
                resultac.add(new Account(re.getInt(1), re.getString(2), re.getString(3), re.getString(4), re.getString(5)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return resultac;
    }

}
