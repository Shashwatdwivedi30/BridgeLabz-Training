import java.io.*;
import java.util.*;

public class DuplicateFinder {
    public static void main(String[] args) {
        String file = "students.csv";
        String line;
        Set<String> seen = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                if (!seen.add(id)) {
                    duplicates.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Duplicate Records:\n");
        for (String d : duplicates) {
            System.out.println(d);
        }
    }
}