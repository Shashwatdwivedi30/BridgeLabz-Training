import java.util.*;
public class CapitalizedWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String[] words = text.split("\\s+");
        ArrayList<String> result = new ArrayList<>();

        for (String w : words) {
            w = w.replaceAll("[^a-zA-Z]", "");         //remove , . !
            if (w.length() == 0) 
                continue;

            if (Character.isUpperCase(w.charAt(0))) {
                result.add(w);
            }
        }

        System.out.println("Capitalized words:");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) 
                System.out.print(", ");
        }
    }
}