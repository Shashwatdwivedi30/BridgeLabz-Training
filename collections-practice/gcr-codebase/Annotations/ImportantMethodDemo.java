import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class TaskManager {
    @ImportantMethod(level = "CRITICAL")
    public void startTask() {
        System.out.println("Starting task...");
    }

    @ImportantMethod
    public void stopTask() {
        System.out.println("Stopping task...");
    }

    public void helper() {}
}

public class ImportantMethodDemo {
    public static void main(String[] args) {
        Method[] methods = TaskManager.class.getDeclaredMethods();
        System.out.println("Important Methods:");
        for (Method m : methods) {
            if (m.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod imp = m.getAnnotation(ImportantMethod.class);
                System.out.println(m.getName() + " - Level: " + imp.level());
            }
        }
    }
}
