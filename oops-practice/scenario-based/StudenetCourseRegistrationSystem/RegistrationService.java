package StudenetCourseRegistrationSystem;

class CourseLimitExceededException extends Exception {
    public CourseLimitExceededException(String message) {
        super(message);
    }
}


public interface RegistrationService {
    void enrollCourse(Student student, String course)
            throws CourseLimitExceededException;

    void dropCourse(Student student, String course);

    void assignGrade(Student student, String course, String grade);
}