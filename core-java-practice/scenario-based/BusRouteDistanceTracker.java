import java.util.Scanner;
class BusRouteDistanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalDistance = 0;
        System.out.print("Enter distance added at each stop (in km): ");
        int stopDistance = sc.nextInt();
        String choice = "no";

        while (!choice.equalsIgnoreCase("yes")) {
            totalDistance += stopDistance;
            System.out.println("Bus reached a stop.");
            System.out.println("Total distance travelled: " + totalDistance + " km");

            System.out.print("Do you want to get off? (yes/no): ");
            choice = sc.next();
        }

        System.out.println("Passenger got off.");
        System.out.println("Final distance travelled: " + totalDistance + " km");
        sc.close();
    }
}
