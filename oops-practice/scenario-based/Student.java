import java.util.Scanner;
public class Student {
    static String universityName = "Global University";
    static int totalStudents = 0;
    final int rollNumber;
    String name;
    String grade;

    Student(int rollNumber, String name, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.grade = grade;
        totalStudents++;
    }

    static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    void displayDetails(Object obj) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            System.out.println("University Name: " + universityName);
            System.out.println("Roll Number: " + s.rollNumber);
            System.out.println("Name: " + s.name);
            System.out.println("Grade: " + s.grade);
        }
    }

    void updateGrade(Object obj, String newGrade) {
        if (obj instanceof Student) {
            Student s = (Student) obj;
            s.grade = newGrade;
            System.out.println("Grade updated to: " + newGrade);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number of Student 1: ");
        int roll1 = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name of Student 1: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Grade of Student 1: ");
        String grade1 = sc.nextLine();

        Student s1 = new Student(roll1, name1, grade1);

        System.out.print("Enter Roll Number of Student 2: ");
        int roll2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name of Student 2: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Grade of Student 2: ");
        String grade2 = sc.nextLine();

        Student s2 = new Student(roll2, name2, grade2);

        System.out.println();
        displayTotalStudents();

        System.out.println();
        s1.displayDetails(s1);

        System.out.println();
        s2.displayDetails(s2);

        System.out.print("\nEnter new grade for " + s2.name + ": ");
        String newGrade = sc.nextLine();

        s2.updateGrade(s2, newGrade);

        System.out.println();
        s2.displayDetails(s2);
        sc.close();
    }
}