import java.util.Scanner;

public class VowelConsonantCount {

    // To check whether a character is Vowel, Consonant, or Not a Letter
    public static String checkCharacter(char ch) {
        // Convert uppercase to lowercase using ASCII logic
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        // Check if character is a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check for vowels
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }
        return "Not a Letter";
    }

    // Method to count vowels and consonants
    public static int[] countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            String result = checkCharacter(text.charAt(i));

            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[] { vowels, consonants };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String text = sc.nextLine();
        int[] count = countVowelsAndConsonants(text);
        System.out.println("\nVowels Count : " + count[0]);
        System.out.println("Consonants Count: " + count[1]);
        sc.close();
    }
}
