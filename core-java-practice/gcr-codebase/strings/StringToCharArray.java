import java.util.Arrays;
import java.util.Scanner;

public class StringToCharArray {
    public static char[] charactersManual(String text){
        char ch[] = new char[text.length()];
        for(int i = 0; i < text.length(); i++){
            ch[i] = text.charAt(i);
        }
        return ch;
    }

    public static boolean compare(char[] arrayManual, char[] arrayBuiltIn){
        if(arrayManual.length != arrayBuiltIn.length){
            return false;
        }
        for (int i = 0; i < arrayBuiltIn.length; i++) {
            if(arrayManual[i] != arrayBuiltIn[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter a string: ");
    String text = sc.next(); 
    char manual[] = charactersManual(text);
    char buildIn[] = text.toCharArray();
    System.out.println("Manually created array is: "+Arrays.toString(manual));
    System.out.println("Array created using builtIn method is: "+Arrays.toString(buildIn));
    System.out.println("The compared result is: "+compare(manual, buildIn));
    sc.close();
    }
}
