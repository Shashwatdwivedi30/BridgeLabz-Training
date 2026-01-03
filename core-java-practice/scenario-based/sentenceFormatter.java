import java.util.Scanner;

public class sentenceFormatter {
    public static String autoCorrect(String paragraph) {

        if (paragraph == null || paragraph.trim().isEmpty()) {
            return "";
        }

        paragraph = paragraph.trim().replaceAll("\\s+", " ");

        // Ensure single space after punctuation
        paragraph = paragraph.replaceAll("\\s*([.!?])\\s*", "$1 ");

        // Capitalize first letter of each sentence
        StringBuilder result = new StringBuilder();
        boolean capitalizeNext = true;

        for (char ch : paragraph.toCharArray()) {
            if (capitalizeNext && Character.isLetter(ch)) {
                result.append(Character.toUpperCase(ch));
                capitalizeNext = false;
            } else {
                result.append(ch);
            }

            if (ch == '.' || ch == '?' || ch == '!') {
                capitalizeNext = true;
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence to be corrected");
        String input = sc.nextLine();

        String correctedText = autoCorrect(input);

        System.out.println("Original Text:");
        System.out.println(input);

        System.out.println("\nCorrected Text:");
        System.out.println(correctedText);
        sc.close();
    }
}
