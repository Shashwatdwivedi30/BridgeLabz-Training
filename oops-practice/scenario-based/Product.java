import java.util.Scanner;
public class Product {
    static double discount = 10.0;
    static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }
    final String productID;
    String productName;
    double price;
    int quantity;

    Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    double getDiscountedPrice() {
        return price - (price * discount / 100);
    }

    void displayProduct(Object obj) {
        if (obj instanceof Product) {
            Product p = (Product) obj;
            System.out.println("Product ID: " + p.productID);
            System.out.println("Product Name: " + p.productName);
            System.out.println("Price: $" + p.price);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("Price after Discount: $" + p.getDiscountedPrice());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product 1 ID: ");
        String id1 = sc.nextLine();
        System.out.print("Enter Product 1 Name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Product 1 Price: ");
        double price1 = sc.nextDouble();
        System.out.print("Enter Product 1 Quantity: ");
        int qty1 = sc.nextInt();
        sc.nextLine();
        Product p1 = new Product(id1, name1, price1, qty1);

        System.out.print("Enter Product 2 ID: ");
        String id2 = sc.nextLine();
        System.out.print("Enter Product 2 Name: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Product 2 Price: ");
        double price2 = sc.nextDouble();
        System.out.print("Enter Product 2 Quantity: ");
        int qty2 = sc.nextInt();
        Product p2 = new Product(id2, name2, price2, qty2);

        System.out.println();
        p1.displayProduct(p1);

        System.out.println();
        p2.displayProduct(p2);

        sc.close();
    }
}