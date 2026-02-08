import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "OLD_KEY";
}

public class StaticFieldReflection {
    public static void main(String[] args) throws Exception {
        Class<Configuration> cls = Configuration.class;

        Field field = cls.getDeclaredField("API_KEY");
        field.setAccessible(true);

        System.out.println("Old API_KEY: " + field.get(null));

        field.set(null, "NEW_SECRET_KEY");

        System.out.println("Updated API_KEY: " + field.get(null));
    }
}
