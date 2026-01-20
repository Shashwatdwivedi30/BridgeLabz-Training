import java.util.Random;

public class SortingComparison {

    static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < n1)
            arr[k++] = L[i++];

        while (j < n2)
            arr[k++] = R[j++];
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {

        int N = 10_000; 
        int[] original = new int[N];

        Random rand = new Random();
        for (int i = 0; i < N; i++) {
            original[i] = rand.nextInt(N);
        }

        int[] arr1 = original.clone();
        int[] arr2 = original.clone();
        int[] arr3 = original.clone();

        long startBubble = System.currentTimeMillis();
        bubbleSort(arr1);
        long endBubble = System.currentTimeMillis();

        long startMerge = System.currentTimeMillis();
        mergeSort(arr2, 0, arr2.length - 1);
        long endMerge = System.currentTimeMillis();

        long startQuick = System.currentTimeMillis();
        quickSort(arr3, 0, arr3.length - 1);
        long endQuick = System.currentTimeMillis();

        System.out.println("Dataset Size: " + N);
        System.out.println("Bubble Sort Time: " + (endBubble - startBubble) + " ms");
        System.out.println("Merge Sort Time: " + (endMerge - startMerge) + " ms");
        System.out.println("Quick Sort Time: " + (endQuick - startQuick) + " ms");
    }
}