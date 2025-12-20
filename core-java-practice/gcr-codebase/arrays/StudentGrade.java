import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        int[][] marks = new int[n][3];   // 0-Physics, 1-Chemistry, 2-Maths
        double[] percentage = new double[n];
        char[] grade = new char[n];
        int i = 0;        //Counter variable

        // Take input for marks with validation (using while)
        while (i < n) {
            System.out.println("\nStudent " + (i + 1));

            // Physics
            while (true) {
                System.out.print("Enter Physics marks: ");
                marks[i][0] = sc.nextInt();
                if (marks[i][0] >= 0)
                    break;
                System.out.println("Marks cannot be negative. Re-enter.");
            }

            // Chemistry
            while (true) {
                System.out.print("Enter Chemistry marks: ");
                marks[i][1] = sc.nextInt();
                if (marks[i][1] >= 0)
                    break;
                System.out.println("Marks cannot be negative. Re-enter.");
            }

            // Maths
            while (true) {
                System.out.print("Enter Maths marks: ");
                marks[i][2] = sc.nextInt();
                if (marks[i][2] >= 0)
                    break;
                System.out.println("Marks cannot be negative. Re-enter.");
            }
            i++;
        }

        // Calculate percentage and grade
        i = 0;
        while (i < n) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80)
                grade[i] = 'A';
            else if (percentage[i] >= 70)
                grade[i] = 'B';
            else if (percentage[i] >= 60)
                grade[i] = 'C';
            else if (percentage[i] >= 50)
                grade[i] = 'D';
            else if (percentage[i] >= 40)
                grade[i] = 'E';
            else
                grade[i] = 'R';
            i++;
        }

        i = 0;
        while (i < n) {
            System.out.println("Student " + (i + 1));
            System.out.println("Physics: " + marks[i][0]);
            System.out.println("Chemistry: " + marks[i][1]);
            System.out.println("Maths: " + marks[i][2]);
            System.out.printf("Percentage: %.2f\n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
            System.out.println();
            i++;
        }
        sc.close();
    }
}
