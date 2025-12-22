import java.util.Scanner;

public class UniqueCharacters {

    // Method to find the length of the string without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Reached the end of string
        }
        return count;
    }

    // Method to find unique characters in a string
    public static char[] findUniqueChars(String str) {
        int len = findLength(str);
        char[] uniqueTemp = new char[len]; // temporary array to store unique characters
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;

            // Check if current character has already appeared
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }

            // If unique, add to temporary array
            if (isUnique) {
                uniqueTemp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Create array of exact size to store unique characters
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = uniqueTemp[i];
        }
        return uniqueChars;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        char[] uniqueChars = findUniqueChars(input);
        System.out.print("Unique characters are: ");
        for (char c : uniqueChars) {
            System.out.print(c + " ");
        }
    }
}
