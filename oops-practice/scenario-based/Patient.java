import java.util.Scanner;
public class Patient {
    static String hospitalName = "City Hospital";
    static int totalPatients = 0;
    final String patientID;
    String name;
    int age;
    String ailment;

    Patient(String patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    void displayDetails(Object obj) {
        if (obj instanceof Patient) {
            Patient p = (Patient) obj;
            System.out.println("Hospital Name: " + hospitalName);
            System.out.println("Patient ID: " + p.patientID);
            System.out.println("Name: " + p.name);
            System.out.println("Age: " + p.age);
            System.out.println("Ailment: " + p.ailment);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Patient 1 ID: ");
        String id1 = sc.nextLine();
        System.out.print("Enter Patient 1 Name: ");
        String name1 = sc.nextLine();
        System.out.print("Enter Patient 1 Age: ");
        int age1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Patient 1 Ailment: ");
        String ailment1 = sc.nextLine();

        Patient p1 = new Patient(id1, name1, age1, ailment1);

        System.out.print("Enter Patient 2 ID: ");
        String id2 = sc.nextLine();
        System.out.print("Enter Patient 2 Name: ");
        String name2 = sc.nextLine();
        System.out.print("Enter Patient 2 Age: ");
        int age2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Patient 2 Ailment: ");
        String ailment2 = sc.nextLine();

        Patient p2 = new Patient(id2, name2, age2, ailment2);

        System.out.println();
        getTotalPatients();

        System.out.println();
        p1.displayDetails(p1);

        System.out.println();
        p2.displayDetails(p2);

        sc.close();
    }
}