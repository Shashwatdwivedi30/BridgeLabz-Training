import java.util.*;
public class Power3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n/2; i++){
            if(Math.pow(3,i) == n)
            {
                System.out.println(true);
            }
        }
    }
}
