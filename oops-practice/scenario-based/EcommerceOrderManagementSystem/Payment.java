package EcommerceOrderManagementSystem;

// Payment interface
public interface Payment {
    void pay(double amount) throws PaymentFailedException;
}

// Custom Exception
class PaymentFailedException extends Exception {
    PaymentFailedException(String message) {
        super(message);
    }
}

// Card Payment
class CardPayment implements Payment {
    public void pay(double amount) throws PaymentFailedException {
        if (amount <= 0) {
            throw new PaymentFailedException("Invalid payment amount");
        }
        System.out.println("Paid ₹" + amount + " using Card");
    }
}

// UPI Payment
class UPIPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}

// Wallet Payment
class WalletPayment implements Payment {
    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Wallet");
    }
}