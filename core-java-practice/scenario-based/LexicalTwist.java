import java.util.*;
public class LexicalTwist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first word: ");
        String word1 = sc.next();
        if (word1.contains(" ")) {
            System.out.println(word1 + " is an invalid word");
            return;
        }
        
        System.out.print("Enter second word: ");
        String word2 = sc.next();
        if (word2.contains(" ")) {
            System.out.println(word2 + " is an invalid word");
            return;
        }

        String reversed2 = new StringBuilder(word2).reverse().toString();

        if(word1.equalsIgnoreCase(reversed2)){
            String reversed1 = new StringBuilder(word1).reverse().toString().toLowerCase();
            for (int i = 0; i < reversed1.length(); i++) {
                char ch = reversed1.charAt(i);
                if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                    reversed1 = reversed1.replaceAll("[aeiou]", "@");
                }
            }
            System.out.println("Reversed word is " +reversed1);
        }
        else{
            String word = (word1 + word2).toUpperCase();
            int vowels = 0, consonants = 0;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
                    vowels += 1;
                }
                else{
                    consonants += 1;
                }
            }
            String str = "";
            if(vowels > consonants){
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if((ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') && str.indexOf(ch) == -1 && str.length() < 2){
                        str += ch;
                    }
                }
                System.out.println(str);
            }
            else if(vowels < consonants){
                for (int i = 0; i < word.length(); i++) {
                    char ch = word.charAt(i);
                    if((ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U') && str.indexOf(ch) == -1 && str.length() < 2){
                        str += ch;
                    }
                }
                System.out.println(str);
            }
            else{
                System.out.println("Vowels and consonants are equal.");
            }
            sc.close();
        }
    }
}