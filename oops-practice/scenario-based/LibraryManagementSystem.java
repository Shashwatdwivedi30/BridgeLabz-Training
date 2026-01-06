import java.util.*;
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String msg) {
        super(msg);
    }
}

class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }
}

public class LibraryManagementSystem {

    public static void displayBooks(List<Book> books) {
        System.out.println("\n--- Library Books ---");
        for (Book b : books) {
            String status = b.isAvailable ? "Available" : "Checked Out";
            System.out.println(b.title + " | " + b.author + " | " + status);
        }
    }

    public static void searchBook(List<Book> books, String searchTitle) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.toLowerCase().contains(searchTitle.toLowerCase())) {
                System.out.println("Found: " + b.title + " by " + b.author);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No book found with given title.");
        }
    }

    public static void checkoutBook(List<Book> books, String title)
            throws BookNotAvailableException {

        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                if (!b.isAvailable) {
                    throw new BookNotAvailableException("Book is already checked out");
                }
                b.isAvailable = false;
                System.out.println("Book checked out successfully.");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        Book[] bookArray = {
            new Book("Java Programming", "James Gosling", true),
            new Book("Python Basics", "Guido van Rossum", true),
            new Book("Data Structures", "Mark Allen", false)
        };

        List<Book> books = new ArrayList<>();
        for (Book b : bookArray) {
            books.add(b);
        }

        Scanner sc = new Scanner(System.in);
        displayBooks(books);

        System.out.print("\nEnter title to search: ");
        String search = sc.nextLine();
        searchBook(books, search);

        try {
            System.out.print("\nEnter exact title to checkout: ");
            String checkoutTitle = sc.nextLine();
            checkoutBook(books, checkoutTitle);
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }

        displayBooks(books);
    }
}