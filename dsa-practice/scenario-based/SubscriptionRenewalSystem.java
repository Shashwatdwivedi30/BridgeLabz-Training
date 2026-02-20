import java.time.LocalDate;
import java.util.*;

class PaymentDeclinedException extends Exception {
    public PaymentDeclinedException(String msg) {
        super(msg);
    }
}

interface DiscountStrategy{
    double applyDiscount(double price);
}

class NoDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double price){
        return price;
    }
}

class SeasonalDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double price){
        return price * 0.90;
    }
}

class LoyalCustomerDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double price){
        return price * 0.80;
    }
}

class User{
    private String username;
    private LocalDate expiryDate;
    private double basePrice;
    private boolean active;
    private DiscountStrategy discountStrategy;

    public User(String username, double basePrice, LocalDate expiryDate, DiscountStrategy ds) {
        this.username = username;
        this.basePrice = basePrice;
        this.expiryDate = expiryDate;
        this.active = true;
        this.discountStrategy = ds;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        this.active = false;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void renew(){
        this.expiryDate = this.expiryDate.plusMonths(1);
        this.active = true;
    }
}

class SubscriptionProcessor{
    private List<User> users = new ArrayList<>();
    public void addUser(User user){
        users.add(user);
    }

    public List<User> getExpiredUsers(){
        LocalDate today = LocalDate.now();
        List<User> expired = new ArrayList<>();

        for(User u : users){
            if(u.getExpiryDate().isBefore(today)){
                expired.add(u);
            }
        }
        return expired;
    }

    public void autoRenewAll() throws PaymentDeclinedException{
        for(User u : users){
            if(u.isActive()){
                processRenewal(u);
            }
        }
    }

    private void processRenewal(User user) throws PaymentDeclinedException{
        double discountedPrice = user.getDiscountStrategy().applyDiscount(user.getBasePrice());

        if(!processPayment(user.getUsername(), discountedPrice)){
            throw new PaymentDeclinedException("Payment failed for " +user.getUsername());
        }

        user.renew();
        System.out.println("Renewed subscription for " + user.getUsername() + " | Amount charged: ₹" + discountedPrice);
    }

    private boolean processPayment(String username, double amount){
        return Math.random() > 0.1;
    }
}

public class SubscriptionRenewalSystem{
    public static void main(String[] args) {
        SubscriptionProcessor processor = new SubscriptionProcessor();

        processor.addUser(new User(
                "john",
                399,
                LocalDate.now().minusDays(1),   // expired
                new LoyalCustomerDiscount()
        ));

        processor.addUser(new User(
                "emma",
                499,
                LocalDate.now().plusDays(5),
                new SeasonalDiscount()
        ));

        processor.addUser(new User(
                "alex",
                299,
                LocalDate.now().plusDays(10),
                new NoDiscount()
        ));

        System.out.println("Expired Accounts:");
        processor.getExpiredUsers().forEach(u -> System.out.println(u.getUsername()));

        try {
            processor.autoRenewAll();
        } catch (PaymentDeclinedException e) {
            System.err.println(e.getMessage());
        }
    }
}