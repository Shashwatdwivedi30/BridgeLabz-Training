import java.util.*;
public class RotationPointInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of an array");
        int n = sc.nextInt();
        int[] arr = new int[n];

        
        for(int i = 0; i < n; i++){
            System.out.println("Enter number " +(i+1));
            arr[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;

        while(left < right){
            int mid = left + (right - left)/2;
            if(arr[mid] > arr[right]){
                left = mid + 1;
            }
            else if(arr[mid] < arr[right]){
                right = mid;
            }
        }
        System.out.println("Smallest element is " +arr[left]);
        sc.close();
    }
}