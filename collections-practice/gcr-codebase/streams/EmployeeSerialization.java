import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeSerialization {

    static class Employee implements Serializable {
        private static final long serialVersionUID = 1L;

        int id;
        String name;
        String department;
        double salary;

        Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String toString() {
            return "Employee [Id=" + id +
                    ", Name=" + name +
                    ", Department=" + department +
                    ", Salary=" + salary + "]";
        }
    }

    public static void main(String[] args) {

        String fileName = "employees.dat";

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Amit", "IT", 55000));
        employees.add(new Employee(102, "Neha", "HR", 48000));
        employees.add(new Employee(103, "Rahul", "Finance", 62000));

        // 🔹 Serialization
        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            oos.writeObject(employees);
            System.out.println("Employees saved successfully!");

        } catch (IOException e) {
            System.out.println("Serialization Error: " + e.getMessage());
        }

        // 🔹 Deserialization
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            List<Employee> empList = (List<Employee>) ois.readObject();

            System.out.println("\nEmployees retrieved from file:");
            for (Employee emp : empList) {
                System.out.println(emp);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization Error: " + e.getMessage());
        }
    }
}