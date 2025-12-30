import java.util.Scanner;
class Student {
    String name;
    String rollNumber;
    double mark1, mark2, mark3;

    char calculateGrade() {
        double average = (mark1 + mark2 + mark3) / 3;

        if (average >= 80)
            return 'A';
        else if (average >= 60)
            return 'B';
        else if (average >= 40)
            return 'C';
        else
            return 'F';
    }

    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Student RollNumber: " + rollNumber);
        System.out.println("Student Marks:");
        System.out.println("Mark1: " + mark1);
        System.out.println("Mark2: " + mark2);
        System.out.println("Mark3: " + mark3);
        System.out.println("Grade " + calculateGrade());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        System.out.print("Enter student name: ");
        s.name = sc.nextLine();

        System.out.print("Enter roll number: ");
        s.rollNumber = sc.nextLine();

        System.out.print("Enter mark1: ");
        s.mark1 = sc.nextDouble();

        System.out.print("Enter mark2: ");
        s.mark2 = sc.nextDouble();

        System.out.print("Enter mark3: ");
        s.mark3 = sc.nextDouble();

        s.display();
        sc.close();
    }
}