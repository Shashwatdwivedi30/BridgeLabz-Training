import java.util.Scanner;

public class IllegalArgumentExceptionDemo {

    // Generate IllegalArgumentException
    public static void generateException(String str) {
        // Start index is greater than end index
        System.out.println(str.substring(5, 2));
    }
    // Handle IllegalArgumentException
    public static void demonstrateException(String str) {
        try {
            System.out.println(str.substring(5, 2));
        } 
        catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e);
        } 
        catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        // Calling method that generates exception
        try {
            generateException(text);
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught in main: " + e);
        }
        // Calling method that handles exception
        demonstrateException(text);
    }
}
