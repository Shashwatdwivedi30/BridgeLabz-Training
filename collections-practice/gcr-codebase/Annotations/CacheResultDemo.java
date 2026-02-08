import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {}

class ExpensiveOperations {
    private final Map<Integer, Long> cache = new HashMap<>();

    @CacheResult
    public long fibonacci(int n) {
        if (cache.containsKey(n)) return cache.get(n);
        long result = (n <= 1) ? n : fibonacci(n - 1) + fibonacci(n - 2);
        cache.put(n, result);
        return result;
    }
}

public class CacheResultDemo {
    public static void main(String[] args) throws Exception {
        ExpensiveOperations ops = new ExpensiveOperations();
        Method method = ExpensiveOperations.class.getMethod("fibonacci", int.class);

        long start = System.currentTimeMillis();
        System.out.println("Fibo(35): " + method.invoke(ops, 35));
        long mid = System.currentTimeMillis();
        System.out.println("Time 1: " + (mid - start) + " ms");

        System.out.println("Fibo(35): " + method.invoke(ops, 35));
        long end = System.currentTimeMillis();
        System.out.println("Time 2 (cached): " + (end - mid) + " ms");
    }
}