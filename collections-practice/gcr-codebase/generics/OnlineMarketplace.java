import java.util.*;

interface Category {
    String getName();
}

class BookCategory implements Category {
    public String getName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getName() {
        return "Gadgets";
    }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class DiscountUtil {
    public static <T extends Product<?>> void applyDiscount(T product, double percent) {
        double discount = product.getPrice() * percent / 100;
        product.setPrice(product.getPrice() - discount);
    }
}

class ProductCatalog {
    private List<Product<? extends Category>> products = new ArrayList<>();

    public void addProduct(Product<? extends Category> product) {
        products.add(product);
    }

    public void showProducts() {
        for (Product<? extends Category> p : products) {
            System.out.println(
                p.getName() + " | " +
                p.getCategory().getName() + " | ₹" +
                p.getPrice()
            );
        }
    }
}

public class OnlineMarketplace {
    public static void main(String[] args) {

        Product<BookCategory> book =
                new Product<>("Java Programming", 500, new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("T-Shirt", 1200, new ClothingCategory());

        Product<GadgetCategory> phone =
                new Product<>("Smartphone", 20000, new GadgetCategory());

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(shirt, 20);
        DiscountUtil.applyDiscount(phone, 5);

        ProductCatalog catalog = new ProductCatalog();
        catalog.addProduct(book);
        catalog.addProduct(shirt);
        catalog.addProduct(phone);

        catalog.showProducts();
    }
}