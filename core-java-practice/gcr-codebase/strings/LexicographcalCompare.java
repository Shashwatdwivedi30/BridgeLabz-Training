import java.util.Scanner;
public class LexicographcalCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int minLength = Math.min(s1.length(), s2.length());
        boolean differenceFound = false;

        for (int i = 0; i < minLength; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            if (c1 < c2) {
                System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
                differenceFound = true;
                break;
            } 
            else if (c1 > c2) {
                System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order");
                differenceFound = true;
                break;
            }
        }

        if (!differenceFound) {
            if (s1.length() < s2.length()) {
                System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
            } 
            else if (s1.length() > s2.length()) {
                System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order");
            } 
            else {
                System.out.println("Both strings are equal");
            }
        }
        sc.close();
    }
}