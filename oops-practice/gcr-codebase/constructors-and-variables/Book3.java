class Book {
    // Access modifiers
    public String ISBN;
    protected String title;
    private String author;

    // Constructor
    Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return author;
    }

    public static void main(String[] args) {

        EBook eb = new EBook("978-12-3456", "Java Programming", "James Gosling", "PDF");

        eb.displayDetails();

        // Modify author using public method
        eb.setAuthor("Oracle Team");
        System.out.println("\nUpdated Author: " + eb.getAuthor());
    }
}

// Subclass
class EBook extends Book {
    String format;

    EBook(String ISBN, String title, String author, String format) {
        super(ISBN, title, author);
        this.format = format;
    }

    void displayDetails() {
        System.out.println("ISBN   : " + ISBN);  
        System.out.println("Title  : " + title);  
        System.out.println("Author : " + getAuthor());
        System.out.println("Format : " + format);
    }
}