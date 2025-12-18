import java.util.Scanner;

public class QuotientRemainder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int rem = number1 % number2;         //Finding remainder
        int quotient = number1 / number2;    //Finding quotient
        System.out.println("The Quotient is "+quotient+" and Reminder is "+rem+" of two number "+number1+" and "+number2);
    }
}
