import java.util.*;

abstract class CourseType {
    abstract String getEvaluationType();
}

class ExamCourse extends CourseType {
    public String getEvaluationType() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public String getEvaluationType() {
        return "Research-Based";
    }
}

class Course<T extends CourseType> {
    private String courseName;
    private T courseType;

    public Course(String courseName, T courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public T getCourseType() {
        return courseType;
    }
}

class CourseManager {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void displayCourses() {
        for (Course<? extends CourseType> c : courses) {
            System.out.println(
                c.getCourseName() + " | " +
                c.getCourseType().getEvaluationType()
            );
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {

        Course<ExamCourse> math =
                new Course<>("Mathematics", new ExamCourse());

        Course<AssignmentCourse> programming =
                new Course<>("Java Programming", new AssignmentCourse());

        Course<ResearchCourse> ai =
                new Course<>("AI Research", new ResearchCourse());

        CourseManager manager = new CourseManager();
        manager.addCourse(math);
        manager.addCourse(programming);
        manager.addCourse(ai);

        manager.displayCourses();
    }
}