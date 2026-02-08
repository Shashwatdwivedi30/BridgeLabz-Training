import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.ValueSource;

public class EvenCheckerTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    void testEvenNumbers(int n) {
        EvenChecker ec = new EvenChecker();
        assertTrue(ec.isEven(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9, 11})
    void testOddNumbers(int n) {
        EvenChecker ec = new EvenChecker();
        assertFalse(ec.isEven(n));
    }
}
