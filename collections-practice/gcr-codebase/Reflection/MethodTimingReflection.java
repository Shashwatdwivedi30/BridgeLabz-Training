import java.lang.reflect.Method;

class Task {
    public void fast() { System.out.println("Fast executed"); }
    public void slow() { 
        try { Thread.sleep(1000); } catch (Exception e) {}
        System.out.println("Slow executed"); 
    }
}

public class MethodTimingReflection {

    public static void measureTime(Object obj, String methodName) throws Exception {
        Method m = obj.getClass().getMethod(methodName);

        long start = System.currentTimeMillis();
        m.invoke(obj);
        long end = System.currentTimeMillis();

        System.out.println(methodName + " took: " + (end - start) + " ms");
    }

    public static void main(String[] args) throws Exception {
        Task t = new Task();

        measureTime(t, "fast");
        measureTime(t, "slow");
    }
}
