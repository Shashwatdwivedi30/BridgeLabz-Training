import java.util.Scanner;
public class LibraryFineCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            System.out.println("\nBook " + i);
            System.out.print("Enter due date (day number): ");
            int dueDate = sc.nextInt();
            System.out.print("Enter return date (day number): ");
            int returnDate = sc.nextInt();

            if (returnDate > dueDate) {
                int lateDays = returnDate - dueDate;
                int fine = lateDays * 5;
                System.out.println("Late by " + lateDays + " days. Fine: " + fine);
            } else {
                System.out.println("Returned on time. No fine.");
            }
        }
        sc.close();
    }
}