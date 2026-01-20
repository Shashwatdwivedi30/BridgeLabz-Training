import java.io.*;
public class BufferedFileReading {

    public static void main(String[] args) throws IOException {

        String filePath = "largefile.txt";
        char[] buffer = new char[8192];

        long startFR = System.currentTimeMillis();
        BufferedReader br1 = new BufferedReader(new FileReader(filePath));
        while (br1.read(buffer) != -1) {}
        br1.close();
        long endFR = System.currentTimeMillis();

        long startISR = System.currentTimeMillis();
        BufferedReader br2 = new BufferedReader(
                new InputStreamReader(new FileInputStream(filePath))
        );
        while (br2.read(buffer) != -1) {}
        br2.close();
        long endISR = System.currentTimeMillis();

        System.out.println("Buffered FileReader Time: " + (endFR - startFR) + " ms");
        System.out.println("Buffered InputStreamReader Time: " + (endISR - startISR) + " ms");
    }
}