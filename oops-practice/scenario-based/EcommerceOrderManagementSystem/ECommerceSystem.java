package EcommerceOrderManagementSystem;

public class ECommerceSystem {

    public static void main(String[] args) {

        Product product = new Product(101, "Mobile", 15000);
        Customer customer = new Customer(1, "Shashwat");

        Order order = new Order(product, customer);

        Payment payment = new CardPayment(); // Polymorphism
        order.makePayment(payment);

        order.trackOrder();
    }
}