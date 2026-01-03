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
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    void displayInfo() {
        super.displayInfo(); // Display book info
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}

public class LibraryManagement {
    public static void main(String[] args) {
        Author book1 = new Author(
            "The Alchemist", 1988, "Paulo Coelho", "Brazilian novelist and lyricist"
        );

        Author book2 = new Author(
            "Harry Potter and the Sorcerer's Stone", 1997, "J.K. Rowling", "British author"
        );

        book1.displayInfo();
        System.out.println();
        book2.displayInfo();
    }
}