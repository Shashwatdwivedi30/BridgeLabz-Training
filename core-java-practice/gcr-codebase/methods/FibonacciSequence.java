import java.util.Scanner;
public class FibonacciSequence {
    public static void printFibonacci(int n) {
        int first = 0;
        int second = 1;
        System.out.print("Fibonacci Sequence: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int terms = sc.nextInt();
        printFibonacci(terms);
        sc.close();
    }
}