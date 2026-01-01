import java.util.Scanner;
public class Vehicle {
    static double registrationFee = 150.0;
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }
    final String registrationNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    void displayDetails(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            System.out.println("Owner Name: " + v.ownerName);
            System.out.println("Vehicle Type: " + v.vehicleType);
            System.out.println("Registration Number: " + v.registrationNumber);
            System.out.println("Registration Fee: $" + registrationFee);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Owner Name (Vehicle 1): ");
        String owner1 = sc.nextLine();
        System.out.print("Enter Vehicle Type (Vehicle 1): ");
        String type1 = sc.nextLine();
        System.out.print("Enter Registration Number (Vehicle 1): ");
        String reg1 = sc.nextLine();
        Vehicle v1 = new Vehicle(reg1, owner1, type1);

        System.out.print("Enter Owner Name (Vehicle 2): ");
        String owner2 = sc.nextLine();
        System.out.print("Enter Vehicle Type (Vehicle 2): ");
        String type2 = sc.nextLine();
        System.out.print("Enter Registration Number (Vehicle 2): ");
        String reg2 = sc.nextLine();
        Vehicle v2 = new Vehicle(reg2, owner2, type2);

        System.out.println();
        v1.displayDetails(v1);

        System.out.println();
        v2.displayDetails(v2);

        sc.close();
    }
}