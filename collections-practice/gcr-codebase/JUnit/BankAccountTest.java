import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BankAccountTest {

    @Test
    void testDeposit() {
        BankAccount b = new BankAccount();
        b.deposit(200);
        assertEquals(200, b.getBalance());
    }

    @Test
    void testWithdraw() {
        BankAccount b = new BankAccount();
        b.deposit(300);
        b.withdraw(100);
        assertEquals(200, b.getBalance());
    }

    @Test
    void testInsufficientFunds() {
        BankAccount b = new BankAccount();
        b.deposit(100);

        assertThrows(IllegalArgumentException.class,
                     () -> b.withdraw(200));
    }
}
