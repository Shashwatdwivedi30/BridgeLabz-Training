import java.util.Scanner;

public class Substring {
    public static String createUsingCharAt(String str, int start, int end) {
        StringBuilder result = new StringBuilder();
        for (int i = start; i < end && i < str.length(); i++) {
            result.append(str.charAt(i));
        }
        return result.toString();
    }
    
    // Method to compare two strings using charAt()
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();       
        System.out.print("Enter start index: ");
        int startIndex = sc.nextInt();        
        System.out.print("Enter end index: ");
        int endIndex = sc.nextInt();
        
        // Create substring using charAt() method
        String subStringCharAt = createUsingCharAt(text, startIndex, endIndex);       
        // Create substring using built-in substring() method
        String subStringBuiltIn = text.substring(startIndex, endIndex);

        System.out.println("Substring using charAt(): " + subStringCharAt);
        System.out.println("Substring using built-in substring(): " + subStringBuiltIn);
        
        // Compare two substrings
        boolean areEqual = compareStrings(subStringCharAt, subStringBuiltIn);
        System.out.println("Are both substrings equal? " + areEqual);
        sc.close();
    }
}