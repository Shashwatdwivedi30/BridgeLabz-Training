import java.util.*;
import java.util.stream.*;

class Book {
    String genre;
    int pages;

    Book(String g, int p) {
        genre = g; pages = p;
    }
}

public class BookStats {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Fiction", 300),
                new Book("Fiction", 250),
                new Book("Science", 500),
                new Book("Science", 450)
        );
        Map<String, IntSummaryStatistics> stats = books.stream().collect(Collectors.groupingBy(b -> b.genre, Collectors.summarizingInt(b -> b.pages)));

        System.out.println(stats);
    }
}