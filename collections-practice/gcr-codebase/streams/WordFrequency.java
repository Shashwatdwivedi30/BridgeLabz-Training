import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequency {

    public static void main(String[] args) {

        String fileName = "textfile.txt";
        Map<String, Integer> wordCount = new HashMap<>();

        // 🔹 Read file & count words
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] words = line
                        .toLowerCase()
                        .replaceAll("[^a-zA-Z ]", "")
                        .split("\\s+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCount.put(word,
                                wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
            return;
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(wordCount.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Top 5 most frequent words:");
        for (int i = 0; i < Math.min(5, list.size()); i++) {
            System.out.println(
                    list.get(i).getKey() + " : " + list.get(i).getValue());
        }
    }
}