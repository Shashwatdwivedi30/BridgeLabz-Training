import java.io.*;
import org.json.*;

public class CSVToJSON {
    public static void main(String[] args) {

        String csvFile = "students.csv";
        String jsonFile = "students.json";

        JSONArray arr = new JSONArray();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");

                JSONObject obj = new JSONObject();
                obj.put("id", Integer.parseInt(d[0]));
                obj.put("name", d[1]);
                obj.put("age", Integer.parseInt(d[2]));

                arr.put(obj);
            }

            FileWriter writer = new FileWriter(jsonFile);
            writer.write(arr.toString(4));
            writer.close();

            System.out.println("Converted CSV to JSON.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}