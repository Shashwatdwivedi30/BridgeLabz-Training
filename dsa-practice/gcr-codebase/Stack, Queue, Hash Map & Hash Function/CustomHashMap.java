public class CustomHashMap {

    // Node class
    static class Node {
        int key;
        String value;
        Node next;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    // HashMap implementation
    static class MyHashMap {

        private int SIZE = 10;
        private Node[] buckets;

        MyHashMap() {
            buckets = new Node[SIZE];
        }

        private int getIndex(int key) {
            return key % SIZE;
        }

        // Insert or Update
        void put(int key, String value) {
            int index = getIndex(key);
            Node head = buckets[index];

            while (head != null) {
                if (head.key == key) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }

            Node newNode = new Node(key, value);
            newNode.next = buckets[index];
            buckets[index] = newNode;
        }

        // Get value
        String get(int key) {
            int index = getIndex(key);
            Node head = buckets[index];

            while (head != null) {
                if (head.key == key) {
                    return head.value;
                }
                head = head.next;
            }
            return null;
        }

        // Remove key
        void remove(int key) {
            int index = getIndex(key);
            Node head = buckets[index];
            Node prev = null;

            while (head != null) {
                if (head.key == key) {
                    if (prev == null) {
                        buckets[index] = head.next;
                    } else {
                        prev.next = head.next;
                    }
                    return;
                }
                prev = head;
                head = head.next;
            }
        }
    }

    // Main method
    public static void main(String[] args) {

        MyHashMap map = new MyHashMap();

        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(12, "Orange"); 

        System.out.println(map.get(1));   // Apple
        System.out.println(map.get(2));   // Banana
        System.out.println(map.get(12));  // Orange

        map.remove(2);
        System.out.println(map.get(2));   
    }
}
