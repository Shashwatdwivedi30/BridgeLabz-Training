import java.util.Scanner;
public class MovieTicketBooking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of customers");
        int noOfCustomers = sc.nextInt();
        for (int customer = 1; customer <= noOfCustomers; customer++) {
            System.out.println("\nCustomer " + customer);
            System.out.print("Enter movie type (Action/Comedy): ");
            String movieType = sc.next();
            System.out.print("Enter seat type (Gold/Silver): ");
            String seatType = sc.next();
            System.out.print("Do you want snacks? (yes/no): ");
            String snacks = sc.next();
            int price = 0;
            switch (seatType.toLowerCase()) {
                case "gold":
                    price = 300;
                    break;
                case "silver":
                    price = 200;
                    break;
                default:
                    System.out.println("Invalid seat type");
            }
            if (snacks.equalsIgnoreCase("yes")) {
                price += 100;
            }
            System.out.println("Movie Type: " + movieType);
            System.out.println("Total Ticket Price: " + price);
        }
        sc.close();
    }
}