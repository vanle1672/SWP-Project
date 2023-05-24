package DAO;

import Model.Bacsi;
import Model.Chuyenkhoa;
import contact.ContactDB;
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
public class dao {

    private final ArrayList<Bacsi> result = new ArrayList<>();
    private final ArrayList<Chuyenkhoa> resultc = new ArrayList<>();
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
                result.add(new Bacsi(re.getInt(1), re.getString(2), re.getString(3), re.getString(4), re.getInt(5), re.getInt(6),
                        re.getString(7)));
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
                result.add(new Bacsi(re.getInt(1), re.getString(2), re.getString(3), re.getString(4), re.getInt(5), re.getInt(6),
                        re.getString(7)));
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

            String stm1 = "SELECT * FROM Doctor WHERE DoctorName LIKE ? OR Degree LIKE ? OR Specialization LIKE ?";

            p1 = con.prepareStatement(stm1);
            p1.setString(1, "%" + txtSearch + "%");
            p1.setString(2, "%" + txtSearch + "%");
            p1.setString(3, "%" + txtSearch + "%");
            re = p1.executeQuery();
            while (re.next()) {
                result.add(new Bacsi(re.getInt(1), re.getString(2), re.getString(3), re.getString(4), re.getInt(5), re.getInt(6),
                        re.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return result;
    }

    
    public ArrayList<Chuyenkhoa> getSpecialty () throws ClassNotFoundException{
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
                result.add(new Bacsi(re.getInt(1), re.getString(2), re.getString(3), re.getString(4), re.getInt(5), re.getInt(6),
                        re.getString(7)));
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return result;
    }
    public static void main(String[] args) throws ClassNotFoundException {
        dao DAO = new dao();
        List<Bacsi> a = DAO.getAll();
        System.out.println(a);
    }
}
