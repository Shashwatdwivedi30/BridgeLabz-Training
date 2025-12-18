import java.util.Scanner;

public class Perimeter_rect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l =  sc.nextInt();
        int b =  sc.nextInt();
        int perimeter = 2 * (l + b);
        System.out.println("Perimtere of rectangle: "+perimeter);
    }
}
