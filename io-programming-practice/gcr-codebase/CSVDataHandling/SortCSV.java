import java.io.*;
import java.util.*;

public class SortCSV {
    public static void main(String[] args) {
        String file = "employees.csv";
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        records.sort((a, b) -> Integer.parseInt(b[3]) - Integer.parseInt(a[3]));

        System.out.println("Top 5 Highest Paid Employees:\n");
        for (int i = 0; i < Math.min(5, records.size()); i++) {
            String[] r = records.get(i);
            System.out.println(r[1] + " - Salary: " + r[3]);
        }
    }
}