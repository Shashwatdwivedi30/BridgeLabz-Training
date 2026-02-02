import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) {
        String file = "users.csv";
        String line;
        Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
        Pattern phonePattern = Pattern.compile("^\\d{10}$");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); 

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                String email = data[2];
                String phone = data[3];
                boolean validEmail = emailPattern.matcher(email).matches();
                boolean validPhone = phonePattern.matcher(phone).matches();

                if (!validEmail || !validPhone) {
                    System.out.println("Invalid Row: " + line);

                    if (!validEmail)
                        System.out.println(" → Invalid Email Format");
                    if (!validPhone)
                        System.out.println(" → Phone must be 10 digits");
                    System.out.println();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}