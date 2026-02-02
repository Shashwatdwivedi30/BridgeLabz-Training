import java.io.*;
import org.json.*;

public class JSONToCSV {
    public static void main(String[] args) {

        String jsonFile = "students.json";
        String csvFile = "students.csv";

        try {
            String content = new String(java.nio.file.Files.readAllBytes(
                    java.nio.file.Paths.get(jsonFile)));

            JSONArray arr = new JSONArray(content);

            FileWriter writer = new FileWriter(csvFile);
            writer.append("ID,Name,Age\n");

            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);

                writer.append(obj.getInt("id") + ",")
                      .append(obj.getString("name") + ",")
                      .append(obj.getInt("age") + "\n");
            }

            writer.close();
            System.out.println("Converted JSON to CSV.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}