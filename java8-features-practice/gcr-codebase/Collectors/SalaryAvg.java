import java.util.*;
import java.util.stream.*;

class Employee {
    String name;
    String department;
    double salary;

    Employee(String n, String d, double s) {
        name = n; department = d; salary = s;
    }

    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class SalaryAvg {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", "HR", 50000),
                new Employee("Mary", "HR", 60000),
                new Employee("Bob", "IT", 80000),
                new Employee("Alice", "IT", 90000)
        );
        Map<String, Double> avgSalaryByDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println(avgSalaryByDept);
    }
}