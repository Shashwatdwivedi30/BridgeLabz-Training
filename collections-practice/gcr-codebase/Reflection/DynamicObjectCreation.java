public class DynamicObjectCreation {

public class Student {
    public Student() {
        System.out.println("Student object created!");
    }
}

public static void main(String[] args) throws Exception {
    Class<?> cls = Class.forName("Student");
    Object obj = cls.getDeclaredConstructor().newInstance();
    System.out.println("Created object: " + obj.getClass().getName());
}
}