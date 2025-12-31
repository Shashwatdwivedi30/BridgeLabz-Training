import java.util.Scanner;
class Course {
    // Instance variables
    String courseName;
    int duration;        
    double fee;

    // Class variable
    static String instituteName = "ABC Institute";

    // Constructor
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method
    void displayCourseDetails() {
        System.out.println("\nCourse Name     : " + courseName);
        System.out.println("Duration        : " + duration + " months");
        System.out.println("Fee             : " + fee);
        System.out.println("Institute Name  : " + instituteName);
    }

    // Class method
    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Institute Name: ");
        String instName = sc.nextLine();
        Course.updateInstituteName(instName);

        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Duration (months): ");
        int duration = sc.nextInt();

        System.out.print("Enter Course Fee: ");
        double fee = sc.nextDouble();

        Course c1 = new Course(name, duration, fee);
        c1.displayCourseDetails();

        sc.close();
    }
}