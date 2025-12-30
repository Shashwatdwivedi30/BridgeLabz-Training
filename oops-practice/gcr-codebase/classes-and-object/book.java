import java.util.Scanner;
class book {
    String title;
    String author;
    double price;

    void display() {
        System.out.println("Title of the book: " + title);
        System.out.println("Author of the book: " + author);
        System.out.println("Price of the book: " + price);
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First Book
        book b1 = new book();
        System.out.print("Enter book title: ");
        b1.title = sc.nextLine();

        System.out.print("Enter author name: ");
        b1.author = sc.nextLine();

        System.out.print("Enter book price: ");
        b1.price = sc.nextDouble();
        sc.nextLine(); 

        b1.display();
        sc.close();
    }
}
