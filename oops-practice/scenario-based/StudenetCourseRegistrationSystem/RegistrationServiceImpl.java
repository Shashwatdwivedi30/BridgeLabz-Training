package StudenetCourseRegistrationSystem;

public class RegistrationServiceImpl implements RegistrationService {

    @Override
    public void enrollCourse(Student student, String course)
            throws CourseLimitExceededException {

        if (student.getCourseCount() >= student.getMaxCourses()) {
            throw new CourseLimitExceededException("Course limit exceeded!");
        }
        student.addCourse(course);
        System.out.println("Enrolled in: " + course);
    }

    @Override
    public void dropCourse(Student student, String course) {
        student.removeCourse(course);
        System.out.println("Dropped course: " + course);
    }

    @Override
    public void assignGrade(Student student, String course, String grade) {
        student.addGrade(course, grade);
    }
}