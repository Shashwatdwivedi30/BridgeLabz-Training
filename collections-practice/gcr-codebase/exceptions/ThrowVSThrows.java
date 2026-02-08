public class ThrowVSThrows {
    public static void main(String[] args) {

        try {
            double amount = 10000;
            double rate = 0.05;
            int years = 3;

            if (amount < 0 || rate < 0)
                throw new IllegalArgumentException();

            double interest = amount * rate * years;
            System.out.println("Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}