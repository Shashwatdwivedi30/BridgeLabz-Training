import java.util.*;

abstract class Person {
    protected int id;
    protected String name;

    Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    abstract double calculateFee(); // Polymorphism
}

class Patient extends Person {
    private String disease;
    private List<String> medicalHistory = new ArrayList<>();

    Patient(int id, String name, String disease) {
        super(id, name);
        this.disease = disease;
        medicalHistory.add(disease);
    }

    void addHistory(String record) {
        medicalHistory.add(record);
    }

    void showHistory() {
        System.out.println("Medical History: " + medicalHistory);
    }

    @Override
    double calculateFee() {
        return 200; // base consultation fee
    }
}

class Doctor extends Person {
    private String specialization;

    Doctor(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    @Override
    double calculateFee() {
        return 500; // doctor consultation fee
    }
}

class Appointment {
    Patient patient;
    Doctor doctor;

    Appointment(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }
}

class AppointmentNotAvailableException extends Exception {
    AppointmentNotAvailableException(String message) {
        super(message);
    }
}

interface HospitalService {
    void bookAppointment(Patient patient, Doctor doctor) throws AppointmentNotAvailableException;
    void cancelAppointment(Patient patient);
}

class HospitalServiceImpl implements HospitalService {
    private Map<Integer, Appointment> appointments = new HashMap<>();

    @Override
    public void bookAppointment(Patient patient, Doctor doctor) throws AppointmentNotAvailableException {
        if (appointments.containsKey(patient.id)) {
            throw new AppointmentNotAvailableException("Appointment already exists!");
        }
        appointments.put(patient.id, new Appointment(patient, doctor));
        System.out.println("Appointment booked successfully.");
    }

    @Override
    public void cancelAppointment(Patient patient) {
        appointments.remove(patient.id);
        System.out.println("Appointment cancelled.");
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        Patient patient = new Patient(1, "John", "Fever");
        Doctor doctor = new Doctor(101, "Dr. Smith", "General");

        HospitalService hospitalService = new HospitalServiceImpl();

        try {
            hospitalService.bookAppointment(patient, doctor);
            System.out.println("Patient Fee: " + patient.calculateFee());
            System.out.println("Doctor Fee: " + doctor.calculateFee());

            patient.showHistory();

            hospitalService.cancelAppointment(patient);
        } catch (AppointmentNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}