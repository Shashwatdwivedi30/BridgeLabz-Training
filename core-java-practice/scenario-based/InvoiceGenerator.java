import java.util.Scanner;

public class InvoiceGenerator {
    static String[] parseInvoice(String input) {
        return input.split(",");
    }

    static int getTotalAmount(String[] tasks) {
        int total = 0;

        for (String task : tasks) {
            // Task Name - Amount INR
            String[] parts = task.split("-");

            // Extract numeric value from amount
            String amountStr = parts[1].replaceAll("[^0-9]", "");
            int amount = Integer.parseInt(amountStr);

            total += amount;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter invoice details:");
        System.out.println("Example: Logo Design - 3000 INR, Web Page - 4500 INR");
        
        String input = sc.nextLine(); 
        String[] tasks = parseInvoice(input);

        System.out.println("\nInvoice Items:");
        for (String task : tasks) {
            System.out.println(task.trim());
        }

        int totalAmount = getTotalAmount(tasks);
        System.out.println("\nTotal Invoice Amount: " + totalAmount + " INR");

        sc.close();
    }
}
