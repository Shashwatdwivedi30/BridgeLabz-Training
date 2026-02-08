import java.util.*;

public class FinallyBlockExecution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number 1: ");
            int a = sc.nextInt();

            System.out.print("Enter number 2: ");
            int b = sc.nextInt();

            System.out.println("Result: " + (a / b));

        } catch (ArithmeticException e) {
            System.out.println("Division by zero not allowed!");
        } finally {
            System.out.println("Operation completed");
        }
    }
}