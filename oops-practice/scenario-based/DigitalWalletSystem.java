import java.util.*;

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Wallet {
    User user;
    double balance;
    List<Transaction> transactions = new ArrayList<>();

    Wallet(User user) {
        this.user = user;
    }

    void addMoney(double amount) {
        balance += amount;
        transactions.add(new Transaction("ADD", amount));
    }

    void withdrawMoney(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amount;
        transactions.add(new Transaction("WITHDRAW", amount));
    }
}

class Transaction {
    String type;
    double amount;

    Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}

interface TransferService {
    void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException;
}

class WalletTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        from.withdrawMoney(amount);
        to.addMoney(amount);
        from.transactions.add(new Transaction("WALLET_TRANSFER", amount));
    }
}

class BankTransfer implements TransferService {
    public void transfer(Wallet from, Wallet to, double amount) throws InsufficientBalanceException {
        from.withdrawMoney(amount + 10);
        to.addMoney(amount);
        from.transactions.add(new Transaction("BANK_TRANSFER", amount));
    }
}

public class DigitalWalletSystem {
    public static void main(String[] args) {
        User u1 = new User(1, "Alice");
        User u2 = new User(2, "Bob");

        Wallet w1 = new Wallet(u1);
        Wallet w2 = new Wallet(u2);

        w1.addMoney(1000);

        TransferService walletTransfer = new WalletTransfer();
        TransferService bankTransfer = new BankTransfer();

        try {
            walletTransfer.transfer(w1, w2, 200);
            bankTransfer.transfer(w1, w2, 300);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Alice Balance: " + w1.balance);
        System.out.println("Bob Balance: " + w2.balance);
    }
}