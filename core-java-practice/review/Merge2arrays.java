import java.util.*;

class Merge2arrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of arrays");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        int[] res = new int[n + m];
        int a = 0, b = 0, k = 0;
        while (a < n && b < m) {
            if (arr1[a] <= arr2[b]) {
                res[k++] = arr1[a++];
            } else {
                res[k++] = arr2[b++];
            }
        }
        while(a < n){
            res[k++] = arr1[a++];
        }
        while(b < m){
            res[k++] = arr2[b++];
        }
        for (int i = 0; i < n + m; i++) {
            System.out.print(res[i] + " ");
        }
    }
}