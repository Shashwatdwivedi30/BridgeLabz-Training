import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ageAmar = sc.nextInt();
        int ageAkbar = sc.nextInt();
        int ageAnthony = sc.nextInt();
        double heightAmar = sc.nextDouble();
        double heightAkbar = sc.nextDouble();
        double heightAnthony = sc.nextDouble();
        int youngestAge = Math.min(ageAmar, Math.min(ageAkbar, ageAnthony));
        String youngest = "";
        if (youngestAge == ageAmar) {
            youngest = "Amar";
        } else if (youngestAge == ageAkbar) {
            youngest = "Akbar";
        } else {
            youngest = "Anthony";
        }
        double tallestHeight = Math.max(heightAmar, Math.max(heightAkbar, heightAnthony));
        String tallest = "";
        if (tallestHeight == heightAmar) {
            tallest = "Amar";
        } else if (tallestHeight == heightAkbar) {
            tallest = "Akbar";
        } else {
            tallest = "Anthony";
        }
        System.out.println("The youngest friend is: "+youngest+" ("+youngestAge+" years old)");
        System.out.println("The tallest friend is: " + tallest+" ("+tallestHeight+" cm)");
    }
}
