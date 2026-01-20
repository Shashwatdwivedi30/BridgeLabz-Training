import java.util.ArrayList;
import java.util.List;

class InvalidTimeFormatException extends Exception {
    public InvalidTimeFormatException(String message) {
        super(message);
    }
}

class CinemaTime {

    private final List<String> movieTitles = new ArrayList<>();
    private final List<String> showTimes = new ArrayList<>();

    public void addMovie(String title, String time) throws InvalidTimeFormatException {
        validateTime(time);
        movieTitles.add(title);
        showTimes.add(time);
    }

    public void searchMovie(String keyword) {
        try {
            boolean found = false;
            for (int i = 0; i < movieTitles.size(); i++) {
                if (movieTitles.get(i).contains(keyword)) {
                    System.out.println(
                        String.format("Found: %s at %s",
                            movieTitles.get(i), showTimes.get(i))
                    );
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No movie found with keyword: " + keyword);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error while searching movies.");
        }
    }

    public void displayAllMovies() {
        for (int i = 0; i < movieTitles.size(); i++) {
            System.out.println(
                String.format("Movie: %s | Time: %s",
                    movieTitles.get(i), showTimes.get(i))
            );
        }
    }

    public void printReport() {
        String[] titlesArray = movieTitles.toArray(new String[0]);
        String[] timesArray = showTimes.toArray(new String[0]);

        System.out.println("\n--- Movie Schedule Report ---");
        for (int i = 0; i < titlesArray.length; i++) {
            System.out.println(titlesArray[i] + " - " + timesArray[i]);
        }
    }

    private void validateTime(String time) throws InvalidTimeFormatException {
        if (!time.matches("\\d{2}:\\d{2}")) {
            throw new InvalidTimeFormatException("Invalid format. Use HH:MM");
        }

        String[] parts = time.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if (hour > 23 || minute > 59) {
            throw new InvalidTimeFormatException("Invalid time value: " + time);
        }
    }
}

public class CinemaTimeMain {

    public static void main(String[] args) {

        CinemaTime cinema = new CinemaTime();

        try {
            cinema.addMovie("Inception", "18:30");
            cinema.addMovie("Interstellar", "21:00");
            cinema.addMovie("Avatar", "25:99"); 
        } catch (InvalidTimeFormatException e) {
            System.out.println(e.getMessage());
        }

        cinema.displayAllMovies();

        System.out.println();
        cinema.searchMovie("Inter");

        cinema.printReport();
    }
}