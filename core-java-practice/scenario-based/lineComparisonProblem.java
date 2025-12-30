import java.util.Scanner;

public class lineComparisonProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Line Comparison Computation Program");

        // User Case 1 (Calculating length of lines)
        System.out.println("Points of line 1");
        System.out.print("Enter value of x1: ");
        int x1 = sc.nextInt();
        System.out.print("Enter value of y1: ");
        int y1 = sc.nextInt();
        System.out.print("Enter value of x2: ");
        int x2 = sc.nextInt();
        System.out.print("Enter value of y2: ");
        int y2 = sc.nextInt();
        System.out.println("Point 1 is: ("+x1+","+y1+")");
        System.out.println("Point 2 is: ("+x2+","+y2+")");
        System.out.println();

        System.out.println("Points of line 2");
        System.out.print("Enter value of x3: ");
        int x3 = sc.nextInt();
        System.out.print("Enter value of y3: ");
        int y3 = sc.nextInt();
        System.out.print("Enter value of x4: ");
        int x4 = sc.nextInt();
        System.out.print("Enter value of y4: ");
        int y4 = sc.nextInt();
        System.out.println("Point 1 is: ("+x3+","+y3+")");
        System.out.println("Point 2 is: ("+x4+","+y4+")");
        System.out.println();
        Double lengthOfLine1 = Math.sqrt(Math.pow((x2-x1),2) + Math.pow((y2-y1),2));
        System.out.println("Length of line 1 is: "+lengthOfLine1);

        Double lengthOfLine2 = Math.sqrt(Math.pow((x4-x3),2) + Math.pow((y4-y3),2));
        System.out.println("Length of line 2 is: "+lengthOfLine2);
        System.out.println();

        //User Case 2 (checking equality using equals() method)
        if (lengthOfLine1.equals(lengthOfLine2)) {
            System.out.println("Both lines are equal");
        } else {
            System.out.println("Both lines are not equal");
        }
        System.out.println();

        //User Case 3 (Comparting two lines using compareTo() method)
        int result = lengthOfLine1.compareTo(lengthOfLine2);
        if (result == 0) {
            System.out.println("Both lines are equal");
        } else if (result > 0) {
            System.out.println("Line 1 is greater than Line 2");
        } else {
            System.out.println("Line 1 is less than Line 2");
        }
        sc.close();
    }
}