import java.util.Scanner;

class Book {

    // Static variable
    static String libraryName = "Egmore Library";

    // Instance variables
    String title;
    String author;

    final String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        Object obj = new Book(title, author, isbn);

        System.out.println();
        Book.displayLibraryName();

        // instanceof check
        if (obj instanceof Book) {
            Book book = (Book) obj;
            book.displayBookDetails();
        } else {
            System.out.println("Object is not a Book instance");
        }
        sc.close();
    }
}