import java.util.Scanner;
class Vehicle {
    // Instance variables
    String ownerName;
    String vehicleType;

    // Class variable
    static double registrationFee = 5000;

    // Constructor
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method
    void displayVehicleDetails() {
        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Owner Name        : " + ownerName);
        System.out.println("Vehicle Type      : " + vehicleType);
        System.out.println("Registration Fee  : " + registrationFee);
    }

    // Class method
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter new Registration Fee: ");
        double fee = sc.nextDouble();
        sc.nextLine(); 

        Vehicle.updateRegistrationFee(fee);

        System.out.print("Enter Owner Name: ");
        String owner = sc.nextLine();

        System.out.print("Enter Vehicle Type: ");
        String type = sc.nextLine();

        Vehicle v1 = new Vehicle(owner, type);
        v1.displayVehicleDetails();

        sc.close();
    }
}