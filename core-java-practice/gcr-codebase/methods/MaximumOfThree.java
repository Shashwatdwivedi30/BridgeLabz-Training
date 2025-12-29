import java.util.Scanner;
public class MaximumOfThree {
    public static int takeInput(Scanner sc, String msg) {
        System.out.print(msg);
        return sc.nextInt();
    }

    public static int findMaximum(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = takeInput(sc, "Enter first number: ");
        int num2 = takeInput(sc, "Enter second number: ");
        int num3 = takeInput(sc, "Enter third number: ");
        int max = findMaximum(num1, num2, num3);
        System.out.println("Maximum of three numbers is: " + max);
        sc.close();
    }
}