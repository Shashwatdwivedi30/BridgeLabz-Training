import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectTasks {
    @Todo(task = "Implement login", assignedTo = "Alice", priority = "HIGH")
    public void loginFeature() {}

    @Todo(task = "Add payment gateway", assignedTo = "Bob")
    public void paymentFeature() {}

    public void finishedTask() {}
}

public class TodoDemo {
    public static void main(String[] args) {
        Method[] methods = ProjectTasks.class.getDeclaredMethods();
        System.out.println("Pending Tasks:");
        for (Method m : methods) {
            if (m.isAnnotationPresent(Todo.class)) {
                Todo t = m.getAnnotation(Todo.class);
                System.out.println(m.getName() + " → Task: " + t.task() +
                        ", Assigned to: " + t.assignedTo() +
                        ", Priority: " + t.priority());
            }
        }
    }
}
