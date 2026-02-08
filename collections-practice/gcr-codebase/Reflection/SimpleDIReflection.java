import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Inject {}

class Service {
    public void serve() {
        System.out.println("Service is serving...");
    }
}

class Client {
    @Inject
    private Service service;

    public void doWork() {
        service.serve();
    }
}

public class SimpleDIReflection {

    public static void injectDependencies(Object obj) throws Exception {
        for (Field f : obj.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(Inject.class)) {

                Object dependency = f.getType().getDeclaredConstructor().newInstance();

                f.setAccessible(true);
                f.set(obj, dependency);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        injectDependencies(client);
        client.doWork();
    }
}
