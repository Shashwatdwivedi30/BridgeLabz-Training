import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (year < 1582) {
            System.out.println("Year must be greater than 1582");
            return;
        }       
        // Multiple if-else statements        
        if (year % 400 == 0) {
            System.out.println(year+" is a Leap Year");
        } else if (year % 100 == 0) {
            System.out.println(year+" is not a Leap Year");
        } else if (year % 4 == 0) {
            System.out.println(year+" is a Leap Year");
        } else {
            System.out.println(year+" is not a Leap Year");
        }
        
        // Single if statement with logical operators
        if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
            System.out.println(year+" is a Leap Year");
        } else {
            System.out.println(year+" is not a Leap Year");
        }        
    }
}