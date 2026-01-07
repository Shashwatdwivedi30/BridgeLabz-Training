import java.util.*;

// Custom Exception
class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

// Abstraction
interface BankService {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientBalanceException;
    double calculateInterest();
    double getBalance();
}

// Base Class
abstract class Account implements BankService {
    int accountNumber;
    String holderName;
    protected double balance;
    List<String> transactionHistory = new ArrayList<>();

    public Account(int accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // synchronized to handle concurrent access
    public synchronized void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited " + amount);
    }

    public synchronized void withdraw(double amount)
            throws InsufficientBalanceException {

        if (balance < amount) {
            throw new InsufficientBalanceException("Insufficient Balance!");
        }
        balance -= amount;
        transactionHistory.add("Withdrawn " + amount);
    }

    public double getBalance() {
        return balance;
    }

    public void showTransactionHistory() {
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }
}

// Inheritance + Polymorphism
class SavingsAccount extends Account {

    public SavingsAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return balance * 0.04; // 4% interest
    }
}

class CurrentAccount extends Account {

    public CurrentAccount(int accNo, String name, double balance) {
        super(accNo, name, balance);
    }

    @Override
    public double calculateInterest() {
        return 0; // No interest
    }
}

// Multithreading
class TransferTask extends Thread {
    Account fromAccount;
    Account toAccount;
    double amount;

    public TransferTask(Account from, Account to, double amount) {
        this.fromAccount = from;
        this.toAccount = to;
        this.amount = amount;
    }

    public void run() {
        synchronized (fromAccount) {
            synchronized (toAccount) {
                try {
                    fromAccount.withdraw(amount);
                    toAccount.deposit(amount);
                    System.out.println("Transferred " + amount +
                            " from " + fromAccount.holderName +
                            " to " + toAccount.holderName);
                } catch (InsufficientBalanceException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

// Main Class
public class OnlineBankingSystem {
    public static void main(String[] args) {

        // Account creation
        Account acc1 = new SavingsAccount(101, "Shashwat", 5000);
        Account acc2 = new CurrentAccount(102, "Aviral", 8000);

        // Concurrent fund transfers
        Thread t1 = new TransferTask(acc1, acc2, 2000);
        Thread t2 = new TransferTask(acc1, acc2, 1000);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Balance check
        System.out.println("\n--- Account Summary ---");
        System.out.println(acc1.holderName + " Balance: " + acc1.getBalance());
        System.out.println("Interest: " + acc1.calculateInterest());

        System.out.println(acc2.holderName + " Balance: " + acc2.getBalance());
        System.out.println("Interest: " + acc2.calculateInterest());

        // Transaction history
        System.out.println("\n--- Transaction History (Savings Account) ---");
        acc1.showTransactionHistory();
    }
}