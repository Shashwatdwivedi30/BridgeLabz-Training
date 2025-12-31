class Product {
    // Instance variables
    String productName;
    double price;

    // Class variable
    static int totalProducts = 0;

    // Constructor
    Product(String name, double price) {
        this.productName = name;
        this.price = price;
        totalProducts++;
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
    }

    // Class method
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    // Main method
    public static void main(String[] args) {

        Product p1 = new Product("Pen", 10);
        Product p2 = new Product("Notebook", 50);

        p1.displayProductDetails();
        System.out.println();

        p2.displayProductDetails();
        System.out.println();

        Product.displayTotalProducts();
    }
}
