import java.util.*;

class InvalidRatingException extends Exception {
    public InvalidRatingException(String msg) {
        super(msg);
    }
}

class EventFeedbackManager {
    private Map<String, List<Integer>> feedbackMap = new HashMap<>();

    public void addFeedback(String eventId, int rating) throws InvalidRatingException {
        if (rating < 1 || rating > 5) {
            throw new InvalidRatingException("Rating must be between 1 and 5: " + rating);
        }

        feedbackMap.putIfAbsent(eventId, new ArrayList<>());
        feedbackMap.get(eventId).add(rating);
    }

    public double getAverageRating(String eventId) {
        List<Integer> ratings = feedbackMap.get(eventId);
        if (ratings == null || ratings.isEmpty()) return 0.0;

        int sum = 0;
        for (int r : ratings) sum += r;
        return (double) sum / ratings.size();
    }

    public List<String> getTopRatedEvents() {
        double highestAvg = 0.0;
        List<String> topEvents = new ArrayList<>();

        for (String eventId : feedbackMap.keySet()) {
            double avg = getAverageRating(eventId);

            if (avg > highestAvg) {
                highestAvg = avg;
                topEvents.clear();
                topEvents.add(eventId);
            } else if (avg == highestAvg) {
                topEvents.add(eventId);
            }
        }
        return topEvents;
    }

    public Map<String, List<Integer>> getFeedbackMap() {
        return feedbackMap;
    }
}

public class EventFeedbackAnalyzer {
    public static void main(String[] args) {
        try {
            EventFeedbackManager manager = new EventFeedbackManager();

            manager.addFeedback("EVT100", 5);
            manager.addFeedback("EVT100", 4);
            manager.addFeedback("EVT200", 3);
            manager.addFeedback("EVT200", 5);
            manager.addFeedback("EVT300", 5);
            manager.addFeedback("EVT300", 5);

            System.out.println("Average Ratings:");
            for (String eventId : manager.getFeedbackMap().keySet()) {
                System.out.println(eventId + " → " + manager.getAverageRating(eventId));
            }

            System.out.println("\nTop Rated Events:");
            for (String eventId : manager.getTopRatedEvents()) {
                System.out.println(eventId + " (Avg: " + manager.getAverageRating(eventId) + ")");
            }

            // Invalid rating test
            // manager.addFeedback("EVT100", 10);

        } catch (InvalidRatingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}