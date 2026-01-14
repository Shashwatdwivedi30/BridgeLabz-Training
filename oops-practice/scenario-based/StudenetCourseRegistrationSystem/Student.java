package StudenetCourseRegistrationSystem;

import java.util.*;

public class Student extends Person {

    private List<String> courses = new ArrayList<>();
    private Map<String, String> grades = new HashMap<>();
    private static final int MAX_COURSES = 3;

    public Student(int id, String name) {
        super(id, name);
    }

    public List<String> getCourses() {
        return courses;
    }

    public Map<String, String> getGrades() {
        return grades;
    }

    public int getCourseCount() {
        return courses.size();
    }

    public void addCourse(String course) {
        courses.add(course);
    }

    public void removeCourse(String course) {
        courses.remove(course);
    }

    public void addGrade(String course, String grade) {
        grades.put(course, grade);
    }

    public int getMaxCourses() {
        return MAX_COURSES;
    }
}
