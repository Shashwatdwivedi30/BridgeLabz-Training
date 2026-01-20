public class TrafficManager {

    static class VehicleNode {
        String vehicleNumber;
        VehicleNode next;

        VehicleNode(String vehicleNumber) {
            this.vehicleNumber = vehicleNumber;
            this.next = null;
        }
    }

    static VehicleNode head = null;

    static void addToRoundabout(String vehicleNumber) {
        VehicleNode newNode = new VehicleNode(vehicleNumber);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            VehicleNode temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
        System.out.println(vehicleNumber + " entered the roundabout");
    }

    static void removeFromRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        if (head.next == head) {
            System.out.println(head.vehicleNumber + " exited the roundabout");
            head = null;
            return;
        }

        VehicleNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        System.out.println(head.vehicleNumber + " exited the roundabout");
        temp.next = head.next;
        head = head.next;
    }

    static void displayRoundabout() {
        if (head == null) {
            System.out.println("Roundabout is empty");
            return;
        }

        System.out.print("Roundabout Vehicles: ");
        VehicleNode temp = head;
        do {
            System.out.print(temp.vehicleNumber + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to start)");
    }

    static class VehicleQueue {
        int front = -1, rear = -1, size;
        String[] queue;

        VehicleQueue(int size) {
            this.size = size;
            queue = new String[size];
        }

        void enqueue(String vehicleNumber) {
            if (rear == size - 1) {
                System.out.println("Queue Overflow! Vehicle waiting.");
                return;
            }

            if (front == -1) front = 0;
            queue[++rear] = vehicleNumber;
            System.out.println(vehicleNumber + " added to waiting queue");
        }

        String dequeue() {
            if (front == -1 || front > rear) {
                System.out.println("Queue Underflow! No vehicles waiting.");
                return null;
            }
            return queue[front++];
        }
    }

    public static void main(String[] args) {

        VehicleQueue waitingQueue = new VehicleQueue(3);

        // Vehicles arrive
        waitingQueue.enqueue("CAR-101");
        waitingQueue.enqueue("CAR-102");
        waitingQueue.enqueue("CAR-103");
        waitingQueue.enqueue("CAR-104"); 

        // Vehicles enter roundabout
        String vehicle;
        while ((vehicle = waitingQueue.dequeue()) != null) {
            addToRoundabout(vehicle);
        }

        displayRoundabout();

        // Vehicles exit
        removeFromRoundabout();
        displayRoundabout();

        removeFromRoundabout();
        displayRoundabout();
    }
}