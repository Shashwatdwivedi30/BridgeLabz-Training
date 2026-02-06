import java.util.*;

public class BinaryNumbersQueue {
    public static List<String> generateBinary(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();

        queue.add("1");

        while (n-- > 0) {
            String s = queue.remove();
            result.add(s);
            queue.add(s + "0");
            queue.add(s + "1");
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(generateBinary(n));
    }
}