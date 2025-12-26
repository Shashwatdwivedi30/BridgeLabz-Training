import java.util.Scanner;
public class SubstringOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the main string:");
        String text = sc.nextLine();
        System.out.println("Enter the substring to search:");
        String sub = sc.nextLine();
        int count = 0;
        for (int i = 0; i <= text.length() - sub.length(); i++) {
            int j;
            for (j = 0; j < sub.length(); j++) {
                if (text.charAt(i + j) != sub.charAt(j)) {
                    break;
                }
            }
            if (j == sub.length()) {
                count++;
            }
        }
        System.out.println("Substring occurs " + count + " times.");
        sc.close();
    }
}