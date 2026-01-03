class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

class Author extends Book {
    String authorName;
    String bio;

    Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear);
        this.authorName = authorName;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + authorName);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {

        Author book1 = new Author(
                "Effective Java",
                2018,
                "Joshua Bloch",
                "Expert in Java and software design"
        );
        book1.displayInfo();
    }
}