import java.util.Scanner;

public class FactorialForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number < 0) {
            System.out.println("Factorial is not defined for negative numbers.");
        } else {
            long factorial = 1; 
            for (int i = 1; i <= number; i++) {
                factorial *= i;
            }
            System.out.println("The factorial of "+number+" is: "+factorial);
        }
    }
}