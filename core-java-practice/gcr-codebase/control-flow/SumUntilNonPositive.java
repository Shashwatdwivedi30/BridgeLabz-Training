import java.util.Scanner;

public class SumUntilNonPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double total = 0.0;
        while (true) {
            System.out.print("Enter a number ");
            double number = sc.nextDouble();
            if (number <= 0) {
                break; // Exit the loop if number is 0 or negative
            }
            total += number;
        }
        System.out.println("Total sum is " + total);
    }
}
