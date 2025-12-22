import java.util.Scanner;

public class TrimUsingCharAt {

    // To find start and end index after trimming spaces
    public static int[] findTrimIndexes(String text) {
        int start = 0;
        int end = 0;
        // Find start index
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != ' ') {
                start = i;
                break;
            }
        }
        // Find end index
        for (int i = text.length() - 1; i >= 0; i--) {
            if (text.charAt(i) != ' ') {
                end = i;
                break;
            }
        }
        return new int[] { start, end };
    }

    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result = result + text.charAt(i);
        }
        return result;
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String text = sc.nextLine();

        // User-defined trim logic
        int[] indexes = findTrimIndexes(text);
        String manualTrim = createSubstring(text, indexes[0], indexes[1]);
        String builtinTrim = text.trim();     // Built-in trim
        boolean isSame = compareStrings(manualTrim, builtinTrim);

        System.out.println("\nAfter manual trim : \"" + manualTrim + "\"");
        System.out.println("After built-in trim: \"" + builtinTrim + "\"");
        System.out.println("Are both equal? : " + isSame);
        sc.close();
    }
}
