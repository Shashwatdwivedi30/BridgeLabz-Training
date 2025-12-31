class Employee {
    // Access modifiers
    public int employeeID;
    protected String department;
    private double salary;

    // Constructor
    Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Public method to access salary
    public double getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        Manager m = new Manager(201, "IT", 50000, "Project Manager");
        m.displayDetails();

        // Modify salary using public method
        m.setSalary(60000);
        System.out.println("\nUpdated Salary: " + m.getSalary());
    }
}

// Subclass
class Manager extends Employee {
    String designation;
    Manager(int employeeID, String department,
            double salary, String designation) {
        super(employeeID, department, salary);
        this.designation = designation;
    }

    void displayDetails() {
        System.out.println("Employee ID : " + employeeID);  
        System.out.println("Department  : " + department);   
        System.out.println("Salary      : " + getSalary()); 
        System.out.println("Designation : " + designation);
    }
}