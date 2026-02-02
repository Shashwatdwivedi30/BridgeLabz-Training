import java.lang.reflect.Field;

class Person {
    private int age;

    public Person(int age) {
        this.age = age;
    }
}

public class PrivateFieldAccess {
    public static void main(String[] args) throws Exception {

        Person p = new Person(25);

        Field ageField = Person.class.getDeclaredField("age");
        ageField.setAccessible(true);  
        System.out.println("Original Age: " + ageField.get(p));
        ageField.set(p, 40);
        System.out.println("Modified Age: " + ageField.get(p));
    }
}