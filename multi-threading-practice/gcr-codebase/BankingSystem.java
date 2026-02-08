class BankAccount {
    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public boolean withdraw(String customer, int amount) {
        System.out.println("[" + customer + "] Attempting to withdraw " + amount);

        if (balance >= amount) {
            try { Thread.sleep(200); } catch (Exception e) {}
            balance -= amount;
            System.out.println("Transaction successful: " + customer +
                    ", Amount: " + amount + ", Balance: " + balance);
            return true;
        } else {
            System.out.println("Transaction failed (Insufficient funds): " + customer);
            return false;
        }
    }
}

class Transaction implements Runnable {
    private BankAccount account;
    private String customer;
    private int amount;

    public Transaction(BankAccount account, String customer, int amount) {
        this.account = account;
        this.customer = customer;
        this.amount = amount;
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println(t.getName() + " State BEFORE: " + t.getState());
        account.withdraw(customer, amount);
    }
}

public class BankingSystem {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(new Transaction(account, "Customer-1", 3000), "T1");
        Thread t2 = new Thread(new Transaction(account, "Customer-2", 4000), "T2");
        Thread t3 = new Thread(new Transaction(account, "Customer-3", 2000), "T3");
        Thread t4 = new Thread(new Transaction(account, "Customer-4", 5000), "T4");
        Thread t5 = new Thread(new Transaction(account, "Customer-5", 1500), "T5");

        t1.start(); t2.start(); t3.start(); t4.start(); t5.start();
    }
}
