import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DivisionTest {

    @Test
    void testDivideByZero() {
        Division d = new Division();
        assertThrows(ArithmeticException.class, () -> d.divide(10, 0));
    }

    @Test
    void testValidDivision() {
        Division d = new Division();
        assertEquals(5, d.divide(10, 2));
    }
}
