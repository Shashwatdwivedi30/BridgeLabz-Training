import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int base = input.nextInt();
        int height = input.nextInt();
        float baseinch = base * 0.39f;            //converting cm to inch
        float heightinch = height * 0.39f;        //converting cm to inch
        float areaCm = (float)(base*height)/2;    //area in cm, formula is base*height*1/2
        float areainch = (float) (baseinch*heightinch)/2;
        System.out.println("The area of the triangle in cm is "+areaCm+" and in inch is "+areainch);
    }
}
