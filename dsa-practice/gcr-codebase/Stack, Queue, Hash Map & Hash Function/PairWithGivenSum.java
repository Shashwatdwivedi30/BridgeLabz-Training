import java.util.*;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            int required = target - num;

            if (set.contains(required)) {
                System.out.println("Pair found: " + num + " + " + required + " = " + target);
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        boolean result = hasPairWithSum(arr, target);

        if (!result) {
            System.out.println("No pair found with given sum");
        }

        sc.close();
    }
}