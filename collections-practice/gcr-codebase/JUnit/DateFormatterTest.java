import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DateFormatterTest {

    @Test
    void testValidDate() {
        DateFormatter df = new DateFormatter();
        assertEquals("15-03-2024", df.formatDate("2024-03-15"));
    }

    @Test
    void testInvalidDate() {
        DateFormatter df = new DateFormatter();
        assertNull(df.formatDate("abcd"));
    }
}
