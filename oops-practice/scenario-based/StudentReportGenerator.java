import java.util.*;
class InvalidMarkException extends Exception {
    public InvalidMarkException(String msg) {
        super(msg);
    }
}

class Student {
    String name;
    String[] subjects;
    int[] marks;

    Student(String name, String[] subjects, int[] marks) {
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }
}

public class StudentReportGenerator {
    public static double calculateAverage(int[] marks) {
        int sum = 0;
        for (int i = 0; i < marks.length; i++) {
            sum += marks[i];
        }
        return (double) sum / marks.length;
    }

    public static String getGrade(double avg) {
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 40) return "D";
        else return "F";
    }

    public static void displayReport(Student s) {
        System.out.println("\n----- Report Card -----");
        System.out.println("Name: " + s.name);

        for (int i = 0; i < s.subjects.length; i++) {
            System.out.println(s.subjects[i] + ": " + s.marks[i]);
        }

        double avg = calculateAverage(s.marks);
        System.out.println("Average: " + avg);
        System.out.println("Grade: " + getGrade(avg));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> students = new ArrayList<>();

        try {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            String[] subjects = {"Maths", "Science", "English"};
            int[] marks = new int[subjects.length];

            for (int i = 0; i < subjects.length; i++) {
                System.out.print("Enter marks for " + subjects[i] + ": ");
                marks[i] = sc.nextInt();

                // Validation
                if (marks[i] < 0 || marks[i] > 100) {
                    throw new InvalidMarkException(
                        "Marks should be between 0 and 100"
                    );
                }
            }

            students.add(new Student(name, subjects, marks));

            for (Student s : students) {
                displayReport(s);
            }

        } catch (InvalidMarkException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}