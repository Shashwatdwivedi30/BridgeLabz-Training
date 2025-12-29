import java.time.LocalDate;
import java.util.Scanner;
public class DateComparisonDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter first date (yyyy-mm-dd): ");
        LocalDate date1 = LocalDate.parse(sc.nextLine());

        System.out.println("Enter second date (yyyy-mm-dd): ");
        LocalDate date2 = LocalDate.parse(sc.nextLine());

        // Compare the dates
        if (date1.isBefore(date2)) {
            System.out.println("First date is BEFORE second date.");
        } 
        else if (date1.isAfter(date2)) {
            System.out.println("First date is AFTER second date.");
        } 
        else if (date1.isEqual(date2)) {
            System.out.println("Both dates are the SAME.");
        }
        sc.close();
    }
}