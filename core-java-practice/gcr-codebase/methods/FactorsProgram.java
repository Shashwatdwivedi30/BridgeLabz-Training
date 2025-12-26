import java.util.Scanner;

public class FactorsProgram {
    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                count++;
            }
        }
        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    public static int findGreatestFactor(int[] factors) {
        int greatest = factors[0];
        for (int i = 1; i < factors.length; i++) {
            if (factors[i] > greatest) {
                greatest = factors[i];
            }
        }
        return greatest;
    }

    public static int findSumOfFactors(int[] factors) {
        int sum = 0;
        for (int i = 0; i < factors.length; i++) {
            sum += factors[i];
        }
        return sum;
    }

    public static long findProductOfFactors(int[] factors) {
        long product = 1;
        for (int i = 0; i < factors.length; i++) {
            product *= factors[i];
        }
        return product;
    }

    public static double findProductOfCubeOfFactors(int[] factors) {
        double product = 1;
        for (int i = 0; i < factors.length; i++) {
            product *= Math.pow(factors[i], 3);
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int[] factors = findFactors(number);

        System.out.print("Factors of the number: ");
        for (int i = 0; i < factors.length; i++) {
            System.out.print(factors[i] + " ");
        }

        System.out.println("\nGreatest Factor: " + findGreatestFactor(factors));
        System.out.println("Sum of Factors: " + findSumOfFactors(factors));
        System.out.println("Product of Factors: " + findProductOfFactors(factors));
        System.out.println("Product of Cube of Factors: " + findProductOfCubeOfFactors(factors));
        sc.close();
    }
}