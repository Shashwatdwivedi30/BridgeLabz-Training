import java.util.Scanner;

public class SideOfSquare {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int perimeter = input.nextInt();
        float side = perimeter/4;
        System.out.println("The length of the side is "+side+" whose perimeter is "+perimeter);
    }
}
