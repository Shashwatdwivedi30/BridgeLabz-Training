import java.util.Arrays;

public class SearchComparison {

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int N = 1_000_000;
        int[] data = new int[N];

        for (int i = 0; i < N; i++) {
            data[i] = i + 1;
        }

        int target = N; 

        long startLinear = System.nanoTime();
        linearSearch(data, target);
        long endLinear = System.nanoTime();

        long linearTime = endLinear - startLinear;

        Arrays.sort(data);

        long startBinary = System.nanoTime();
        binarySearch(data, target);
        long endBinary = System.nanoTime();

        long binaryTime = endBinary - startBinary;

        // Results
        System.out.println("Dataset Size: " + N);
        System.out.println("Linear Search Time (ns): " + linearTime);
        System.out.println("Binary Search Time (ns): " + binaryTime);
    }
}