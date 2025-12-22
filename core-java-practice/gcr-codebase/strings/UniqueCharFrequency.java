import java.util.Scanner;

public class UniqueCharFrequency {

    // Method to find the length of the string without using length()
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // End of string reached
        }
        return count;
    }

    // Method to find unique characters in a string using charAt()
    public static char[] uniqueCharacters(String str) {
        int len = findLength(str);
        char[] uniqueTemp = new char[len];
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            char current = str.charAt(i);
            boolean isUnique = true;
            // Check if the character appeared before
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == current) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueTemp[uniqueCount] = current;
                uniqueCount++;
            }
        }

        // Copy to array of exact size
        char[] uniqueChars = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueChars[i] = uniqueTemp[i];
        }
        return uniqueChars;
    }

    // Method to find frequency of characters using unique characters
    public static String[][] charFrequency(String str) {
        int len = findLength(str);
        char[] uniqueChars = uniqueCharacters(str);
        String[][] result = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            char ch = uniqueChars[i];
            int count = 0;
            // Count frequency of current character in string
            for (int j = 0; j < len; j++) {
                if (str.charAt(j) == ch) {
                    count++;
                }
            }
            result[i][0] = Character.toString(ch);
            result[i][1] = Integer.toString(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = sc.nextLine();
        String[][] frequencies = charFrequency(input);
        System.out.println("Character | Frequency");
        System.out.println("--------------------");
        for (String[] row : frequencies) {
            System.out.println("    " + row[0] + "     |    " + row[1]);
        }
    }
}