import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {

    @Test
    void testCtoF() {
        TemperatureConverter tc = new TemperatureConverter();
        assertEquals(77, tc.cToF(25), 0.01);
    }

    @Test
    void testFtoC() {
        TemperatureConverter tc = new TemperatureConverter();
        assertEquals(25, tc.fToC(77), 0.01);
    }
}
