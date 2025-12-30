import java.util.Scanner;
class circle {
    double radius;

    void calculate() {
        double area = 3.1416 * radius * radius;
        double circumference = 2 * 3.1416 * radius;

        System.out.printf("Area of circle: %.4f\n", area);
        System.out.printf("Circumference of circle: %.4f\n", circumference);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        circle c = new circle();

        System.out.print("Enter radius: ");
        c.radius = sc.nextDouble();

        c.calculate();
        sc.close();
    }
}