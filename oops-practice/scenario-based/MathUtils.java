import java.util.Scanner;

public class MathUtils {

    // 1. Factorial
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial not defined for negative numbers");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // 2. Prime Check
    public static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 3. GCD
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 4. Nth Fibonacci
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Fibonacci not defined for negative numbers");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // Main method - user input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Factorial input
            System.out.print("Enter a number for factorial: ");
            int factNum = sc.nextInt();
            System.out.println("Factorial: " + factorial(factNum));

            // Prime input
            System.out.print("\nEnter a number to check prime: ");
            int primeNum = sc.nextInt();
            System.out.println("Is Prime: " + isPrime(primeNum));

            // GCD input
            System.out.print("\nEnter first number for GCD: ");
            int a = sc.nextInt();
            System.out.print("Enter second number for GCD: ");
            int b = sc.nextInt();
            System.out.println("GCD: " + gcd(a, b));

            // Fibonacci input
            System.out.print("\nEnter n for Fibonacci: ");
            int fibNum = sc.nextInt();
            System.out.println("Fibonacci number: " + fibonacci(fibNum));

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}