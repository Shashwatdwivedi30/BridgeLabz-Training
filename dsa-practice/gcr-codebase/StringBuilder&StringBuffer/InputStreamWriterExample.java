import java.io.*;

public class InputStreamWriterExample {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter("output.txt");

            String input;

            System.out.println("Enter text (type 'exit' to stop):");

            while (true) {
                input = br.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(input + "\n");
            }

            fw.close();
            System.out.println("Data saved to output.txt");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}