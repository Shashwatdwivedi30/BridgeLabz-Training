import java.io.FileWriter;
import java.io.IOException;

public class WriteCSV {
    public static void main(String[] args) {

        String file = "employees.csv";

        try (FileWriter writer = new FileWriter(file)) {

            writer.append("ID,Name,Department,Salary\n");

            writer.append("201,Prince,IT,50000\n");
            writer.append("202,Vivek,HR,45000\n");
            writer.append("203,Shahswat,Finance,60000\n");
            writer.append("204,Priya,Marketing,52000\n");
            writer.append("205,Shyam,Operations,48000\n");

            System.out.println("CSV file created & data written successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}