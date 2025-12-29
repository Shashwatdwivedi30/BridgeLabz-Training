import java.time.LocalDate;
import java.util.Scanner;
public class DateArithmeticDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a date (yyyy-mm-dd): ");
        String inputDate = sc.nextLine();

        // Convert input string to LocalDate
        LocalDate date = LocalDate.parse(inputDate);
        System.out.println("Original Date: " + date);

        // Add 7 days
        date = date.plusDays(7);
        System.out.println("After adding 7 days: " + date);

        // Add 1 month
        date = date.plusMonths(1);
        System.out.println("After adding 1 month: " + date);

        // Add 2 years
        date = date.plusYears(2);
        System.out.println("After adding 2 years: " + date);

        // Subtract 3 weeks
        date = date.minusWeeks(3);
        System.out.println("After subtracting 3 weeks: " + date);
        sc.close();
    }
}
