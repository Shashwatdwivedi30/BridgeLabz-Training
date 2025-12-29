import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    // Method to generate a guess between min and max
    public static int generateGuess(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    // Method to get feedback from user
    public static String getFeedback() {
        System.out.print("Is the guess High, Low, or Correct? (H/L/C): ");
        return sc.next().toUpperCase();
    }

    // Method to adjust range based on feedback
    public static void updateRange(String feedback, int guess, int[] range) {
        if (feedback.equals("H")) {
            range[1] = guess - 1; // decrease max
        } else if (feedback.equals("L")) {
            range[0] = guess + 1; // increase min
        }
    }

    public static void main(String[] args) {
        int min = 1;
        int max = 100;
        int guess;
        String feedback;
        System.out.println("Think of a number between 1 and 100.");
        System.out.println("I will try to guess it!");

        while (true) {
            guess = generateGuess(min, max);
            System.out.println("My guess is: " + guess);
            feedback = getFeedback();
            if (feedback.equals("C")) {
                System.out.println("Yay! I guessed your number correctly 🎉");
                break;
            }

            int[] range = {min, max};
            updateRange(feedback, guess, range);
            min = range[0];
            max = range[1];
        }
        sc.close();
    }
}