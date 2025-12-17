import java.util.Scanner;

public class Reverse_Str {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        for(int  i = s.length()-1; i >= 0; i--){
            sb = sb.append(s.charAt(i));
        }
        System.out.println(sb.toString());
    }
}