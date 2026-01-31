import java.util.Scanner;

public class FlipKey {

    public static String CleanseAndInvert(String input) {

        if (input == null || input.length() < 6) {
            return "";
        }

        for (char c : input.toCharArray()) {
            if (!Character.isLetter(c)) {
                return "";
            }
        }

        input = input.toLowerCase();
        StringBuilder filtered = new StringBuilder();
        for (char c : input.toCharArray()) {
            if ((int) c % 2 != 0) { 
                filtered.append(c);
            }
        }

        filtered.reverse();

        for (int i = 0; i < filtered.length(); i++) {
            if (i % 2 == 0) {  
                char upper = Character.toUpperCase(filtered.charAt(i));
                filtered.setCharAt(i, upper);
            }
        }

        return filtered.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the word");

        String input = sc.nextLine();
        String key = CleanseAndInvert(input);

        if (key.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + key);
        }

        sc.close();
    }
}