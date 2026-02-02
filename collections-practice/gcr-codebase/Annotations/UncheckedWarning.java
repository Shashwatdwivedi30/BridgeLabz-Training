import java.util.ArrayList;

public class UncheckedWarning {
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        ArrayList list = new ArrayList();  // No generics = unchecked warning suppressed
        list.add("Hello");
        list.add(100);
        System.out.println(list);
    }
}