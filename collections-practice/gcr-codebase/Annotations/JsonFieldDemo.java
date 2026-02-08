import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();
}

class UserProfile {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "email_id")
    private String email;

    public UserProfile(String username, String email) {
        this.username = username;
        this.email = email;
    }
}

class JsonSerializer {
    public static String toJson(Object obj) throws Exception {
        StringBuilder json = new StringBuilder("{");
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField jf = field.getAnnotation(JsonField.class);
                json.append("\"").append(jf.name()).append("\": \"")
                        .append(field.get(obj)).append("\", ");
            }
        }
        json.delete(json.length() - 2, json.length());
        json.append("}");
        return json.toString();
    }
}

public class JsonFieldDemo {
    public static void main(String[] args) throws Exception {
        UserProfile user = new UserProfile("Alice", "alice@example.com");
        System.out.println(JsonSerializer.toJson(user));
    }
}
