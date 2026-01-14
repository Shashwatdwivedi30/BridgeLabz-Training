package StudenetCourseRegistrationSystem;

public class StudentCourseSystem {
    public static void main(String[] args) {

        Student student = new Student(101, "Shashwat");
        RegistrationService service = new RegistrationServiceImpl();

        try {
            service.enrollCourse(student, "Java");
            service.enrollCourse(student, "Python");
            service.enrollCourse(student, "DSA");
            service.enrollCourse(student, "AI"); // Exception

        } catch (CourseLimitExceededException e) {
            System.out.println(e.getMessage());
        }

        service.assignGrade(student, "Java", "A");
        service.assignGrade(student, "Python", "B+");
        service.assignGrade(student, "DSA", "A+");

        System.out.println("\nEnrolled Courses:");
        for (String c : student.getCourses()) {
            System.out.println(c);
        }

        System.out.println("\nGrades:");
        student.getGrades().forEach((course, grade) ->
                System.out.println(course + " : " + grade));
    }
}