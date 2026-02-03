import java.util.*;
class CreatorStats {
    public String creatorName;
    public double[] weeklyLikes;

    public static List<CreatorStats> EngagementBoard = new ArrayList<>();

    public CreatorStats(String name, double[] likes) {
        this.creatorName = name;
        this.weeklyLikes = likes;
    }
}

public class StreamBuzz {

    public void RegisterCreator(CreatorStats record) {
        CreatorStats.EngagementBoard.add(record);
    }

    public Map<String, Integer> GetTopPostCounts(List<CreatorStats> records, double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (CreatorStats cs : records) {
            int count = 0;
            for (double likes : cs.weeklyLikes) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }

            if (count > 0) {  
                result.put(cs.creatorName, count);
            }
        }

        return result;
    }

    public double CalculateAverageLikes() {
        double total = 0;
        int count = 0;

        for (CreatorStats cs : CreatorStats.EngagementBoard) {
            for (double likes : cs.weeklyLikes) {
                total += likes;
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StreamBuzz app = new StreamBuzz();

        while (true) {
            System.out.println("\n1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                sc.nextLine(); 
                System.out.print("Enter Creator Name: ");
                String name = sc.nextLine();

                double[] likes = new double[4];
                System.out.println("Enter weekly likes (Week 1 to 4):");
                for (int i = 0; i < 4; i++) {
                    likes[i] = sc.nextDouble();
                }

                CreatorStats creator = new CreatorStats(name, likes);
                app.RegisterCreator(creator);

                System.out.println("Creator registered successfully");
            }

            else if (choice == 2) {
                System.out.print("Enter like threshold: ");
                double threshold = sc.nextDouble();

                Map<String, Integer> top = app.GetTopPostCounts(CreatorStats.EngagementBoard, threshold);

                if (top.isEmpty()) {
                    System.out.println("No top-performing posts this week");
                } else {
                    for (var entry : top.entrySet()) {
                        System.out.println(entry.getKey() + " - " + entry.getValue());
                    }
                }
            }

            else if (choice == 3) {
                double avg = app.CalculateAverageLikes();
                System.out.println("Overall average weekly likes: " + (int)avg);
            }

            else if (choice == 4) {
                System.out.println("Logging off - Keep Creating with StreamBuzz!");
                break;
            }

            else {
                System.out.println("Invalid choice, try again!");
            }
        }
    }
}