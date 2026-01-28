import java.util.Scanner;

public class hexColorCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter color code: ");
        String licenseNumber = sc.next();
        String regex = "^#[A-Za-z0-9]{6}$";
        if (licenseNumber.matches(regex)) {
            System.out.println("Valid color code");
        } else {
            System.out.println("Invalid color code");
        }
        sc.close();
    }
}
