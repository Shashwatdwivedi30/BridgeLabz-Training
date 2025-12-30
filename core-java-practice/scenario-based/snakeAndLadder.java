import java.util.Random;
public class snakeAndLadder {
    static final int WIN_POS = 100;
    public static void main(String[] args) {
        Random random = new Random();

        // UC1: Single player at start position 0
        int pos1 = 0;
        int diceCount = 0;

        System.out.println("Snake and Ladder Game Started");
        System.out.println("Player starts at position 0");

        // UC2–UC6: Play till winning position 100 is reached
        while (pos1 < WIN_POS) {

            // UC2: Roll the die (1 to 6)
            int die = random.nextInt(6) + 1;
            diceCount++;

            // UC3: Check for option (0-No Play, 1-Ladder, 2-Snake)
            int option = random.nextInt(3);

            if (option == 1) {
                pos1 += die;
            } else if (option == 2) {
                pos1 -= die;
            }

            // UC4: Position should not go below 0
            if (pos1 < 0)
                pos1 = 0;

            // UC5: Exact winning position check
            if (pos1 > WIN_POS)
                pos1 -= die;

            // UC6: Report position after every die roll
            System.out.println("Die: " + die + " Position: " + pos1);
        }

        System.out.println("Player won the game");
        System.out.println("Total dice rolls: " + diceCount);
        // ===================== UC7 =====================

        int p1 = 0, p2 = 0;
        int turn = 1;

        System.out.println("\nTwo Player Game Started");
        while (p1 < WIN_POS && p2 < WIN_POS) {

            int die = random.nextInt(6) + 1;
            int option = random.nextInt(3);

            if (turn == 1) {

                if (option == 1)
                    p1 += die;
                else if (option == 2)
                    p1 -= die;

                if (p1 < 0)
                    p1 = 0;
                if (p1 > WIN_POS)
                    p1 -= die;

                System.out.println("Player 1 -> Die: " + die + " Position: " + p1);

                if (option != 1)
                    turn = 2;

            } else {

                if (option == 1)
                    p2 += die;
                else if (option == 2)
                    p2 -= die;

                if (p2 < 0)
                    p2 = 0;
                if (p2 > WIN_POS)
                    p2 -= die;

                System.out.println("Player 2 -> Die: " + die + " Position: " + p2);

                if (option != 1)
                    turn = 1;
            }
        }

        if (p1 == WIN_POS)
            System.out.println("Player 1 Wins");
        else
            System.out.println("Player 2 Wins");
    }
}