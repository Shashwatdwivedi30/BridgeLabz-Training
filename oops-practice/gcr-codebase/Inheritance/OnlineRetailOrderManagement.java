class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered";
    }
}

public class OnlineRetailOrderManagement {
    public static void main(String[] args) {

        Order order = new Order(101, "01-01-2026");
        ShippedOrder shipped = new ShippedOrder(102, "02-01-2026", "TRK12345");
        DeliveredOrder delivered = new DeliveredOrder(103, "03-01-2026", "TRK67890", "05-01-2026");

        System.out.println("Order ID: " + order.orderId + " | Status: " + order.getOrderStatus());
        System.out.println("Order ID: " + shipped.orderId + " | Status: " + shipped.getOrderStatus());
        System.out.println("Order ID: " + delivered.orderId + " | Status: " + delivered.getOrderStatus());
    }
}
