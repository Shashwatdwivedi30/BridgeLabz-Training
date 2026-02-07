import java.util.*;

class Movie {
    String name;
    double rating;
    int year;

    Movie(String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }
}

public class Top5TrendingMovies {
    public static void main(String[] args) {

        List<Movie> movies = Arrays.asList(
                new Movie("A", 8.5, 2020),
                new Movie("B", 7.2, 2016),
                new Movie("C", 9.1, 2018),
                new Movie("D", 8.9, 2019),
                new Movie("E", 6.5, 2014),
                new Movie("F", 9.0, 2021)
        );

        movies.stream()
                .filter(m -> m.year >= 2015)
                .sorted((m1, m2) -> Double.compare(m2.rating, m1.rating))
                .limit(5)
                .forEach(m -> System.out.println(m.name + " - " + m.rating));
    }
}