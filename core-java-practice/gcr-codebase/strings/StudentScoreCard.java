import java.util.Random;

public class StudentScoreCard {

    // To generate random scores for PCM for all students
    public static int[][] generateScores(int students) {
        Random rand = new Random();
        int[][] scores = new int[students][3]; // Physics, Chemistry, Math
        for (int i = 0; i < students; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(101); // 0 to 100
            }
        }
        return scores;
    }

    // Method to calculate total, average, and percentage
    public static double[][] calculateStats(int[][] scores) {
        int students = scores.length;
        double[][] stats = new double[students][3]; // total, average, percentage
        for (int i = 0; i < students; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = total / 3.0; // as max marks per subject is 100

            stats[i][0] = Math.round(total); // round to nearest integer
            stats[i][1] = Math.round(average * 100.0) / 100.0; // 2 decimal places
            stats[i][2] = Math.round(percentage * 100.0) / 100.0; // 2 decimal places
        }
        return stats;
    }

    // Method to calculate grades based on percentage
    public static String[] calculateGrades(double[][] stats) {
        int students = stats.length;
        String[] grades = new String[students];

        for (int i = 0; i < students; i++) {
            double percentage = stats[i][2];
            if (percentage >= 80) grades[i] = "A";
            else if (percentage >= 70) grades[i] = "B";
            else if (percentage >= 60) grades[i] = "C";
            else if (percentage >= 50) grades[i] = "D";
            else if (percentage >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    // Method to display scorecard
    public static void displayScorecard(int[][] scores, double[][] stats, String[] grades) {
        System.out.println("Student\tPhysics\tChemistry\tMath\tTotal\tAverage\tPercentage\tGrade");
        System.out.println("----------------------------------------------------------------------");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t");
            System.out.print(scores[i][0] + "\t" + scores[i][1] + "\t\t" + scores[i][2] + "\t");
            System.out.print((int) stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2] + "\t\t" + grades[i]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int students = 10;
        int[][] scores = generateScores(students);
        double[][] stats = calculateStats(scores);
        String[] grades = calculateGrades(stats);
        displayScorecard(scores, stats, grades);
    }
}
