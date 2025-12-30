import java.util.Scanner;
class employee {
    String name;
    int id;
    double salary;

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        employee e = new employee();
        System.out.print("Enter Employee Name: ");
        e.name = sc.nextLine();

        System.out.print("Enter Employee id: ");
        e.id = sc.nextInt();

        System.out.print("Enter Employee Salary: ");
        e.salary = sc.nextDouble();

        e.display();
        sc.close();
    }
}