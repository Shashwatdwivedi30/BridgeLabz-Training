import java.util.Scanner;

public class FrequencyNestedLoops {
    // Method to find frequency of characters using nested loops
    public static String[][] findCharFrequency(String str) {
        // Convert string to character array
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] freq = new int[len]; // Array to store frequency of each character

        // Initialize frequency array
        for (int i = 0; i < len; i++) {
            freq[i] = 1;
        }
        // Nested loop to count frequency
        for (int i = 0; i < len; i++) {
            if (chars[i] == '0') { // Already counted duplicate
                continue;
            }
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0'; // Mark duplicate character as counted
                }
            }
        }
        // Count how many unique characters are present
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                uniqueCount++;
            }
        }
        // Create 2D String array to store characters and their frequencies
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index][0] = Character.toString(chars[i]);
                result[index][1] = Integer.toString(freq[i]);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        String[][] frequencies = findCharFrequency(input);
        System.out.println("Character | Frequency");
        System.out.println("--------------------");
        for (String[] row : frequencies) {
            System.out.println("    " + row[0] + "     |    " + row[1]);
        }
    }
}