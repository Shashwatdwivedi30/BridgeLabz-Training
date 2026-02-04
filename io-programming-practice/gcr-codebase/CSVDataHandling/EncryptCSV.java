import java.io.*;

public class EncryptCSV {
    public static void main(String[] args) {
        String output = "encrypted.csv";
        try (FileWriter writer = new FileWriter(output)) {
            writer.append("ID,Name,Email,Salary\n");
            writer.append("1,Rahul," +
                    AESUtil.encrypt("rahul@gmail.com") + "," +
                    AESUtil.encrypt("50000") + "\n");

            writer.append("2,Sneha," +
                    AESUtil.encrypt("sneha@yahoo.com") + "," +
                    AESUtil.encrypt("60000") + "\n");

            System.out.println("Encrypted CSV created.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}