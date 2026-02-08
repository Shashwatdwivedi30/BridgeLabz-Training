import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "John Doe")
class Book {}

public class AuthorAnnotationReflection {
    public static void main(String[] args) {
        Class<Book> cls = Book.class;

        if (cls.isAnnotationPresent(Author.class)) {
            Author a = cls.getAnnotation(Author.class);
            System.out.println("Author: " + a.name());
        }
    }
}
