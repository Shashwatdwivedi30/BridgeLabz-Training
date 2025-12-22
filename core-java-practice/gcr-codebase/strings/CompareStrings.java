import java.util.Scanner;

public class CompareStrings {   
    public static boolean compareUsingCharAt(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }       
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);       
        System.out.println("Enter first string: ");
        String str1 = sc.next();        
        System.out.println("Enter second string: ");
        String str2 = sc.next();        
        boolean customResult = compareUsingCharAt(str1, str2);
        boolean builtInResult = str1.equals(str2);
        
        System.out.println("Result using charAt() method: " + customResult);
        System.out.println("Result using equals() method: " + builtInResult);
        System.out.println("Both results match: " + (customResult == builtInResult));        //If both results are same then returns true else false
        sc.close();
    }
}