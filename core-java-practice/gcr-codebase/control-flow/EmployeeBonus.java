import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double salary = sc.nextDouble();
        int year = sc.nextInt();
        double bonus = 0.0;
        if (year > 5) {
            bonus = salary * 0.05; // 5% bonus
        }
        System.out.println("The bonus amount is: "+bonus);
    }
}
