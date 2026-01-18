import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleToFile {

    public static void main(String[] args) {

        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter("output.txt");

            System.out.println("Enter text or (type 'exit' to stop):");

            String input;

            while (true) {
                input = br.readLine();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                fw.write(input);
                fw.write(System.lineSeparator());
            }

            fw.close();
            br.close();
            isr.close();

            System.out.println("Data written to file successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}