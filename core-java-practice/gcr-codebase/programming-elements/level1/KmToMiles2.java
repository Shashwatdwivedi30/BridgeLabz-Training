import java.util.Scanner;

public class KmToMiles2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double km = input.nextInt();
        double miles = km * 0.621371;
        System.out.println("The distance "+km+" km in miles is "+miles);
    }
}