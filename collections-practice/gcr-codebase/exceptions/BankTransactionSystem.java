class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String msg) {
        super(msg);
    }
}

public class BankTransactionSystem {
    public static void main(String[] args) {

        double balance = 5000;

        try {
            double amount = 6000;

            if (amount < 0)
                throw new IllegalArgumentException("Invalid amount!");

            if (amount > balance)
                throw new InsufficientBalanceException("Insufficient balance!");

            balance -= amount;
            System.out.println("Withdrawal successful, new balance: " + balance);

        } catch (InsufficientBalanceException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}