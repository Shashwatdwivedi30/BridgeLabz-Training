import java.util.*;
public class FirstNegativeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array");
        int n = sc.nextInt();
        int[] numbers = new int[n];

        
        for(int i = 0; i < n; i++){
            System.out.println("Enter number " +(i+1));
            numbers[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            if(numbers[i] < 0){
                System.out.println("First negative number is on index " +i);
                return;
            }
        }
        System.out.println("-1");
    }    
}