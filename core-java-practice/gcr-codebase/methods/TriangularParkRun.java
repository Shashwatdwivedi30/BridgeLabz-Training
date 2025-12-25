import java.util.Scanner;

public class TriangularParkRun {
    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3; 
        double totalDistance = 5000; // 5 km = 5000 meters
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter side 1 (in meters): ");
        double side1 = sc.nextDouble();
        System.out.print("Enter side 2 (in meters): ");
        double side2 = sc.nextDouble();
        System.out.print("Enter side 3 (in meters): ");
        double side3 = sc.nextDouble();
        double rounds = calculateRounds(side1, side2, side3);
        System.out.println("The athlete must complete " + rounds + " rounds to finish a 5 km run.");
        sc.close();
    }
}
