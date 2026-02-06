import java.util.*;

class Employee {
    String name;
    String department;

    Employee(String name, String dept) {
        this.name = name;
        this.department = dept;
    }

    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> map = new HashMap<>();

        for (Employee e : employees) {
            map.putIfAbsent(e.department, new ArrayList<>());
            map.get(e.department).add(e);
        }

        System.out.println(map);
    }
}