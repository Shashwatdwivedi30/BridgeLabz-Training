import java.util.Scanner;

public class Largest2ndLargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = sc.nextInt();
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0;
        while (number != 0 && index < maxDigit) {
            digits[index] = number % 10;  // get last digit
            number = number / 10;         // remove last digit
            index++;
        }

        // Step 4: Initialize largest and second largest
        int largest = 0;
        int secondLargest = 0;

        // Step 5: Find largest and second largest digit
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Step 6: Display results
        System.out.println("Largest digit: " + largest);
        System.out.println("Second largest digit: " + secondLargest);
        sc.close();
    }
}
