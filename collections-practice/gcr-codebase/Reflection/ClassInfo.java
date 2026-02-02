import java.lang.reflect.*;

public class ClassInfo {
    public static void main(String[] args) throws Exception {

        // Input: class name
        System.out.println("Enter class name:");
        String className = new java.util.Scanner(System.in).nextLine();

        // Load class
        Class<?> cls = Class.forName(className);

        // Display methods
        System.out.println("\n--- Methods ---");
        for (Method m : cls.getDeclaredMethods()) {
            System.out.println(m);
        }

        // Display fields
        System.out.println("\n--- Fields ---");
        for (Field f : cls.getDeclaredFields()) {
            System.out.println(f);
        }

        // Display constructors
        System.out.println("\n--- Constructors ---");
        for (Constructor<?> c : cls.getDeclaredConstructors()) {
            System.out.println(c);
        }
    }
}