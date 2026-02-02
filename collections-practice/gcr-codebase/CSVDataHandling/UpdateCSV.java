import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpdateCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "employees_updated.csv";

        StringBuilder sb = new StringBuilder();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            sb.append(br.readLine()).append("\n");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String dept = data[2];
                double salary = Double.parseDouble(data[3]);

                if (dept.equalsIgnoreCase("IT")) {
                    salary = salary + (salary * 0.10);
                    data[3] = String.valueOf((int) salary);
                }
                sb.append(String.join(",", data)).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write(sb.toString());
            System.out.println("Updated CSV created: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}