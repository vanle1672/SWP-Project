/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Contact.ContactDB;
import Model.Blog;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class BlogDao {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public ArrayList<Blog> getAllBlog() throws ClassNotFoundException, SQLException {

        ArrayList<Blog> blogArrayList = new ArrayList<>();
        String sql = "select * from Blog order by BlogID desc;";
        connection = new ContactDB().makeConnection();
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            blogArrayList.add(new Blog(
                    resultSet.getInt("Blogid"),
                    resultSet.getInt("day"),
                    resultSet.getString("month"),
                    resultSet.getString("title"),
                    resultSet.getString("scriptShort"),
                    resultSet.getString("scriptFull"),
                    resultSet.getString("image")));
        }
        return blogArrayList;
    }

    public ArrayList<Blog> searchBlog(String name) throws ClassNotFoundException, SQLException {
        ArrayList<Blog> blogArrayList = new ArrayList<>();
        String sql = "SELECT * FROM Blog WHERE [Day] LIKE ? OR [Month] LIKE ? OR Title LIKE ? OR ScriptShort LIKE ?";
        connection = new ContactDB().makeConnection();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + name + "%");
        preparedStatement.setString(2, "%" + name + "%");
        preparedStatement.setString(3, "%" + name + "%");
        preparedStatement.setString(4, "%" + name + "%");
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            blogArrayList.add(new Blog(
                    resultSet.getInt("Blogid"),
                    resultSet.getInt("day"),
                    resultSet.getString("month"),
                    resultSet.getString("title"),
                    resultSet.getString("scriptShort"),
                    resultSet.getString("scriptFull"),
                    resultSet.getString("image")));
        }
        return blogArrayList;
    }

    public Blog getBlogByID(String bid) throws ClassNotFoundException, SQLException {
//         con = null;
        String sql = "SELECT * FROM Blog where BlogID = ?";
        try {
            connection = new ContactDB().makeConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bid);
            resultSet = preparedStatement.executeQuery();
            Blog blog = null;
            while (resultSet.next()) {
                blog = new Blog(
                        resultSet.getInt("Blogid"),
                        resultSet.getInt("day"),
                        resultSet.getString("month"),
                        resultSet.getString("title"),
                        resultSet.getString("scriptShort"),
                        resultSet.getString("scriptFull"),
                        resultSet.getString("image"));
            }
            return blog;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean createBlog(int day, String month, String title, String scriptshort, String scriptfull, String image) {
        String sql = "insert into Blog(day,month, title,scriptshort,scriptfull,image) values(?, ?, ?, ?, ?,?)";
        try {
            this.connection = ContactDB.makeConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, day);
            preparedStatement.setString(2, month);
            preparedStatement.setString(3, title);
            preparedStatement.setString(4, scriptshort);
            preparedStatement.setString(5, scriptfull);
            preparedStatement.setString(6, image);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
        public boolean deleteBlog(int Blogid) {
        String sql = "DELETE FROM Blog WHERE BlogID = ?";
        try {
            connection = ContactDB.makeConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, Blogid);
            preparedStatement.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
        public boolean UpdateBlogNoImg(int id, int day, String month, String title, String scriptshort, String scriptfull) {
        try {
            String sql = "update Blog set Day = ?, Month = ?, Title = ?, ScriptShort = ?, ScriptFull = ? where BlogID = ? ;";
            connection = ContactDB.makeConnection();
            preparedStatement = connection.prepareStatement(sql);
     
            preparedStatement.setInt(1, day);
            preparedStatement.setString(2, month);
            preparedStatement.setString(3, title);
            preparedStatement.setString(4, scriptshort);
            preparedStatement.setString(5, scriptfull);
            preparedStatement.setInt(6, id);
            preparedStatement.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
          public boolean UpdateBlogImg(int id, int day, String month, String title, String scriptshort, String scriptfull, String image) {
        try {
            String sql = "update Blog set Day = ?, Month = ?, Title = ?, ScriptShort = ?, ScriptFull = ?, Image = ? where BlogID = ? ;";
            connection = ContactDB.makeConnection();
            preparedStatement = connection.prepareStatement(sql);
     
            preparedStatement.setInt(1, day);
            preparedStatement.setString(2, month);
            preparedStatement.setString(3, title);
            preparedStatement.setString(4, scriptshort);
            preparedStatement.setString(5, scriptfull);
            preparedStatement.setString(6, image);
            preparedStatement.setInt(7, id);
            preparedStatement.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean UpdateDoctorImg(int id, String name, String email, String password, String degree, int experience, int speciality_id, String phone, String dob, boolean gender, String address, String img) {
        try {
            String sql = "update doctors set name = ?, email = ?, password = ?, degree = ?, experience = ?, speciality_id = ?, phone = ?, dob = ?, gender = ?, address = ?,image = ?  where id = ? ;";
            connection = ContactDB.makeConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, degree);
            preparedStatement.setInt(5, experience);
            preparedStatement.setInt(6, speciality_id);
            preparedStatement.setString(7, phone);
            preparedStatement.setString(8, dob);
            preparedStatement.setBoolean(9, gender);
            preparedStatement.setString(10, address);
            preparedStatement.setString(11, img);
            preparedStatement.setInt(12, id);
            preparedStatement.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        BlogDao a = new BlogDao();
       a.deleteBlog(1);

    }
}
