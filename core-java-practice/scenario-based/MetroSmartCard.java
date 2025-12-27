import java.util.Scanner;
public class MetroSmartCard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial Smart Card balance: ");
        double balance = sc.nextDouble();
        char choice = 'y';
        while (balance > 0 && choice == 'y') {
            System.out.print("Enter distance travelled (in km): ");
            int distance = sc.nextInt();

            int fare = (distance <= 5) ? 10 :
                       (distance <= 15) ? 20 : 30;

            if (balance >= fare) {
                balance -= fare;
                System.out.println("Fare charged: " + fare);
                System.out.println("Remaining balance: " + balance);
            } else {
                System.out.println("Insufficient balance!");
                break;
            }
            System.out.print("Do you want to travel again? (y/n): ");
            choice = sc.next().charAt(0);
        }
        System.out.println("Thank you for using Delhi Metro 🚇");
        System.out.println("Final balance: " + balance);
        sc.close();
    }
}