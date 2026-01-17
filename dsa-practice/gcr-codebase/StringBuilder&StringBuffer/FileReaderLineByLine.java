import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderLineByLine {

    public static void main(String[] args) {

        try {
            FileReader fileReader = new FileReader("example.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}