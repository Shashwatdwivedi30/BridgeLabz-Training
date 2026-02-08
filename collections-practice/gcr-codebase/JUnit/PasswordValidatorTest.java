import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    void testValidPassword() {
        PasswordValidator pv = new PasswordValidator();
        assertTrue(pv.isValid("Strong123"));
    }

    @Test
    void testInvalidPassword() {
        PasswordValidator pv = new PasswordValidator();
        assertFalse(pv.isValid("weak"));
    }
}
