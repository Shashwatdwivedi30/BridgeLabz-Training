class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie next;
    Movie prev;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = this.prev = null;
    }
}

public class MovieList {
    static Movie head, tail;

    // Add at end
    static void add(String title, String director, int year, double rating) {
        Movie movie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = movie;
            return;
        }
        tail.next = movie;
        movie.prev = tail;
        tail = movie;
    }

    // Add at beginning
    static void addAtBeginning(String title, String director, int year, double rating) {
        Movie movie = new Movie(title, director, year, rating);
        movie.next = head;
        if (head != null)
            head.prev = movie;
        head = movie;
        if (tail == null)
            tail = movie;
    }

    // Remove by movie title
    static void remove(String title) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                if (temp.prev != null)
                    temp.prev.next = temp.next;
                else
                    head = temp.next;

                if (temp.next != null)
                    temp.next.prev = temp.prev;
                else
                    tail = temp.prev;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found");
    }

    // Search by director
    static void searchByDirector(String director) {
        Movie temp = head;
        while (temp != null) {
            if (temp.director.equals(director))
                System.out.println(temp.title);
            temp = temp.next;
        }
    }

    // Search by rating
    static void searchByRating(double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.rating >= rating)
                System.out.println(temp.title);
            temp = temp.next;
        }
    }

    // Update rating by title
    static void updateRating(String title, double rating) {
        Movie temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = rating;
                return;
            }
            temp = temp.next;
        }
    }

    // Display forward
    static void displayForward() {
        Movie temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " +
                               temp.year + " " + temp.rating);
            temp = temp.next;
        }
    }

    // Display reverse
    static void displayReverse() {
        Movie temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " +
                               temp.year + " " + temp.rating);
            temp = temp.prev;
        }
    }

    public static void main(String[] args) {
        add("Inception", "Nolan", 2010, 8.8);
        add("Interstellar", "Nolan", 2014, 8.6);
        addAtBeginning("Avatar", "Cameron", 2009, 7.9);

        displayForward();
        System.out.println("Reverse:");
        displayReverse();

        updateRating("Avatar", 8.1);
        remove("Inception");

        System.out.println("Updated rating:");
        displayForward();
    }
}