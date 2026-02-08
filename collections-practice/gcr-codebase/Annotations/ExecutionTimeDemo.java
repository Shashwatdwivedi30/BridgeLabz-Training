pimport java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {}

class PerformanceTest {
    @LogExecutionTime
    public void fastMethod() {
        for (int i = 0; i < 1000000; i++);
    }

    @LogExecutionTime
    public void slowMethod() {
        for (int i = 0; i < 5000000; i++);
    }
}

public class ExecutionTimeDemo {
    public static void main(String[] args) throws Exception {
        PerformanceTest pt = new PerformanceTest();
        Method[] methods = PerformanceTest.class.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(LogExecutionTime.class)) {
                long start = System.nanoTime();
                m.invoke(pt);
                long end = System.nanoTime();
                System.out.println(m.getName() + " took " + (end - start) + " ns");
            }
        }
    }
}
