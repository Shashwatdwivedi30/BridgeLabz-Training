import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        try {
            MaxLength max = this.getClass().getDeclaredField("username").getAnnotation(MaxLength.class);
            if (username.length() > max.value()) {
                throw new IllegalArgumentException("Username too long! Max: " + max.value());
            }
            this.username = username;
            System.out.println("User created: " + username);
        } catch (Exception e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }
}

public class MaxLengthDemo {
    public static void main(String[] args) {
        new User("John");
        new User("VeryLongUsername");
    }
}
