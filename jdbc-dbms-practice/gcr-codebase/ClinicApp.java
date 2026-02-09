import java.sql.*;
import java.util.*;

class DB {
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/clinic_db", "root", "password");
    }
}

// patient management
class PatientService {
    // UC-1.1: Register New Patient
    public void registerPatient(String name, String dob, String phone, String email,
                                String address, String bloodGroup) throws Exception {

        String uniqueCheck = "SELECT COUNT(*) FROM patients WHERE phone=? OR email=?";
        String insert = "INSERT INTO patients(name, dob, phone, email, address, blood_group) VALUES(?,?,?,?,?,?)";

        try (Connection con = DB.getConnection();
             PreparedStatement psCheck = con.prepareStatement(uniqueCheck);
             PreparedStatement psInsert = con.prepareStatement(insert)) {

            psCheck.setString(1, phone);
            psCheck.setString(2, email);
            ResultSet rs = psCheck.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                throw new Exception("Patient with same phone/email already exists.");
            }

            psInsert.setString(1, name);
            psInsert.setString(2, dob);
            psInsert.setString(3, phone);
            psInsert.setString(4, email);
            psInsert.setString(5, address);
            psInsert.setString(6, bloodGroup);
            psInsert.executeUpdate();

            System.out.println("Patient Registered Successfully.");
        }
    }

    // UC-1.2: Update Patient Information
    public void updatePatient(int id, String name, String address, String phone) throws Exception {
        String update = "UPDATE patients SET name=?, address=?, phone=? WHERE id=?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(update)) {

            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setInt(4, id);

            int updated = ps.executeUpdate();
            if (updated == 0) System.out.println("Patient not found!");
            else System.out.println("Patient updated.");
        }
    }

    // UC-1.3: Search Patient Records
    public void searchPatients(String keyword) throws Exception {
        String query = "SELECT * FROM patients WHERE name LIKE ? OR phone=? OR id=?";

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, keyword);

            try {
                ps.setInt(3, Integer.parseInt(keyword));
            } catch (NumberFormatException e) {
                ps.setInt(3, -1); // no match
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " + rs.getString("phone"));
            }
        }
    }

    // UC-1.4: View Patient Visit History
    public void viewVisitHistory(int patientId) throws Exception {
        String query = """
                SELECT a.appointment_date, d.name AS doctor_name, v.diagnosis
                FROM appointments a
                JOIN visits v ON a.id=v.appointment_id
                JOIN doctors d ON a.doctor_id=d.id
                WHERE a.patient_id=?
                ORDER BY a.appointment_date
                """;

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setInt(1, patientId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getDate("appointment_date") + " | " +
                        rs.getString("doctor_name") + " | " +
                        rs.getString("diagnosis"));
            }
        }
    }
}

// doctor managemet
class DoctorService {
    // UC-2.1: Add Doctor Profile
    public void addDoctor(String name, String specialization, String phone, double fee) throws Exception {
        String insert = """
                INSERT INTO doctors(name, specialization, phone, consultation_fee)
                VALUES(?,?,?,?)
                """;

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(insert)) {

            ps.setString(1, name);
            ps.setString(2, specialization);
            ps.setString(3, phone);
            ps.setDouble(4, fee);
            ps.executeUpdate();

            System.out.println("Doctor added successfully.");
        }
    }

    // UC-2.2: Assign/Update Doctor Specialty
    public void updateDoctorSpecialty(int doctorId, int specialtyId) throws Exception {

        String update = "UPDATE doctors SET specialty_id=? WHERE id=?";

        try (Connection con = DB.getConnection()) {
            con.setAutoCommit(false); // transaction

            PreparedStatement ps = con.prepareStatement(update);
            ps.setInt(1, specialtyId);
            ps.setInt(2, doctorId);

            ps.executeUpdate();
            con.commit();
            System.out.println("Doctor specialty updated.");
        }
    }

    // UC-2.3: View Doctors by Specialty
    public void viewDoctorsBySpecialty(String specialty) throws Exception {
        String query = """
                SELECT d.id, d.name, s.specialty_name
                FROM doctors d
                JOIN specialties s ON d.specialty_id = s.id
                WHERE s.specialty_name=?
                """;

        try (Connection con = DB.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {

            ps.setString(1, specialty);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("specialty_name"));
            }
        }
    }

    // UC-2.4: Deactivate Doctor Profile (Soft Delete)
    public void deactivateDoctor(int doctorId) throws Exception {

        String futureCheck = """
                SELECT COUNT(*) FROM appointments
                WHERE doctor_id=? AND appointment_date > CURRENT_DATE
                """;

        String deactivate = "UPDATE doctors SET is_active=false WHERE id=?";

        try (Connection con = DB.getConnection();
             PreparedStatement psCheck = con.prepareStatement(futureCheck);
             PreparedStatement psDeactivate = con.prepareStatement(deactivate)) {

            psCheck.setInt(1, doctorId);
            ResultSet rs = psCheck.executeQuery();
            rs.next();

            if (rs.getInt(1) > 0) {
                throw new Exception("Doctor has future appointments! Cannot deactivate.");
            }

            psDeactivate.setInt(1, doctorId);
            psDeactivate.executeUpdate();
            System.out.println("Doctor deactivated.");
        }
    }
}

public class ClinicApp {
    public static void main(String[] args) throws Exception {
        PatientService patientService = new PatientService();
        DoctorService doctorService = new DoctorService();
    }
}