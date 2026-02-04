import java.io.*;
import java.util.*;

public class MergeCSV {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String output = "students_merged.csv";

        Map<String, String[]> map1 = new HashMap<>();
        String line;

        try {
            BufferedReader br1 = new BufferedReader(new FileReader(file1));
            br1.readLine(); 
            while ((line = br1.readLine()) != null) {
                String[] data = line.split(",");
                map1.put(data[0], data); 
            }
            br1.close();

            BufferedReader br2 = new BufferedReader(new FileReader(file2));
            br2.readLine();
            StringBuilder sb = new StringBuilder();
            sb.append("ID,Name,Age,Marks,Grade\n");

            while ((line = br2.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];

                if (map1.containsKey(id)) {
                    String[] p = map1.get(id);

                    sb.append(id).append(",")
                      .append(p[1]).append(",")
                      .append(p[2]).append(",")
                      .append(data[1]).append(",")
                      .append(data[2]).append("\n");
                }
            }
            br2.close();
            FileWriter fw = new FileWriter(output);
            fw.write(sb.toString());
            fw.close();
            System.out.println("Merged CSV created: " + output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}