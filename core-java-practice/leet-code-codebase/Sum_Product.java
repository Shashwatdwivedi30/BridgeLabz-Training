import java.util.*;
public class Sum_Product {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pro = 1,sum = 0;
        while (n!= 0){
            int d = n % 10;
            pro*= d; 
            sum+= d;
            n/= 10;
        }
        System.out.println("Product of digits: "+pro);
        System.out.println("Sum of digits: "+sum);
    }
}
