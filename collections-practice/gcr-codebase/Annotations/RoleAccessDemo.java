import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class AdminService {
    @RoleAllowed("ADMIN")
    public void deleteUser() {
        System.out.println("User deleted!");
    }
}

public class RoleAccessDemo {
    public static void main(String[] args) throws Exception {
        String currentUser = "USER";
        AdminService service = new AdminService();
        Method method = AdminService.class.getMethod("deleteUser");
        RoleAllowed role = method.getAnnotation(RoleAllowed.class);
        if (!currentUser.equals(role.value())) {
            System.out.println("Access Denied!");
        } else {
            method.invoke(service);
        }
    }
}
