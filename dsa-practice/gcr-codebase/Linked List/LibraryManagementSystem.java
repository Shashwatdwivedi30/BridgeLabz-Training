public class LibraryManagementSystem {

    // Node class
    static class Book {
        int bookId;
        String title;
        String author;
        String genre;
        boolean isAvailable;
        Book next;
        Book prev;

        Book(int bookId, String title, String author, String genre, boolean isAvailable) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.isAvailable = isAvailable;
            this.next = null;
            this.prev = null;
        }
    }

    static Book head = null;
    static Book tail = null;

    // Add book at beginning
    static void addAtBeginning(int id, String title, String author, String genre, boolean status) {
        Book newBook = new Book(id, title, author, genre, status);

        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add book at end
    static void addAtEnd(int id, String title, String author, String genre, boolean status) {
        Book newBook = new Book(id, title, author, genre, status);

        if (head == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Remove book by ID
    static void removeById(int id) {
        if (head == null) return;

        Book temp = head;
        while (temp != null && temp.bookId != id) {
            temp = temp.next;
        }

        if (temp == null) return;

        if (temp == head) {
            head = head.next;
            if (head != null) head.prev = null;
        } else if (temp == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    // Search by Title
    static void searchByTitle(String title) {
        Book temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                printBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    // Search by Author
    static void searchByAuthor(String author) {
        Book temp = head;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                printBook(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book not found");
    }

    // Update availability status
    static void updateAvailability(int id, boolean status) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == id) {
                temp.isAvailable = status;
                return;
            }
            temp = temp.next;
        }
    }

    // Display forward
    static void displayForward() {
        Book temp = head;
        while (temp != null) {
            printBook(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    static void displayReverse() {
        Book temp = tail;
        while (temp != null) {
            printBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    static int countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Helper method to print book
    static void printBook(Book b) {
        System.out.println(
                b.bookId + " | " +
                b.title + " | " +
                b.author + " | " +
                b.genre + " | " +
                (b.isAvailable ? "Available" : "Not Available")
        );
    }

    // Main method
    public static void main(String[] args) {

        addAtEnd(101, "Java Basics", "James", "Programming", true);
        addAtBeginning(102, "Data Structures", "Mark", "CS", true);
        addAtEnd(103, "Operating Systems", "Andrew", "CS", false);

        System.out.println("Library (Forward):");
        displayForward();

        System.out.println("\nLibrary (Reverse):");
        displayReverse();

        System.out.println("\nSearch by Title:");
        searchByTitle("Java Basics");

        updateAvailability(103, true);

        removeById(101);

        System.out.println("\nAfter Removal:");
        displayForward();

        System.out.println("\nTotal Books: " + countBooks());
    }
}