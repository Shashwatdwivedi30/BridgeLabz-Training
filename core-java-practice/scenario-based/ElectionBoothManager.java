import java.util.Scanner;
public class ElectionBoothManager {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int votesA = 0, votesB = 0, votesC = 0;

        while (true) {
            System.out.print("\nEnter voter age (-1 to exit): ");
            int age = sc.nextInt();

            // Exit condition
            if (age == -1) {
                break;
            }

            // Eligibility check
            if (age >= 18) {
                System.out.println("Eligible to vote");
                System.out.println("Vote for a candidate:");
                System.out.println("1. Candidate A");
                System.out.println("2. Candidate B");
                System.out.println("3. Candidate C");

                int vote = sc.nextInt();

                if (vote == 1) {
                    votesA++;
                } else if (vote == 2) {
                    votesB++;
                } else if (vote == 3) {
                    votesC++;
                } else {
                    System.out.println("Invalid vote! Vote not counted.");
                }

            } else {
                System.out.println("Not eligible to vote (Age must be 18 or above)");
            }
        }

        // Final Results
        System.out.println("\n--- Election Results ---");
        System.out.println("Candidate A Votes: " + votesA);
        System.out.println("Candidate B Votes: " + votesB);
        System.out.println("Candidate C Votes: " + votesC);

        System.out.println("\nThank you for voting 🗳️");

        sc.close();
    }
}