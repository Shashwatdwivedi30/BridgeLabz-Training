import java.util.Scanner;

public class PalindromeCheck {

    // Logic 1: Iterative method to check palindrome
    public static boolean isPalindromeIterative(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method to check palindrome
    public static boolean isPalindromeRecursive(String str, int start, int end) {
        if (start >= end) {
            return true; // Base case: crossed indices
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false; // Characters do not match
        }
        return isPalindromeRecursive(str, start + 1, end - 1);
    }

    // Logic 3: Using character arrays
    public static boolean isPalindromeCharArray(String str) {
        int len = str.length();
        char[] original = str.toCharArray();
        char[] reversed = new char[len];
        // Reverse the string using charAt()
        for (int i = 0; i < len; i++) {
            reversed[i] = str.charAt(len - 1 - i);
        }
        // Compare original and reversed arrays
        for (int i = 0; i < len; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a text:");
        String text = sc.nextLine();
        // Check palindrome using all three methods
        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text, 0, text.length() - 1);
        boolean charArrayResult = isPalindromeCharArray(text);

        System.out.println("\nPalindrome Check Results:");
        System.out.println("1. Iterative method: " + (iterativeResult ? "Palindrome" : "Not Palindrome"));
        System.out.println("2. Recursive method: " + (recursiveResult ? "Palindrome" : "Not Palindrome"));
        System.out.println("3. Character Array method: " + (charArrayResult ? "Palindrome" : "Not Palindrome"));
    }
}