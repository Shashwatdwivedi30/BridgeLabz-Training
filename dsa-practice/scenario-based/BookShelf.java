import java.util.*;

public class BookShelf {
    static class Book {
        String title;
        String author;
        String isbn;

        Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }

        @Override
        public String toString() {
            return title + " by " + author + " (ISBN: " + isbn + ")";
        }
    }

    private static HashMap<String, LinkedList<Book>> library = new HashMap<>();

    private static HashSet<String> isbnSet = new HashSet<>();

    public static void addBook(String genre, Book book) {

        if (isbnSet.contains(book.isbn)) {
            System.out.println("Duplicate book not allowed: " + book.isbn);
            return;
        }

        library.putIfAbsent(genre, new LinkedList<>());
        library.get(genre).add(book);
        isbnSet.add(book.isbn);

        System.out.println("Book added to " + genre + " section: " + book.title);
    }

    public static void removeBook(String genre, String isbn) {

        if (!library.containsKey(genre)) {
            System.out.println("Genre not found");
            return;
        }

        LinkedList<Book> books = library.get(genre);
        Iterator<Book> iterator = books.iterator();

        while (iterator.hasNext()) {
            Book book = iterator.next();
            if (book.isbn.equals(isbn)) {
                iterator.remove();
                isbnSet.remove(isbn);
                System.out.println("Book borrowed: " + book.title);
                return;
            }
        }

        System.out.println("Book not found in " + genre + " section");
    }

    public static void displayLibrary() {

        if (library.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }

        System.out.println("\nLibrary Catalog:");
        for (String genre : library.keySet()) {
            System.out.println("Genre: " + genre);
            for (Book book : library.get(genre)) {
                System.out.println("  - " + book);
            }
        }
    }

    public static void main(String[] args) {

        addBook("Fiction", new Book("1984", "George Orwell", "ISBN101"));
        addBook("Fiction", new Book("Animal Farm", "George Orwell", "ISBN102"));
        addBook("Technology", new Book("Clean Code", "Robert C. Martin", "ISBN201"));
        addBook("Technology", new Book("Clean Code", "Robert C. Martin", "ISBN201"));

        displayLibrary();
        removeBook("Fiction", "ISBN101");

        displayLibrary();
    }
}