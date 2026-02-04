import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SearchEmployee {
    public static void main(String[] args) {

        String file = "employees.csv";
        String searchName = "Amit"; 

        String line;
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (data[1].equalsIgnoreCase(searchName)) {
                    found = true;
                    System.out.println("Employee Found:\n");
                    System.out.println("Name       : " + data[1]);
                    System.out.println("Department : " + data[2]);
                    System.out.println("Salary     : " + data[3]);
                    break;
                }
            }

            if (!found) {
                System.out.println("Employee \"" + searchName + "\" not found.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}