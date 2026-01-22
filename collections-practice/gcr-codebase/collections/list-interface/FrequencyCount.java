import java.util.*;

public class FrequencyCount {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> map = new HashMap<>();

        for (String item : list) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        System.out.println(map);
    }
}
