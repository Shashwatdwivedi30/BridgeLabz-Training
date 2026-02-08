import java.util.*;

interface Observer {
    void update(String msg);
}

class LibraryCatalog {
    private static LibraryCatalog instance;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private LibraryCatalog() {}

    public static synchronized LibraryCatalog getInstance() {
        if (instance == null) instance = new LibraryCatalog();
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        newBookArrived(book.getTitle());
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    private void newBookArrived(String bookName) {
        for (Observer o : observers) {
            o.update("New book available: " + bookName);
        }
    }
}

interface User extends Observer {
    void showRole();
}

class Student implements User {
    private String name;

    public Student(String name) { this.name = name; }

    public void showRole() {
        System.out.println(name + " is a Student.");
    }

    public void update(String msg) {
        System.out.println(name + " notified: " + msg);
    }
}

class Faculty implements User {
    private String name;

    public Faculty(String name) { this.name = name; }

    public void showRole() {
        System.out.println(name + " is a Faculty.");
    }

    public void update(String msg) {
        System.out.println(name + " notified: " + msg);
    }
}

class Librarian implements User {
    private String name;

    public Librarian(String name) { this.name = name; }

    public void showRole() {
        System.out.println(name + " is a Librarian.");
    }

    public void update(String msg) {
        System.out.println(name + " notified: " + msg);
    }
}

class UserFactory {
    public static User createUser(String type, String name) {
        switch (type.toLowerCase()) {
            case "student": return new Student(name);
            case "faculty": return new Faculty(name);
            case "librarian": return new Librarian(name);
            default: throw new IllegalArgumentException("Unknown user type");
        }
    }
}

class Book {
    private String title;
    private String author;
    private String edition;
    private String genre;

    private Book(BookBuilder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.edition = builder.edition;
        this.genre = builder.genre;
    }

    public String getTitle() { return title; }

    public static class BookBuilder {
        private String title;
        private String author;
        private String edition;
        private String genre;

        public BookBuilder(String title) {
            this.title = title;
        }
        public BookBuilder author(String author) {
            this.author = author; return this;
        }
        public BookBuilder edition(String edition) {
            this.edition = edition; return this;
        }
        public BookBuilder genre(String genre) {
            this.genre = genre; return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {

        // singleton
        LibraryCatalog catalog = LibraryCatalog.getInstance();

        //factory
        User student = UserFactory.createUser("student", "Alice");
        User faculty = UserFactory.createUser("faculty", "Dr. Bob");

        student.showRole();
        faculty.showRole();

        // registration
        catalog.addObserver(student);
        catalog.addObserver(faculty);

        // Builder
        Book book1 = new Book.BookBuilder("Design Patterns")
            .author("GoF")
            .edition("2nd")
            .genre("Software Engineering")
            .build();

        catalog.addBook(book1);
    }
}