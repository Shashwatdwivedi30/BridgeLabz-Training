import java.util.Scanner;
public class FitnessTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] pushUps = new int[7];
        for (int i = 0; i < 7; i++) {
            System.out.println("Enter push up of day "+(i+1));
            pushUps[i] = sc.nextInt();
        }
        int total = 0;
        int days = 0;
        for (int count : pushUps) {
            if (count == 0) {
                continue; // skip rest day
            }
            total += count;
            days++;
        }
        double average = (double) total / days;
        System.out.println("Total Push-ups: " + total);
        System.out.println("Average Push-ups: " + average);
        sc.close();
    }
}