import java.util.*;
public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string ");
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(!set.contains(ch)){
                sb.append(ch);
                set.add(ch);
            }
        }
        System.out.println("String without duplicates " +sb.toString());
        sc.close();
    }
}