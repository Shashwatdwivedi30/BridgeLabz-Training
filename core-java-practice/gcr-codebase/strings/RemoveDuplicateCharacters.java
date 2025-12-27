import java.util.Scanner;
public class RemoveDuplicateCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String text = sc.nextLine();
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            // If character not already in result, add it
            if (result.indexOf(ch) == -1) {
                result = result + ch;
            }
        }
        System.out.println("String after removing duplicates:");
        System.out.println(result);
        sc.close();
    }
}