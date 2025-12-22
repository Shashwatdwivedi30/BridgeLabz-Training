import java.util.Random;

public class VotingEligibility {
    // Method to generate random 2-digit ages for n students
    public static int[] generateAges(int n) {
        int[] ages = new int[n];
        Random r = new Random();

        for (int i = 0; i < n; i++) {
            ages[i] = r.nextInt(90) + 10; // Generates 2-digit age (10–99)
        }
        return ages;
    }

    // Method to check voting eligibility
    public static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            // Validate age
            if (ages[i] < 0) {
                result[i][1] = "false";
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayResult(String[][] data) {
        System.out.println("Age\tCan Vote");
        System.out.println("----------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        int numberOfStudents = 10;
        int[] ages = generateAges(numberOfStudents);
        String[][] votingStatus = checkVotingEligibility(ages);
        displayResult(votingStatus);
    }
}
