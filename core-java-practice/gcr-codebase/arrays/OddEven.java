import java.util.Scanner;

public class OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        
        // Validate natural number
        if (number <= 0) {
            System.out.println("Error: Please enter a natural number");
            System.exit(0);
        }
        
        // Create arrays for odd and even numbers
        int[] oddArray = new int[number / 2 + 1];
        int[] evenArray = new int[number / 2 + 1];
        
        // Index variables
        int oddIndex = 0;
        int evenIndex = 0;
        
        // Iterate from 1 to number
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenArray[evenIndex] = i;
                evenIndex++;
            } else {
                oddArray[oddIndex] = i;
                oddIndex++;
            }
        }
        
        // Print odd numbers
        System.out.println("Odd Numbers:");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddArray[i] + " ");
        }
        System.out.println();
        
        // Print even numbers
        System.out.println("Even Numbers:");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenArray[i] + " ");
        }
        System.out.println();        
        sc.close();
    }
}