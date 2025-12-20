import java.util.Scanner;

public class StudentGrade2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students:");
        int n = sc.nextInt();
        int[][] marks = new int[n][3];   // [student][subject]
        double[] percentage = new double[n];
        char[] grade = new char[n];
        int i = 0;         //Counter variable

        while (i < n) {
            System.out.println("\nStudent " + (i + 1));
            int j = 0;      //Counter variable
            while (j < 3) {
                if (j == 0)
                    System.out.print("Enter Physics marks: ");
                else if (j == 1)
                    System.out.print("Enter Chemistry marks: ");
                else
                    System.out.print("Enter Maths marks: ");
                marks[i][j] = sc.nextInt();

                if (marks[i][j] < 0) {
                    System.out.println("Marks cannot be negative. Re-enter.");
                } else {
                    j++; // move to next subject only if valid
                }
            }
            i++;
        }

        // Calculate percentage and grade using 2D array
        i = 0;
        while (i < n) {
            int total = 0;
            int j = 0;

            while (j < 3) {
                total += marks[i][j];
                j++;
            }
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
            System.out.printf("Percentage: %.2f%%\n", percentage[i]);
            System.out.println("Grade: " + grade[i]);
            System.out.println();
            i++;
        }
        sc.close();
    }
}