import java.util.Scanner;
public class FeetsToYards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double feet = sc.nextDouble();
        double yards = feet / 3;          //conversion from feet to yards
        double miles = yards / 1760;      ////conversion from yards to miles
        System.out.println("Distance in yards is "+yards+" and distance in miles is " + miles);
    }
}
