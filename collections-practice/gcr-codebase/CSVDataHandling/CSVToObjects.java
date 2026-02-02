import java.io.*;
import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private int marks;

    public Student(int id, String name, int age, int marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + age + " | " + marks;
    }
}

public class CSVToObjects {
    public static void main(String[] args) {

        String file = "students.csv";
        List<Student> students = new ArrayList<>();
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            br.readLine(); 
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                Student s = new Student(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3])
                );
                students.add(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Student Objects:\n");
        for (Student s : students) {
            System.out.println(s);
        }
    }
}