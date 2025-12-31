import java.util.Scanner;
public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double totalCost;

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        calculateTotalCost();
    }

    // Method to calculate total cost
    void calculateTotalCost() {
        double costPerDay = 1000;
        totalCost = rentalDays * costPerDay;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("\n--- Car Rental Details ---");
        System.out.println("Customer Name : " + customerName);
        System.out.println("Car Model     : " + carModel);
        System.out.println("Rental Days   : " + rentalDays);
        System.out.println("Total Cost    : " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Car Model: ");
        String model = sc.nextLine();

        System.out.print("Enter Rental Days: ");
        int days = sc.nextInt();

        CarRental rental = new CarRental(name, model, days);
        rental.displayDetails();
        sc.close();
    }
}