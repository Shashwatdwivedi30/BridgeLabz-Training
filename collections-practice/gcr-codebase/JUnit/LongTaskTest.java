import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class LongTaskTest {

    @Test
    @Timeout(value = 2, unit = TimeUnit.SECONDS)
    void testTimeoutFailure() {
        LongTask lt = new LongTask();
        lt.longRunningTask();   // Should fail (takes 3 seconds)
    }
}
