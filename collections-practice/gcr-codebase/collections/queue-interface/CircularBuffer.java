public class CircularBuffer {
    int[] buffer;
    int head = 0;
    int size = 0;
    int capacity;

    CircularBuffer(int capacity) {
        this.capacity = capacity;
        buffer = new int[capacity];
    }

    public void insert(int value) {
        buffer[head] = value;
        head = (head + 1) % capacity;

        if (size < capacity) size++;
    }

    public void printBuffer() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(buffer[(head + i) % capacity] + " ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);

        cb.insert(4); // overwrites 1
        cb.printBuffer(); // [2, 3, 4]
    }
}
