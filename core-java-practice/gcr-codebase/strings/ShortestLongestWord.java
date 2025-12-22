import java.util.Scanner;

public class ShortestLongestWord {

    // Find string length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    // Split text into words without using split()
    public static String[] splitText(String text) {
        int len = findLength(text);
        // Count words
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        // Store space indexes
        int[] spaceIndex = new int[wordCount + 1];
        int k = 0;
        spaceIndex[k++] = -1;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndex[k++] = i;
            }
        }
        spaceIndex[k] = len;

        // Extract words
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndex[i] + 1; j < spaceIndex[i + 1]; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    // Method to create 2D array of word and its length
    public static String[][] createWordLengthArray(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }
        return result;
    }

    // Method to find shortest and longest word indexes
    public static int[] findShortestAndLongest(String[][] wordLength) {
        int minIndex = 0;
        int maxIndex = 0;
        int minLength = Integer.parseInt(wordLength[0][1]);
        int maxLength = Integer.parseInt(wordLength[0][1]);

        for (int i = 1; i < wordLength.length; i++) {
            int length = Integer.parseInt(wordLength[i][1]);
            if (length < minLength) {
                minLength = length;
                minIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                maxIndex = i;
            }
        }
        return new int[] { minIndex, maxIndex };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = sc.nextLine();

        // User-defined method calls
        String[] words = splitText(text);
        String[][] wordLength = createWordLengthArray(words);
        int[] result = findShortestAndLongest(wordLength);

        // Display result
        System.out.println("\nShortest Word : " + wordLength[result[0]][0]);
        System.out.println("Length : " + wordLength[result[0]][1]);

        System.out.println("\nLongest Word  : " + wordLength[result[1]][0]);
        System.out.println("Length : " + wordLength[result[1]][1]);

        sc.close();
    }
}