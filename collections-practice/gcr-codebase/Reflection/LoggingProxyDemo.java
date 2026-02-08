import java.lang.reflect.*;

interface Greeting {
    void sayHello();
}

class GreetingImpl implements Greeting {
    public void sayHello() {
        System.out.println("Hello from GreetingImpl!");
    }
}

class LoggingHandler implements InvocationHandler {
    private Object obj;

    public LoggingHandler(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        System.out.println("Method Called: " + m.getName());
        return m.invoke(obj, args);
    }
}

public class LoggingProxyDemo {
    public static void main(String[] args) {
        Greeting g = new GreetingImpl();

        Greeting proxy = (Greeting) Proxy.newProxyInstance(
                GreetingImpl.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingHandler(g)
        );

        proxy.sayHello();
    }
}
