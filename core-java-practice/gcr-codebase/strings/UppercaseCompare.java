import java.util.Scanner;

public class UppercaseCompare {
    // Method to convert text to uppercase using ASCII logic
    public static String convertToUppercase(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - 32); // Convert to uppercase
            }
            result = result + ch;
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
        System.out.println("Enter the text:");
        String text = sc.nextLine();
        String manualUppercase = convertToUppercase(text);
        String builtinUppercase = text.toUpperCase();

        // Compare both strings
        boolean isSame = compareStrings(manualUppercase, builtinUppercase);

        System.out.println("Manual Uppercase   : " + manualUppercase);
        System.out.println("Built-in Uppercase : " + builtinUppercase);
        System.out.println("Are both equal? : " + isSame);
        sc.close();
    }
}
