import java.util.Scanner;

public class SumOfNaturalNoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n < 1) {
            System.out.println("The number "+n+" is not a natural number.");
        } else {
            int sumWhile = 0;
            int i = 1;
            while (i <= n) {
                sumWhile += i;
                i++;
            }
            int sumFormula = n * (n + 1) / 2;
            System.out.println("Sum using while loop: "+sumWhile);
            System.out.println("Sum using formula: "+sumFormula);
            if (sumWhile == sumFormula) {
                System.out.println("Both computations are correct");
            } else {
                System.out.println("Computations are incorrect");
            }
        }
    }
}