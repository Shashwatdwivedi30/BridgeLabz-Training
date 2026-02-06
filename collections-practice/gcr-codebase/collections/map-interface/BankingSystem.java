import java.util.*;

class WithdrawalRequest {
    String accountNo;
    int amount;

    WithdrawalRequest(String accountNo, int amount) {
        this.accountNo = accountNo;
        this.amount = amount;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        HashMap<String, Integer> accounts = new HashMap<>();
        accounts.put("A101", 500);
        accounts.put("A102", 1200);
        accounts.put("A103", 800);

        Queue<WithdrawalRequest> withdrawals = new LinkedList<>();
        withdrawals.add(new WithdrawalRequest("A102", 200));
        withdrawals.add(new WithdrawalRequest("A101", 100));
        withdrawals.add(new WithdrawalRequest("A103", 500));

        while (!withdrawals.isEmpty()) {
            WithdrawalRequest wr = withdrawals.poll();
            processWithdrawal(accounts, wr);
        }

        System.out.println("Updated Accounts: " + accounts);

        TreeMap<String, Integer> sortedByBalance =
                new TreeMap<>(Comparator.comparingInt(accounts::get));
        sortedByBalance.putAll(accounts);

        System.out.println("Sorted by Balance (TreeMap): " + sortedByBalance);
    }

    static void processWithdrawal(HashMap<String, Integer> accounts, WithdrawalRequest wr) {
        int balance = accounts.getOrDefault(wr.accountNo, 0);
        if (balance >= wr.amount) {
            accounts.put(wr.accountNo, balance - wr.amount);
            System.out.println("Processed: " + wr.accountNo + " withdrew " + wr.amount);
        } else {
            System.out.println("Insufficient funds: " + wr.accountNo);
        }
    }
}