import java.util.Scanner;
class bankAccount {
    String accountHolder;
    String accountNumber;
    double balance;

    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        displayBalance();
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            System.out.println("Withdraw amount is : " + amount);
            displayBalance();
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bankAccount acc = new bankAccount();

        System.out.print("Enter Account Holder Name: ");
        acc.accountHolder = sc.nextLine();

        System.out.print("Enter Account Number: ");
        acc.accountNumber = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        acc.balance = sc.nextDouble();

        System.out.println("\n\t\t\t" + acc.accountHolder);
        acc.displayBalance();

        System.out.print("\nEnter deposit amount: ");
        double dep = sc.nextDouble();
        acc.deposit(dep);

        System.out.print("\nEnter withdraw amount: ");
        double wit = sc.nextDouble();
        acc.withdraw(wit);
        sc.close();
    }
}