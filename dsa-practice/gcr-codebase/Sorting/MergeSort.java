import java.util.*;
public class MergeSort {

    static void mergeSort(int[] prices, int left, int right){
        if(left < right){
            int mid = (left + right)/2;

            mergeSort(prices, left, mid);

            mergeSort(prices, mid+1, right);

            merge(prices, left, mid, right);
        }
    }

    static void merge(int[] prices, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for(int i = 0; i < n1; i++){
            L[i] = prices[left + i];
        }

        for(int i = 0; i < n2; i++){
            R[i] = prices[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while(i < n1 &&  j < n2){
            if(L[i] <= R[j]){
                prices[k] = L[i];
                i++;
            }
            else{
                prices[k] = R[j];
                j++;
            }
            k++;
        }

        while(i < n1){
            prices[k] = L[i];
            i++;
            k++;
        }

        while(j < n2){
            prices[k] = R[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Books");
        int n = sc.nextInt();
        int[] bookPrices = new int[n];

        
        for(int i = 0; i < n; i++){
            System.out.println("Enter price of book " +(i+1));
            bookPrices[i] = sc.nextInt();
        }

        mergeSort(bookPrices, 0, n);

        System.out.println("Sorted Book Prices:");
        for (int price : bookPrices) {
            System.out.print(price + " ");
        }
        sc.close();
    }
}