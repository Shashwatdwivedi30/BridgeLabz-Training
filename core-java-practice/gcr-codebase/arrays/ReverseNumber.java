import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = sc.nextInt();
        int temp = number;
        int count = 0;

        // Step 2: Find count of digits
        while (temp != 0) {
            count++;
            temp = temp / 10;
        }
        int[] digits = new int[count];
        int index = 0;
        while (number != 0) {
            digits[index] = number % 10;
            number = number / 10;
            index++;
        }

        // Step 4: Reverse the digits array
        int[] reverseDigits = new int[count];
        for (int i = 0; i < count; i++) {
            reverseDigits[i] = digits[i];
        }

        // Step 5: Display reversed number
        System.out.print("Reversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reverseDigits[i]);
        }
        sc.close();
    }
}
