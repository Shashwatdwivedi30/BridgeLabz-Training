import java.util.Scanner;

public class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        this(1.0);   
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    public void displayRadius() {
        System.out.println("Radius: " + radius);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius of circle");
        double radius = sc.nextDouble();
        // Using default constructor
        Circle c1 = new Circle();
        c1.displayRadius();

        // Using parameterized constructor
        Circle c2 = new Circle(radius);
        c2.displayRadius();
        sc.close();
    }
}