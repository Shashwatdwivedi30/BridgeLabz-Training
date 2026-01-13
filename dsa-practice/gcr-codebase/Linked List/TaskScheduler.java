public class TaskScheduler {

    // Node definition
    static class TaskNode {
        int taskId;
        String taskName;
        int priority;
        String dueDate;
        TaskNode next;

        TaskNode(int taskId, String taskName, int priority, String dueDate) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.priority = priority;
            this.dueDate = dueDate;
        }
    }

    private TaskNode head;
    private TaskNode current;

    // Add at beginning
    void addAtBeginning(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        newNode.next = head;
        temp.next = newNode;
        head = newNode;
    }

    // Add at end
    void addAtEnd(int id, String name, int priority, String date) {
        TaskNode newNode = new TaskNode(id, name, priority, date);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head)
            temp = temp.next;

        temp.next = newNode;
        newNode.next = head;
    }

    // Add at specific position
    void addAtPosition(int pos, int id, String name, int priority, String date) {
        if (pos == 1) {
            addAtBeginning(id, name, priority, date);
            return;
        }

        TaskNode newNode = new TaskNode(id, name, priority, date);
        TaskNode temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++)
            temp = temp.next;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Remove by Task ID
    void removeByTaskId(int taskId) {
        if (head == null) return;

        TaskNode curr = head, prev = null;

        do {
            if (curr.taskId == taskId) {
                if (prev != null) {
                    prev.next = curr.next;
                } else {
                    TaskNode last = head;
                    while (last.next != head)
                        last = last.next;
                    head = head.next;
                    last.next = head;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // View current task and move to next
    void viewNextTask() {
        if (current == null) return;
        System.out.println("Current Task: " + current.taskName);
        current = current.next;
    }

    // Display all tasks
    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        TaskNode temp = head;
        do {
            System.out.println(
                temp.taskId + " | " +
                temp.taskName + " | Priority: " +
                temp.priority + " | Due: " +
                temp.dueDate
            );
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    void searchByPriority(int priority) {
        if (head == null) return;

        TaskNode temp = head;
        do {
            if (temp.priority == priority)
                System.out.println("Task Found: " + temp.taskName);
            temp = temp.next;
        } while (temp != head);
    }

    // Main method
    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        scheduler.addAtEnd(1, "Design", 1, "10-02-2026");
        scheduler.addAtEnd(2, "Coding", 2, "15-02-2026");
        scheduler.addAtBeginning(3, "Planning", 1, "05-02-2026");

        scheduler.displayTasks();
        scheduler.viewNextTask();
        scheduler.searchByPriority(1);
        scheduler.removeByTaskId(2);
        scheduler.displayTasks();
    }
}