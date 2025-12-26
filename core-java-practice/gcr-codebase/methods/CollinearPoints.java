import java.util.Scanner;

public class CollinearPoints {

    public static boolean isCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {

    return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    public static boolean isCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
    double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));

    return area == 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coordinates of Point A:");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.println("Enter coordinates of Point B:");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        System.out.println("Enter coordinates of Point C:");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();

        System.out.println("Points:");
        System.out.println("A (" + x1 + ", " + y1 + ")");
        System.out.println("B (" + x2 + ", " + y2 + ")");
        System.out.println("C (" + x3 + ", " + y3 + ")");

        if (isCollinearBySlope(x1, y1, x2, y2, x3, y3)) {
            System.out.println("\nUsing Slope Formula: Points are Collinear");
        } else {
            System.out.println("\nUsing Slope Formula: Points are NOT Collinear");
        }

        if (isCollinearByArea(x1, y1, x2, y2, x3, y3)) {
            System.out.println("Using Area Formula: Points are Collinear");
        } else {
            System.out.println("Using Area Formula: Points are NOT Collinear");
        }
        sc.close();
    }
}
