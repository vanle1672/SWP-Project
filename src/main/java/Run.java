import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Run {
    /*public static List<LocalDate> getDateRange(LocalDate startDate, LocalDate endDate) {
        List<LocalDate> dateRange = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            dateRange.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return dateRange;
    }
    public static List<LocalDate> getDatesInRange(String startDateString, String endDateString) {
        LocalDate startDate = LocalDate.parse(startDateString, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate endDate = LocalDate.parse(endDateString, DateTimeFormatter.ISO_LOCAL_DATE);

        List<LocalDate> datesInRange = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            datesInRange.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }
        return datesInRange;
    }*/
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String serverName = "swpdata.database.windows.net:1433";
        String databaseName = "swpdata";
        String url = "jdbc:sqlserver://" + serverName + ";databaseName=" + databaseName + ";";
        String username = "minh";
        String password = "Matkhaulagivaytroi1";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection connection = DriverManager.getConnection(url, username, password);
        String sql = "select * from doctors; select * from patients;";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        boolean check = preparedStatement.execute();
        // doctor
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()){
            System.out.println("doctor id : " + resultSet.getInt("id") + " name : " + resultSet.getString("name"));
        }
        if (preparedStatement.getMoreResults()){
            resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                System.out.println("patient id : " + resultSet.getInt("id") + " name : " + resultSet.getString("name"));
            }
        }
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
//        Date date =new Date();
//        date = dateFormat.format(date);
//        System.out.println(date);
    }
}
