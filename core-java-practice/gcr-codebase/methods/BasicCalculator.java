import java.util.Scanner;
public class BasicCalculator {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose operation (1-4): ");
        int choice = sc.nextInt();

        double result = 0;
        if (choice == 1) {
            result = add(num1, num2);
        } 
        else if (choice == 2) {
            result = subtract(num1, num2);
        } 
        else if (choice == 3) {
            result = multiply(num1, num2);
        } 
        else if (choice == 4) {
            if (num2 != 0) {
                result = divide(num1, num2);
            } else {
                System.out.println("Cannot divide by zero!");
                sc.close();
                return;
            }
        } 
        else {
            System.out.println("Invalid choice!");
            sc.close();
            return;
        }
        System.out.println("Result: " + result);
        sc.close();
    }
}