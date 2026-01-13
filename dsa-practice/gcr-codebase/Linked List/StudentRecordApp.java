class Node {
    int rollNo;
    String name;
    int age;
    char grade;
    Node next;

    Node(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentLinkedList {
    private Node head;

    // Add at beginning
    public void addAtBeginning(int rollNo, String name, int age, char grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addAtEnd(int rollNo, String name, int age, char grade) {
        Node newNode = new Node(rollNo, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;
        temp.next = newNode;
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, int rollNo, String name, int age, char grade) {
        if (pos == 1) {
            addAtBeginning(rollNo, name, age, grade);
            return;
        }
        Node newNode = new Node(rollNo, name, age, grade);
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++)
            temp = temp.next;

        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete by Roll Number
    public void deleteByRollNo(int rollNo) {
        if (head == null) return;

        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null && temp.next.rollNo != rollNo)
            temp = temp.next;

        if (temp.next == null) {
            System.out.println("Student not found");
        } else {
            temp.next = temp.next.next;
        }
    }

    // Search by Roll Number
    public void search(int rollNo) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                System.out.println("Found: " + temp.name + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // Update grade
    public void updateGrade(int rollNo, char newGrade) {
        Node temp = head;
        while (temp != null) {
            if (temp.rollNo == rollNo) {
                temp.grade = newGrade;
                System.out.println("Grade updated");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found");
    }

    // Display all students
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(
                "RollNo: " + temp.rollNo +
                ", Name: " + temp.name +
                ", Age: " + temp.age +
                ", Grade: " + temp.grade
            );
            temp = temp.next;
        }
    }
}

public class StudentRecordApp {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();

        list.addAtBeginning(1, "Aman", 20, 'A');
        list.addAtEnd(2, "Riya", 21, 'B');
        list.addAtPosition(2, 3, "Shashwat", 22, 'A');

        list.display();

        list.search(2);
        list.updateGrade(2, 'A');
        list.deleteByRollNo(1);

        System.out.println("\nAfter Updates:");
        list.display();
    }
}