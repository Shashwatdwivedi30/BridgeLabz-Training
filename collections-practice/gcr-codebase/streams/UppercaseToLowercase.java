import java.io.*;

public class UppercaseToLowercase {

    public static void main(String[] args) {

        String sourceFile = "input.txt";
        String destinationFile = "output.txt";

        try (
            FileReader fr = new FileReader(sourceFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw = new FileWriter(destinationFile);
            BufferedWriter bw = new BufferedWriter(fw)
        ) {

            int ch;
            while ((ch = br.read()) != -1) {
                bw.write(Character.toLowerCase((char) ch));
            }

            System.out.println("File converted from uppercase to lowercase successfully!");

        } catch (IOException e) {
            System.out.println("IO Error: " + e.getMessage());
        }
    }
}