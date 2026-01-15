import java.util.*;

class PetrolPump {
    int petrol;
    int distance;

    PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int findStartingPump(PetrolPump[] pumps) {
        Queue<Integer> queue = new LinkedList<>();
        int currentPetrol = 0;
        int start = 0;

        for (int i = 0; i < pumps.length; i++) {
            queue.offer(i);
            currentPetrol += pumps[i].petrol - pumps[i].distance;

            while (currentPetrol < 0 && !queue.isEmpty()) {
                int removed = queue.poll();
                currentPetrol -= pumps[removed].petrol - pumps[removed].distance;
                start = removed + 1;
            }
        }

        return (queue.size() == pumps.length) ? start : -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        PetrolPump[] pumps = new PetrolPump[n];

        System.out.println("Enter petrol and distance for each pump:");
        for (int i = 0; i < n; i++) {
            int petrol = sc.nextInt();
            int distance = sc.nextInt();
            pumps[i] = new PetrolPump(petrol, distance);
        }

        int start = findStartingPump(pumps);

        if (start == -1) {
            System.out.println("No possible tour");
        } else {
            System.out.println("Start at petrol pump index: " + start);
        }

        sc.close();
    }
}