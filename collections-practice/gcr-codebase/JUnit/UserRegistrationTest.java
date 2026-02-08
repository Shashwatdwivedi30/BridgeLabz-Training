import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    @Test
    void testValidUser() {
        UserRegistration ur = new UserRegistration();
        assertDoesNotThrow(() -> ur.register("John", "john@gmail.com", "abcdef"));
    }

    @Test
    void testInvalidUser() {
        UserRegistration ur = new UserRegistration();
        assertThrows(IllegalArgumentException.class,
                     () -> ur.register("", "invalid", "123"));
    }
}
