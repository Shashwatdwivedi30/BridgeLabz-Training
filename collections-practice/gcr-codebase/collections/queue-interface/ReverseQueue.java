import java.util.*;

public class ReverseQueue {
    public static Queue<Integer> reverse(Queue<Integer> queue) {
        if (queue.isEmpty()) return queue;

        int front = queue.remove();
        reverse(queue);
        queue.add(front);

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);

        System.out.println("Original Queue: " + q);
        reverse(q);
        System.out.println("Reversed Queue: " + q);
    }
}