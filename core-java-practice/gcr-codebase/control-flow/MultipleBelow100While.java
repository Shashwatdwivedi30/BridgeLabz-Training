import java.util.Scanner;

public class MultipleBelow100While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number > 0 && number < 100) {
            int i = 100;
            while (i >= 1) {
                if (i % number == 0) {
                    System.out.println(i);
                }
                i--;
            }
        } else {
            System.out.println("Please enter a valid positive integer less than 100.");
        }

        scanner.close();
    }
}
