import java.util.Scanner;

public class QuickSort {

    static void quickSort(int[] prices, int low, int high){
        if(low < high){
            int pivotIndex = partition(prices, low, high);

            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    static int partition(int[] prices, int low, int high){
        int pivot = prices[high];
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(prices[j] < pivot){
                i++;
                int temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
            }
        }

        int temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;

        return i + 1; 
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of products: ");
        int n = sc.nextInt();

        int[] productPrices = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price of product " + (i + 1) + ": ");
            productPrices[i] = sc.nextInt();
        }

        quickSort(productPrices, 0, n - 1);

        System.out.println("Sorted Product Prices:");
        for (int price : productPrices) {
            System.out.print(price + " ");
        }

        sc.close();
    }
}