class BankAccount {
    // Access modifiers
    public int accountNumber;
    protected String accountHolder;
    private double balance;

    // Constructor
    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount(12345, "Shashwat",10000, 4.5);

        sa.displayDetails();

        // Modify balance using public method
        sa.setBalance(12000);
        System.out.println("\nUpdated Balance: " + sa.getBalance());
    }
}

// Subclass
class SavingsAccount extends BankAccount {
    double interestRate;
    SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    void displayDetails() {
        System.out.println("Account Number : " + accountNumber);   
        System.out.println("Account Holder : " + accountHolder);  
        System.out.println("Balance        : " + getBalance());  
        System.out.println("Interest Rate  : " + interestRate + "%");
    }
}