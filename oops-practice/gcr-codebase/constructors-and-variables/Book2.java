public class Book2 {
    // Private attributes
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Parameterized constructor
    public Book2(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true;
    }

    // Method to borrow a book
    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("Book borrowed successfully.");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }

    // Method to display book details
    public void displayBook() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + available);
    }

    public static void main(String[] args) {
        Book2 book1 = new Book2("Java Basics", "James Gosling", 499.99);

        book1.displayBook();
        System.out.println();

        book1.borrowBook();
        book1.displayBook();

        System.out.println();
        book1.borrowBook();
    }
}
