import java.util.Scanner;

public class NumberChecker2 {
    public static int countDigits(int number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number / 10;
        }
        return count;
    }

    public static int[] getDigitsArray(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number = number / 10;
        }
        return digits;
    }

    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    public static int sumOfSquaresOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        if (sum == 0) {
            return false;
        }
        return number % sum == 0;
    }

    public static int[][] findDigitFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        for (int i = 0; i < 10; i++) {
            frequency[i][0] = i;
            frequency[i][1] = 0;
        }

        for (int d : digits) {
            frequency[d][1]++;
        }
        return frequency;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int[] digits = getDigitsArray(number);
        System.out.println("\nCount of digits: " + countDigits(number));

        System.out.print("Digits are: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }

        System.out.println("\n\nSum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + sumOfSquaresOfDigits(digits));

        System.out.println("Harshad Number: " + isHarshadNumber(number, digits));

        int[][] freq = findDigitFrequency(digits);

        System.out.println("\nDigit  Frequency");
        for (int i = 0; i < freq.length; i++) {
            if (freq[i][1] > 0) {
                System.out.println(freq[i][0] + "      " + freq[i][1]);
            }
        }
        sc.close();
    }
}