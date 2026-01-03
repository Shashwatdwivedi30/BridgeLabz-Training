import java.util.Scanner;
public class textAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine();

        // Empty or only spaces
        if (paragraph == null || paragraph.trim().isEmpty()) {
            System.out.println("Paragraph is empty or contains only spaces.");
            sc.close();
            return;
        }

        // Split words (handles multiple spaces)
        String[] words = paragraph.trim().split("\\s+");

        // Word count
        int wordCount = words.length;

        // Longest word
        String longestWord = "";
        for (String word : words) {
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            if (cleanWord.length() > longestWord.length()) {
                longestWord = cleanWord;
            }
        }

        // Replace word 
        System.out.println("Enter word to replace:");
        String oldWord = sc.nextLine();

        System.out.println("Enter new word:");
        String newWord = sc.nextLine();

        String replacedParagraph = paragraph.replaceAll(
                "(?i)\\b" + oldWord + "\\b", newWord);

        // Output results
        System.out.println("\n--- Analysis Result ---");
        System.out.println("Word Count: " + wordCount);
        System.out.println("Longest Word: " + longestWord);
        System.out.println("Updated Paragraph:");
        System.out.println(replacedParagraph);
        sc.close();
    }
}
