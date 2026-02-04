import java.io.*;
import java.sql.*;

public class DBToCSV {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3000";
        String user = "root";
        String pass = "root";
        String output = "employee_report.csv";

        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, name, department, salary FROM employees");
             FileWriter writer = new FileWriter(output)) {

            writer.append("Employee ID,Name,Department,Salary\n");

            while (rs.next()) {
                writer.append(rs.getInt(1) + ",")
                      .append(rs.getString(2) + ",")
                      .append(rs.getString(3) + ",")
                      .append(rs.getDouble(4) + "\n");
            }
            System.out.println("CSV Report Generated: " + output);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}