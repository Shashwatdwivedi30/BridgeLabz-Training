import java.util.Scanner;
public class AnagramCheck2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine().toLowerCase().replace(" ", "");
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine().toLowerCase().replace(" ", "");

        if (s1.length() != s2.length()) {
            System.out.println("The strings are NOT anagrams");
            return;
        }
        int[] freq = new int[256];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            freq[s2.charAt(i)]--;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                System.out.println("The strings are NOT anagrams");
                sc.close();
                return;
            }
        }
        System.out.println("The strings are anagrams");
        sc.close();
    }
}