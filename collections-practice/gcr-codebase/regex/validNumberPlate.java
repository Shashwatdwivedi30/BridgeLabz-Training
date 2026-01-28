import java.util.Scanner;

public class validNumberPlate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter License Number: ");
        String licenseNumber = sc.next();
        String regex = "^[A-Z]{2}[0-9]{4}$";
        if (licenseNumber.matches(regex)) {
            System.out.println("Valid License Number Plate");
        } else {
            System.out.println("Invalid License NUmber Plate");
        }
        sc.close();
    }
}
