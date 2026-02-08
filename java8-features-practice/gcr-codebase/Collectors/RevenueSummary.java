import java.util.*;
import java.util.stream.*;

class Order {
    String customer;
    double amount;

    Order(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }
}

public class RevenueSummary {
    public static void main(String[] args) {
        List<Order> orders = Arrays.asList(
                new Order("John", 200.0),
                new Order("John", 150.0),
                new Order("Emma", 300.0)
        );

        Map<String, Double> revenue = orders.stream().collect(Collectors.groupingBy(o -> o.customer, Collectors.summingDouble(o -> o.amount)));

        System.out.println(revenue);
    }
}