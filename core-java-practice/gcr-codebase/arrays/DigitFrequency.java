import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = sc.nextInt();
        int temp = number;
        int count = 0;

        //Count of digits
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }

        //Store digits in array
        int[] digits = new int[count];
        int index = 0;
        while (number != 0) {
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

        //Frequency array of size 10
        int[] freq = new int[10];

        //Frequency of each digit
        for (int i = 0; i < digits.length; i++) {
            freq[digits[i]]++;
        }

        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " occurs " + freq[i] + " time(s)");
            }
        }
        sc.close();
    }
}