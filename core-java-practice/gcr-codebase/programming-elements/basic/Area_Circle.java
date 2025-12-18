import java.util.Scanner;

public class Area_Circle {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int radius = sc.nextInt();
        double area = radius * radius * 3.14;
        System.out.println("The area of the circle is " + area);
    }
}