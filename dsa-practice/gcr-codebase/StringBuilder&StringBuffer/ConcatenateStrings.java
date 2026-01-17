import java.util.*;
public class ConcatenateStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length of an array ");
        int n = sc.nextInt();
        String[] array = new String[n];
        System.out.println("Enter array of strings");
        for (int i = 0; i < n; i++) {
            array[i] = sc.next();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((array[i]));
        }
        System.out.println("Concatenated string: " +sb);
        sc.close();
    }
}