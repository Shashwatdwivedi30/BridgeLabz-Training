import java.util.Scanner;

public class LowercaseCompare {
    // Method to convert text to lowercase using ASCII logic
    public static String convertToLowercase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32); // Convert to lowercase
            }
            result = result + ch;
        }
        return result;
    }

    // Compare two strings using charAt()
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
        System.out.println("Enter the text:");
        String text = sc.nextLine();

        // User-defined lowercase conversion
        String manualLowercase = convertToLowercase(text);

        // Built-in lowercase conversion
        String builtinLowercase = text.toLowerCase();

        // Compare both strings
        boolean isSame = compareStrings(manualLowercase, builtinLowercase);

        System.out.println("Manual Lowercase   : " + manualLowercase);
        System.out.println("Built-in Lowercase : " + builtinLowercase);
        System.out.println("Are both equal? : " + isSame);
        sc.close();
    }
}
