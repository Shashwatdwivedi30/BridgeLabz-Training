import java.lang.reflect.Field;

class Student {
    public String name = "John";
    public int marks = 90;
}

public class ObjectToJsonReflection {

    public static String toJson(Object obj) throws Exception {
        StringBuilder sb = new StringBuilder("{");

        Class<?> cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);

            sb.append("\"").append(f.getName()).append("\":");
            sb.append("\"").append(f.get(obj)).append("\"");

            if (i < fields.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Student s = new Student();
        System.out.println(toJson(s));
    }
}
