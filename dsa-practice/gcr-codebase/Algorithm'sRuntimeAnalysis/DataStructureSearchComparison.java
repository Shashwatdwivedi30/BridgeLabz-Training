import java.util.*;
public class DataStructureSearchComparison {

    static boolean arraySearch(int[] arr, int target) {
        for (int num : arr) {
            if (num == target)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        int N = 1_000_000; 
        int target = N - 1;

        int[] array = new int[N];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            array[i] = i;
            hashSet.add(i);
            treeSet.add(i);
        }

        long startArray = System.currentTimeMillis();
        arraySearch(array, target);
        long endArray = System.currentTimeMillis();

        long startHashSet = System.currentTimeMillis();
        hashSet.contains(target);
        long endHashSet = System.currentTimeMillis();

        long startTreeSet = System.currentTimeMillis();
        treeSet.contains(target);
        long endTreeSet = System.currentTimeMillis();

        System.out.println("Dataset Size: " + N);
        System.out.println("Array Search Time: " + (endArray - startArray) + " ms");
        System.out.println("HashSet Search Time: " + (endHashSet - startHashSet) + " ms");
        System.out.println("TreeSet Search Time: " + (endTreeSet - startTreeSet) + " ms");
    }
}