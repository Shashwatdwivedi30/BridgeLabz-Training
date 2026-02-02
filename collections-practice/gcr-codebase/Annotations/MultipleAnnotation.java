import java.lang.annotation.*;
import java.lang.reflect.*;

// Declare repeatable container
@Retention(RetentionPolicy.RUNTIME)
@interface BugReports {
    BugReport[] value();
}

// Create repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Apply annotation multiple times
class SoftwareModule {
    @BugReport(description = "Null pointer issue in load module.")
    @BugReport(description = "Incorrect file path handling.")
    public void loadModule() {
        System.out.println("Loading module...");
    }
}

public class MultipleAnnotation {

    public static void main(String[] args) throws Exception {
        Method method = SoftwareModule.class.getMethod("loadModule");
        // Retrieve all bug reports
        BugReport[] reports = method.getAnnotationsByType(BugReport.class);
        System.out.println("Bug Reports:");
        for (BugReport report : reports) {
            System.out.println("- " + report.description());
        }
    }
}