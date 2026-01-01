import java.util.Scanner;
public class Employee {

    static String companyName = "Tech Solutions Inc.";
    static int totalEmployees = 0;
    final int id;
    String name;
    String designation;

    Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
        totalEmployees++;
    }

    static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    void displayDetails(Object obj) {
        if (obj instanceof Employee) {
            Employee e = (Employee) obj;
            System.out.println("Company Name: " + companyName);
            System.out.println("Employee ID: " + e.id);
            System.out.println("Name: " + e.name);
            System.out.println("Designation: " + e.designation);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee 1 ID: ");
        int id1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee 1 Name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Employee 1 Designation: ");
        String des1 = sc.nextLine();
        Employee emp1 = new Employee(id1, name1, des1);

        System.out.print("Enter Employee 2 ID: ");
        int id2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Employee 2 Name: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Employee 2 Designation: ");
        String des2 = sc.nextLine();
        Employee emp2 = new Employee(id2, name2, des2);
        System.out.println();
        displayTotalEmployees();

        System.out.println();
        emp1.displayDetails(emp1);

        System.out.println();
        emp2.displayDetails(emp2);
        sc.close();
    }
}