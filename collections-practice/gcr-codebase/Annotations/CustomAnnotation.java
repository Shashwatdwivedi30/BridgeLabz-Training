import java.lang.annotation.*;
import java.lang.reflect.*;

//Define custom annotation
@Retention(RetentionPolicy.RUNTIME)
@interface TaskInfo {
    String priority();
    String assignedTo();
}

//Apply annotation
class TaskManager {
    @TaskInfo(priority = "High", assignedTo = "John Doe")
    public void completeTask() {
        System.out.println("Task completed.");
    }
}

public class CustomAnnotation {
    public static void main(String[] args) throws Exception {
        Method method = TaskManager.class.getMethod("completeTask");
        // Retrieve annotation info
        TaskInfo info = method.getAnnotation(TaskInfo.class);

        System.out.println("Priority: " + info.priority());
        System.out.println("Assigned To: " + info.assignedTo());
    }
}