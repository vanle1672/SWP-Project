
package DAO;

import Model.Bacsi;
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
    
    Connection con = null;
    PreparedStatement p1 = null;
    ResultSet re = null;
      public ArrayList<Bacsi> getTop3() throws ClassNotFoundException {
//         con = null;

        try {
            this.con = ContactDB.makeConnection();

            String stm1 = "select TOP 3  * from Doctor "
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
      public static void main(String[] args) throws ClassNotFoundException {
        dao DAO = new dao();
        List<Bacsi> a = DAO.getTop3();
          System.out.println(a);
    }
}
