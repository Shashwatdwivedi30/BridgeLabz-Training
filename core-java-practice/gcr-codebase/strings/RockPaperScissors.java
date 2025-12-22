import java.util.Scanner;

public class RockPaperScissors {

    // Method to get computer choice
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); // 0, 1, or 2
        switch (choice) {
            case 0: return "Rock";
            case 1: return "Paper";
            case 2: return "Scissors";
            default: return "Rock";
        }
    }

    // Method to find winner
    public static String findWinner(String user, String computer) {
        if (user.equalsIgnoreCase(computer)) {
            return "Draw";
        }
        if (user.equalsIgnoreCase("Rock")) {
            return computer.equalsIgnoreCase("Scissors") ? "User" : "Computer";
        } else if (user.equalsIgnoreCase("Paper")) {
            return computer.equalsIgnoreCase("Rock") ? "User" : "Computer";
        } else if (user.equalsIgnoreCase("Scissors")) {
            return computer.equalsIgnoreCase("Paper") ? "User" : "Computer";
        } else {
            return "Invalid";
        }
    }

    // Method to calculate stats
    public static String[][] calculateStats(int userWins, int computerWins, int totalGames) {
        double userPercentage = ((double) userWins / totalGames) * 100;
        double computerPercentage = ((double) computerWins / totalGames) * 100;

        String[][] stats = new String[2][3];
        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f%%", userPercentage);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f%%", computerPercentage);
        return stats;
    }

    // Method to display results
    public static void displayResults(String[][] gameResults, String[][] stats) {
        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\tComputer\tWinner");
        System.out.println("------------------------------------------");
        for (int i = 0; i < gameResults.length; i++) {
            System.out.println((i + 1) + "\t" + gameResults[i][0] + "\t" + gameResults[i][1] + "\t\t" + gameResults[i][2]);
        }

        System.out.println("\nSummary:");
        System.out.println("Player\tWins\tWinning %");
        System.out.println("--------------------------");
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + "\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of games to play:");
        int n = sc.nextInt();
        sc.nextLine();
        String[][] gameResults = new String[n][3];
        int userWins = 0;
        int computerWins = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("\nGame " + (i + 1) + ": Enter your choice (Rock, Paper, Scissors):");
            String userChoice = sc.nextLine();

            String computerChoice = getComputerChoice();
            String winner = findWinner(userChoice, computerChoice);

            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) computerWins++;

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }
        String[][] stats = calculateStats(userWins, computerWins, n);
        displayResults(gameResults, stats);
        sc.close();
    }
}