import java.util.Arrays;
public class SearchOperations {
    public static void main(String[] args) {

        int[] arr = {3, 4, -1, 1};
        int target = 4;

        int missing = firstMissingPositive(arr.clone());
        int index = binarySearch(arr.clone(), target);

        System.out.println("First Missing Positive: " + missing);
        System.out.println("Index of Target: " + index);
    }

    public static int firstMissingPositive(int[] arr) {

        int n = arr.length;
        boolean[] visited = new boolean[n + 1];

        for (int num : arr) {
            if (num > 0 && num <= n) {
                visited[num] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        return n + 1;
    }

    public static int binarySearch(int[] arr, int target) {

        Arrays.sort(arr);
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}