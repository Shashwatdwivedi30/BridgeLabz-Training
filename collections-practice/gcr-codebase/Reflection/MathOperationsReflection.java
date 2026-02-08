import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {
    public int add(int a, int b) { return a + b; }
    public int subtract(int a, int b) { return a - b; }
    public int multiply(int a, int b) { return a * b; }
}

public class MathOperationsReflection {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        MathOperations obj = new MathOperations();

        System.out.print("Enter method name (add / subtract / multiply): ");
        String methodName = sc.nextLine();

        System.out.print("Enter first number: ");
        int x = sc.nextInt();

        System.out.print("Enter second number: ");
        int y = sc.nextInt();

        Method m = MathOperations.class.getMethod(methodName, int.class, int.class);
        Object result = m.invoke(obj, x, y);

        System.out.println("Result: " + result);
    }
}
