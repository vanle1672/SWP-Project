package Dao;

import Contact.ContactDB;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    public boolean createUser(String name, String email, String password, String phone, String verify_key, String address, String dob, boolean gender) throws ClassNotFoundException {
        String sql = "insert into patients(name, email, password, phone, dob, gender, address, is_admin, verify_key, is_verified) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            this.connection = ContactDB.makeConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, dob);
            preparedStatement.setBoolean(6, gender);
            preparedStatement.setString(7, address);
            preparedStatement.setBoolean(8, false);
            preparedStatement.setString(9, verify_key);
            preparedStatement.setBoolean(10, false);
            preparedStatement.execute();
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean emailExist(String email) throws SQLException, ClassNotFoundException {
        String sql = "select count(id) from patients where email = ?";
        this.connection = ContactDB.makeConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            int status = resultSet.getInt(1);
            if (status == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


    public User getPatientById(int id){
        String query = "select * from patients where id = ?;";
        try{
            connection = ContactDB.makeConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getBoolean(7), resultSet.getString(8), resultSet.getBoolean(9), resultSet.getString(10), resultSet.getBoolean(11));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public boolean updateUser(int id, String name, String email, String password, String dob, boolean gender, String address, String phone){
        String sql = "update patients set name = ?, email = ?, password = ?, dob = ?, gender = ?, address = ?, phone = ? where id = ?";
        try {
            connection = ContactDB.makeConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, dob);
            preparedStatement.setBoolean(5, gender);
            preparedStatement.setString(6, address);
            preparedStatement.setString(7, phone);
            preparedStatement.setInt(8, id);
            preparedStatement.execute();
            return true;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
