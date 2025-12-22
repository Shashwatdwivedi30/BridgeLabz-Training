import java.util.Scanner;

public class SplitTextCompare {

    // Method to find length without using length()
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

    // Method to split text into words without using split()
    public static String[] splitText(String text) {
        int len = findLength(text);

        //Count number of words
        int wordCount = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                wordCount++;
            }
        }

        //Store space indexes
        int[] spaceIndexes = new int[wordCount + 1];
        int index = 0;
        spaceIndexes[index++] = -1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceIndexes[index++] = i;
            }
        }
        spaceIndexes[index] = len;

        // Extract words using indexes
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word = word + text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    // Method to compare two String arrays
    public static boolean compareArrays(String[] a1, String[] a2) {
        if (a1.length != a2.length) {
            return false;
        }
        for (int i = 0; i < a1.length; i++) {
            if (!a1[i].equals(a2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text:");
        String text = sc.nextLine();
        // User-defined split
        String[] manualSplit = splitText(text);

        // Built-in split
        String[] builtinSplit = text.split(" ");

        // Compare results
        boolean result = compareArrays(manualSplit, builtinSplit);
        System.out.println("Words using user-defined method:");
        for (String w : manualSplit) {
            System.out.println(w);
        }
        System.out.println("\nAre both results same? " + result);

        sc.close();
    }
}