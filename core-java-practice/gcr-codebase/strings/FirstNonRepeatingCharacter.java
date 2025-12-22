import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character in a string
    public static char firstNonRepeating(String str) {
        int[] freq = new int[256]; // Array to store frequency of all ASCII characters
        int length = 0;
        // Find the length of the string manually using charAt()
        try {
            while (true) {
                str.charAt(length);
                length++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        // Count frequency of each character
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            freq[ch]++;
        }
        // Find the first character with frequency 1
        for (int i = 0; i < length; i++) {
            if (freq[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        // If no non-repeating character is found, return a special character
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        char firstUnique = firstNonRepeating(input);
        if (firstUnique != '\0') {
            System.out.println("The first non-repeating character is: " + firstUnique);
        } else {
            System.out.println("No non-repeating character found in the string.");
        }
    }
}