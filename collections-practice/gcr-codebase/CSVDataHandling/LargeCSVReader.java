import java.io.*;
import java.util.*;

public class LargeCSVReader {
    public static void main(String[] args) {
        String file = "largefile.csv";
        String line;
        int batchSize = 100;
        int totalProcessed = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<String> batch = new ArrayList<>();
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                batch.add(line);

                if (batch.size() == batchSize) {
                    totalProcessed += batch.size();
                    System.out.println("Processed: " + totalProcessed + " records");
                    batch.clear();
                }
            }

            if (!batch.isEmpty()) {
                totalProcessed += batch.size();
                System.out.println("Processed: " + totalProcessed + " records");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}