package DAO;

import Model.Account;
import Model.Bacsi;

import Model.Camnang;
import Model.Chuyenkhoa;
import contact.ContactDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class dao {

    private final ArrayList<Bacsi> result = new ArrayList<>();
    private final ArrayList<Chuyenkhoa> resultc = new ArrayList<>();
    private final ArrayList<Camnang> resultcn = new ArrayList<>();
    private final ArrayList<Account> resultac = new ArrayList<>();

    Connection con = null;
    PreparedStatement p1 = null;
    ResultSet re = null;

    public ArrayList<Bacsi> getTop3() throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "select * from Doctor "
                    + "where Experience = 10;";

            p1 = con.prepareStatement(stm1);

            re = p1.executeQuery();
            while (re.next()) {
                result.add(new Bacsi(re.getInt(1), re.getString(2), re.getString(3), re.getInt(4),
                        re.getInt(5), re.getString(6), re.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return result;
    }

    public ArrayList<Bacsi> getAll() throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "select * from Doctor";

            p1 = con.prepareStatement(stm1);

            re = p1.executeQuery();
            while (re.next()) {
                result.add(new Bacsi(re.getInt(1), re.getString(2), re.getString(3), re.getInt(4),
                        re.getInt(5), re.getString(6), re.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return result;
    }

    public ArrayList<Bacsi> search(String txtSearch) throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "SELECT * FROM Doctor WHERE DoctorID LIKE ? OR Degree LIKE ? OR Specialization LIKE ?";

            p1 = con.prepareStatement(stm1);
            p1.setString(1, "%" + txtSearch + "%");
            p1.setString(2, "%" + txtSearch + "%");
            p1.setString(3, "%" + txtSearch + "%");
            re = p1.executeQuery();
            while (re.next()) {
                result.add(new Bacsi(re.getInt(1), re.getString(2), re.getString(3), re.getInt(4),
                        re.getInt(5), re.getString(6), re.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return result;
    }

    public ArrayList<Chuyenkhoa> getSpecialty() throws ClassNotFoundException {
        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "select *from Specialty;";

            p1 = con.prepareStatement(stm1);

            re = p1.executeQuery();
            while (re.next()) {
                resultc.add(new Chuyenkhoa(re.getInt(1), re.getString(2)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return resultc;

    }

    public ArrayList<Bacsi> getDoctorbySpecialtyID(String cid) throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "select * from Doctor\n"
                    + "where SpecialtyID = ?";

            p1 = con.prepareStatement(stm1);
            p1.setString(1, cid);
            re = p1.executeQuery();
            while (re.next()) {
                result.add(new Bacsi(re.getInt(1), re.getString(2), re.getString(3), re.getInt(4),
                        re.getInt(5), re.getString(6), re.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return result;
    }

    public ArrayList<Bacsi> getDoctorbyID(int accountID) throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "select * from Doctor\n"
                    + "where ID = ?";

            p1 = con.prepareStatement(stm1);
            p1.setInt(1, accountID);
            re = p1.executeQuery();
            while (re.next()) {
                result.add(new Bacsi(re.getInt(1), re.getString(2), re.getString(3), re.getInt(4),
                        re.getInt(5), re.getString(6), re.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return result;
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

    public Camnang getBlogByID(String bid) throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "SELECT * FROM Blog where BlogID = ?";

            p1 = con.prepareStatement(stm1);
            p1.setString(1, bid);
            re = p1.executeQuery();
            while (re.next()) {
                return new Camnang(re.getInt(1), re.getInt(2), re.getString(3), re.getString(4), re.getString(5),
                        re.getString(6), re.getString(7));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return null;
    }

    public ArrayList<Camnang> getAllBlog() throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "select * from Blog;";

            p1 = con.prepareStatement(stm1);
            re = p1.executeQuery();
            while (re.next()) {
                resultcn.add(new Camnang(re.getInt(1), re.getInt(2), re.getString(3), re.getString(4), re.getString(5),
                        re.getString(6), re.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return resultcn;
    }

    public ArrayList<Camnang> searchBlog(String txtSearch) throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "SELECT * FROM Blog WHERE [Day] LIKE ? OR [Month] LIKE ? OR Title LIKE ? OR ScriptShort LIKE ?";

            p1 = con.prepareStatement(stm1);
            p1.setString(1, "%" + txtSearch + "%");
            p1.setString(2, "%" + txtSearch + "%");
            p1.setString(3, "%" + txtSearch + "%");
            p1.setString(4, "%" + txtSearch + "%");
            re = p1.executeQuery();
            while (re.next()) {
                resultcn.add(new Camnang(re.getInt(1), re.getInt(2), re.getString(3), re.getString(4), re.getString(5),
                        re.getString(6), re.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return resultcn;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        dao DAO = new dao();
        Camnang a = DAO.getBlogByID("1");
        System.out.println(a);
    }

 public String getInfoDoctor(String accountId) throws ClassNotFoundException {
    String result = "";
    Connection con = null;
    Statement statement = null;

    try {
        con = ContactDB.makeConnection();
        statement = con.createStatement();

        String sql = "SELECT Doctor.Image, Doctor.DoctorName, Doctor.Degree, Doctor.Experience, Doctor.Specialization, accounts.DOB, accounts.phoneNumber " +
                "FROM accounts " +
                "JOIN Doctor ON Doctor.DoctorID = accounts.id " +
                "WHERE accounts.isDoctor = 1 AND accounts.id = " + accountId;

        ResultSet resultSet = statement.executeQuery(sql);

        if (resultSet.next()) {
            String image = resultSet.getString("Image");
            String doctorName = resultSet.getString("DoctorName");
            String degree = resultSet.getString("Degree");
            int experience = resultSet.getInt("Experience");
            String specialization = resultSet.getString("Specialization");
            Date dob = resultSet.getDate("DOB");
            String phoneNumber = resultSet.getString("phoneNumber");

            // Do something with the retrieved data
            result += "Image: " + image + "\n";
            result += "Doctor Name: " + doctorName + "\n";
            result += "Degree: " + degree + "\n";
            result += "Experience: " + experience + "\n";
            result += "Specialization: " + specialization + "\n";
            result += "DOB: " + dob + "\n";
            result += "Phone Number: " + phoneNumber + "\n";
            result += "----------------------------------\n";
        }

    } catch (SQLException e) {
        System.out.println("Error: " + e);
    }
    return result;
  }
}
