import java.util.*;
import java.time.LocalDateTime;

class InvalidVehicleException extends Exception{
    public InvalidVehicleException(String msg){
        super(msg);
    }
}

abstract class Violation{
    private LocalDateTime dateTime;
    public Violation(){
        this.dateTime = LocalDateTime.now();
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public abstract double calculateFine(int repeatCount);
}

class SpeedingViolation extends Violation{
    @Override
    public double calculateFine(int repeatCount){
        double base = 1000;
        return base + (repeatCount * 200);
    }
}

class SignalJumpViolation extends Violation{
    @Override
    public double calculateFine(int repeatCount){
        double base = 1500;
        return base + (repeatCount * 300);
    }
}

class ParkingViolation extends Violation{
    @Override
    public double calculateFine(int repeatCount){
        double base = 500;
        return base + (repeatCount * 100);
    }
}

class TrafficSystem{
    private Map<String, List<Violation>> violationMap = new HashMap<>();

    public void addViolation(String vehicle, Violation violation) throws InvalidVehicleException{
        if(vehicle == null || vehicle.isEmpty()){
            throw new InvalidVehicleException("Invalid vehicle no");
        }

        violationMap.putIfAbsent(vehicle, new ArrayList<>());
        violationMap.get(vehicle).add(violation);
    }

    public double calculateTotalFine(String vehicle){
        if(!violationMap.containsKey(vehicle)) return 0;
        List<Violation> list = violationMap.get(vehicle);
        double total = 0;
        for(int i = 0; i < list.size(); i++){
            Violation v = list.get(i);
            total += v.calculateFine(i);
        }
        return total;
    }

    public void generateMonthlyReport() {
        System.out.println("===== Monthly Traffic Report =====");
        for (String vehicle : violationMap.keySet()) {
            double totalFine = calculateTotalFine(vehicle);
            System.out.println("Vehicle: " + vehicle);
            System.out.println("Violations: " + violationMap.get(vehicle).size());
            System.out.println("Total Fine: ₹" + totalFine);
            System.out.println("---------------------------------");
        }
    }
}
public class FineCollectionSystem {
    public static void main(String[] args) {
        TrafficSystem ts = new TrafficSystem();
        try{
            ts.addViolation("KA01AB1234", new SpeedingViolation());
            ts.addViolation("KA01AB1234", new ParkingViolation());
            ts.addViolation("KA02XY9876", new SignalJumpViolation());
            ts.addViolation("KA02XY9876", new SpeedingViolation());
        }
        catch(InvalidVehicleException e){
            System.out.println(e.getMessage());
        }

        ts.generateMonthlyReport();
    }
}