import java.util.*;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2;
        int n = list.size();
        k = k % n;

        List<Integer> result = new ArrayList<>();

        for (int i = k; i < n; i++)
            result.add(list.get(i));

        for (int i = 0; i < k; i++)
            result.add(list.get(i));

        System.out.println(result); 
    }
}
