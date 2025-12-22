import java.util.Scanner;

public class CharacterFrequency {

    // Method to find frequency of characters and return as 2D array
    public static Object[][] findCharFrequency(String str) {
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
        // Count how many unique characters are present
        int uniqueCount = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                uniqueCount++;
            }
        }
        // Create a 2D array to store characters and their frequencies
        Object[][] result = new Object[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                result[index][0] = (char) i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        Object[][] frequencies = findCharFrequency(input);

        System.out.println("Character | Frequency");
        System.out.println("--------------------");
        for (Object[] row : frequencies) {
            System.out.println("    " + row[0] + "     |    " + row[1]);
        }
    }
}