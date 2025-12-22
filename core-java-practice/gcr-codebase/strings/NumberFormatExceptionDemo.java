import java.util.Scanner;

public class NumberFormatExceptionDemo {

    // Generate NumberFormatException
    public static void generateException(String text) {
        // Convert non-numeric string to integer
        int num = Integer.parseInt(text);
        System.out.println("Number is: " + num);
    }
    // Handle NumberFormatException
    public static void demonstrateException(String text) {
        try {
            // Trying to convert non-numeric string to integer
            int num = Integer.parseInt(text);
            System.out.println("Number is: " + num);
        } 
        catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e);
            System.out.println("Error: Input string is not a valid number");
        } 
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a value: ");
        String input = sc.nextLine();

        // Calling method that generates exception
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught in main: " + e);
        }
        // Calling method that handles exception
        demonstrateException(input);
    }
}
