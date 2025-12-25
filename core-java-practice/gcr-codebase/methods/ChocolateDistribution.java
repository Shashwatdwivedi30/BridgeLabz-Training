import java.util.Scanner;

public class ChocolateDistribution {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        int chocolatesEach = number / divisor;
        int remainingChocolates = number % divisor;
        return new int[]{chocolatesEach, remainingChocolates};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of chocolates: ");
        int noOfChocolates = sc.nextInt();
        System.out.print("Enter number of children: ");
        int noOfChildren = sc.nextInt();
        int[] result = findRemainderAndQuotient(noOfChocolates, noOfChildren);
        System.out.println("Each child will get " + result[0] + " chocolates");
        System.out.println("Remaining chocolates: " + result[1]);
        sc.close();
    }
}