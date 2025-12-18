import java.util.*;
public class HeightConversion {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cm =  input.nextInt();
        float inch = cm * 0.39f;           //1 inch = 2.54 cm
        float feet = cm * 0.39f * 0.08f;   //1 feet = 12 inches
        System.out.println("Your Height in cm is "+cm+" while in feet is "+feet+" and inches is "+inch);
    }
}
