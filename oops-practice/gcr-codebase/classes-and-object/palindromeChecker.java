import java.util.Scanner;

class palindromeChecker {
    String text;

    boolean isPalindrome() {
        String cleanText = text.replaceAll(" ", "").toLowerCase();
        String reverse = "";

        for (int i = cleanText.length() - 1; i >= 0; i--) {
            reverse = reverse + cleanText.charAt(i);
        }

        if (cleanText.equals(reverse))
            return true;
        else
            return false;
    }

    void displayResult() {
        if (isPalindrome())
            System.out.println(text + " is palindrome");
        else
            System.out.println(text + " is not Palindrome");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        palindromeChecker p = new palindromeChecker();

        System.out.print("Enter text: ");
        p.text = sc.nextLine();

        p.displayResult();
        sc.close();
    }
}