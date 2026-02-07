import java.util.*;

class Vessel {
    private String vesselId;
    private String vesselName;
    private double averageSpeed;
    private String vesselType;

    public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
        this.vesselId = vesselId;
        this.vesselName = vesselName;
        this.averageSpeed = averageSpeed;
        this.vesselType = vesselType;
    }

    public String getVesselId() { return vesselId; }
    public String getVesselName() { return vesselName; }
    public double getAverageSpeed() { return averageSpeed; }
    public String getVesselType() { return vesselType; }
}

class VesselUtil {
    private List<Vessel> vesselList = new ArrayList<>();

    public void addVesselPerformance(Vessel vessel) {
        vesselList.add(vessel);
    }

    public Vessel getVesselById(String vesselId) {
        for (Vessel v : vesselList) {
            if (v.getVesselId().equals(vesselId)) {
                return v;
            }
        }
        return null;
    }

    public List<Vessel> getHighPerformanceVessels() {
        List<Vessel> high = new ArrayList<>();
        if (vesselList.isEmpty()) return high;

        double maxSpeed = 0;
        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() > maxSpeed) {
                maxSpeed = v.getAverageSpeed();
            }
        }

        for (Vessel v : vesselList) {
            if (v.getAverageSpeed() == maxSpeed) {
                high.add(v);
            }
        }

        return high;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VesselUtil util = new VesselUtil();

        System.out.println("Enter the number of vessels to be added");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Enter vessel details");
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(":");
            Vessel v = new Vessel(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3]);
            util.addVesselPerformance(v);
        }

        System.out.println("Enter the Vessel Id to check speed");
        String id = sc.nextLine();
        Vessel v = util.getVesselById(id);

        if (v != null) {
            System.out.println(v.getVesselId() + " | " + v.getVesselName() + " | " + v.getVesselType() + " | " + v.getAverageSpeed() + " knots");
        } else {
            System.out.println("Vessel Id " + id + " not found");
        }

        System.out.println("High performance vessels are");
        for (Vessel hv : util.getHighPerformanceVessels()) {
            System.out.println(hv.getVesselId() + " | " + hv.getVesselName() + " | " + hv.getVesselType() + " | " + hv.getAverageSpeed() + " knots");
        }
    }
}