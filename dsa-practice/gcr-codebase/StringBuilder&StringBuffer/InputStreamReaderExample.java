import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class InputStreamReaderExample {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("example.txt");

            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            BufferedReader br = new BufferedReader(isr);

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            isr.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}