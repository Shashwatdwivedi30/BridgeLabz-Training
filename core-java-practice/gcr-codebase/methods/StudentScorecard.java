import java.util.Scanner;

public class StudentScorecard {

    public static int[][] generatePCMMarks(int n) {
        int[][] marks = new int[n][3]; // Physics, Chemistry, Maths
        for (int i = 0; i < n; i++) {
            marks[i][0] = (int)(Math.random() * 90) + 10;
            marks[i][1] = (int)(Math.random() * 90) + 10;
            marks[i][2] = (int)(Math.random() * 90) + 10;
        }
        return marks;
    }

    // 2D array: [total, average, percentage]
    public static double[][] calculateResults(int[][] marks) {
        int n = marks.length;
        double[][] results = new double[n][3];

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    public static void displayScorecard(int[][] marks, double[][] results) {
        System.out.println("\nID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.println(
                (i + 1) + "\t" + marks[i][0] + "\t" + marks[i][1] + "\t\t" + marks[i][2] + "\t" + (int)results[i][0] + "\t" + results[i][1] + "\t" +
                results[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[][] pcmMarks = generatePCMMarks(n);
        double[][] results = calculateResults(pcmMarks);
        displayScorecard(pcmMarks, results);
        sc.close();
    }
}