import java.util.Scanner;

public class PositiveNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        
        // Get user input for 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        
        // Check each number
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0) {
                if (numbers[i] % 2 == 0) {
                    System.out.println(numbers[i] + " is positive and even");
                } else {
                    System.out.println(numbers[i] + " is positive and odd");
                }
            } else if (numbers[i] < 0) {
                System.out.println(numbers[i] + " is negative");
            } else {
                System.out.println(numbers[i] + " is zero");
            }
        }
        
        // Compare first and last elements
        int first = numbers[0];
        int last = numbers[numbers.length - 1];
        
        if (first == last) {
            System.out.println("First (" + first + ") equals Last (" + last + ")");
        } else if (first > last) {
            System.out.println("First (" + first + ") is greater than Last (" + last + ")");
        } else {
            System.out.println("First (" + first + ") is less than Last (" + last + ")");
        }       
        sc.close();
    }
}