public class RoundRobinScheduling {

    // Node class
    static class Process {
        int pid;
        int burstTime;
        int remainingTime;
        int waitingTime;
        int turnaroundTime;
        Process next;

        Process(int pid, int burstTime) {
            this.pid = pid;
            this.burstTime = burstTime;
            this.remainingTime = burstTime;
            this.waitingTime = 0;
            this.turnaroundTime = 0;
            this.next = null;
        }
    }

    static Process head = null;
    static Process tail = null;

    // Add process at end
    static void addProcess(int pid, int burstTime) {
        Process newProcess = new Process(pid, burstTime);

        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    // Remove process by PID
    static void removeProcess(Process prev, Process curr) {
        if (curr == head && curr == tail) {
            head = tail = null;
        } else {
            prev.next = curr.next;
            if (curr == head) head = curr.next;
            if (curr == tail) tail = prev;
        }
    }

    // Display processes
    static void displayProcesses() {
        if (head == null) return;

        Process temp = head;
        do {
            System.out.print(
                    "P" + temp.pid + "(Remaining: " + temp.remainingTime + ")  "
            );
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // Round Robin Scheduling
    static void roundRobin(int timeQuantum) {
        if (head == null) return;

        int time = 0;
        int completed = 0;
        int totalWaiting = 0;
        int totalTurnaround = 0;

        Process curr = head;
        Process prev = tail;

        System.out.println("Round Robin Execution:");

        while (head != null) {

            if (curr.remainingTime > 0) {
                System.out.println("Executing Process P" + curr.pid);

                if (curr.remainingTime > timeQuantum) {
                    curr.remainingTime -= timeQuantum;
                    time += timeQuantum;
                } else {
                    time += curr.remainingTime;
                    curr.remainingTime = 0;

                    curr.turnaroundTime = time;
                    curr.waitingTime = curr.turnaroundTime - curr.burstTime;

                    totalWaiting += curr.waitingTime;
                    totalTurnaround += curr.turnaroundTime;
                    completed++;

                    Process temp = curr.next;
                    removeProcess(prev, curr);
                    curr = temp;

                    displayProcesses();
                    continue;
                }
            }

            displayProcesses();
            prev = curr;
            curr = curr.next;
        }

        System.out.println("\nAverage Waiting Time: " +
                (double) totalWaiting / completed);
        System.out.println("Average Turnaround Time: " +
                (double) totalTurnaround / completed);
    }

    // Main method
    public static void main(String[] args) {

        addProcess(1, 10);
        addProcess(2, 5);
        addProcess(3, 8);

        int timeQuantum = 4;

        displayProcesses();
        roundRobin(timeQuantum);
    }
}