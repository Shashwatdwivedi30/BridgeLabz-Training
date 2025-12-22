import java.util.Scanner;

public class StringLengthWithoutLength {

    // Find length without using length()
    public static int findLength(String text) {
        int count = 0;
        try {
            // Infinite loop to count characters
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // Exception occurs when index exceeds string length
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.next();
        int manualLength = findLength(input);      // User-defined method
        int builtinLength = input.length();       // Built-in method

        System.out.println("Length without using length() : " + manualLength);
        System.out.println("Length using built-in method  : " + builtinLength);
        sc.close();
    }
}
