package EcommerceOrderManagementSystem;

public class Order {

    Product product;
    Customer customer;
    String status;

    public Order(Product product, Customer customer) {
        this.product = product;
        this.customer = customer;
        this.status = "Order Placed";
    }

    public void makePayment(Payment payment) {
        try {
            payment.pay(product.price);
            status = "Payment Successful";
        } catch (PaymentFailedException e) {
            status = "Payment Failed";
            System.out.println(e.getMessage());
        }
    }

    public void cancelOrder() {
        status = "Order Cancelled";
        System.out.println("Order cancelled");
    }

    public void trackOrder() {
        System.out.println("Order Status: " + status);
    }
}