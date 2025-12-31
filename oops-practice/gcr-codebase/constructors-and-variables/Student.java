class Student {

    // Access specifiers
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Getter
    public double getCGPA() {
        return CGPA;
    }

    // Setter
    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    public static void main(String[] args) {

        PostgraduateStudent pg =
                new PostgraduateStudent(101, "Shashwat", 8.5, "Computer Science");

        pg.displayDetails();

        // Modify CGPA using public method
        pg.setCGPA(9.2);
        System.out.println("\nUpdated CGPA: " + pg.getCGPA());
    }
}

// Subclass
class PostgraduateStudent extends Student {
    String specialization;
    PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA);
        this.specialization = specialization;
    }

    void displayDetails() {
        System.out.println("Roll Number     : " + rollNumber);  
        System.out.println("Name            : " + name);       
        System.out.println("CGPA            : " + getCGPA());   
        System.out.println("Specialization  : " + specialization);
    }
}
