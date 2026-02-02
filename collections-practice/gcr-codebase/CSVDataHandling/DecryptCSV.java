import java.io.*;

public class DecryptCSV {
    public static void main(String[] args) {

        String file = "encrypted.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String email = AESUtil.decrypt(data[2]);
                String salary = AESUtil.decrypt(data[3]);
                System.out.println(data[1] + " | Email: " + email + " | Salary: " + salary);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}