import java.lang.reflect.Field;
import java.util.Map;

class Person {
    public String name;
    public int age;
}

public class ObjectMapperReflection {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> props) throws Exception {
        T obj = clazz.getDeclaredConstructor().newInstance();

        for (Field f : clazz.getDeclaredFields()) {
            if (props.containsKey(f.getName())) {
                f.setAccessible(true);
                f.set(obj, props.get(f.getName()));
            }
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        Map<String, Object> map = Map.of("name", "Alice", "age", 22);

        Person p = toObject(Person.class, map);

        System.out.println(p.name + " - " + p.age);
    }
}
