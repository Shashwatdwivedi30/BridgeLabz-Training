import java.io.*;

public class StudentDataStream {

    public static void main(String[] args) {

        String fileName = "student.dat";

        try (DataOutputStream dos =
                     new DataOutputStream(new FileOutputStream(fileName))) {

            dos.writeInt(101);               
            dos.writeUTF("Shashwat");       
            dos.writeDouble(8.75);          
            System.out.println("Student data written successfully!");

        } catch (IOException e) {
            System.out.println("Write Error: " + e.getMessage());
        }

        try (DataInputStream dis =
                     new DataInputStream(new FileInputStream(fileName))) {

            int rollNo = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();

            System.out.println("\nStudent Data Retrieved:");
            System.out.println("Roll No : " + rollNo);
            System.out.println("Name    : " + name);
            System.out.println("GPA     : " + gpa);

        } catch (IOException e) {
            System.out.println("Read Error: " + e.getMessage());
        }
    }
}