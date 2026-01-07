import java.util.*;

class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

// Interface
interface FareCalculator {
    double calculateFare(double distance);
}

// Polymorphism
class NormalFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10; // ₹10 per km
    }
}

class PeakFareCalculator implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15; // ₹15 per km (peak pricing)
    }
}

// OOP Classes
class User {
    int userId;
    String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }
}

class Driver {
    int driverId;
    String name;
    boolean available;

    public Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
        this.available = true;
    }
}

class Ride {
    User user;
    Driver driver;
    double distance;
    double fare;
    String status;

    public Ride(User user, Driver driver, double distance, double fare) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
        this.fare = fare;
        this.status = "COMPLETED";
    }

    public void displayRide() {
        System.out.println(
            "User: " + user.name +
            ", Driver: " + driver.name +
            ", Distance: " + distance + " km" +
            ", Fare: ₹" + fare +
            ", Status: " + status
        );
    }
}

class RideService {
    List<Driver> drivers = new ArrayList<>();
    List<Ride> rideHistory = new ArrayList<>();

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    private Driver assignDriver() throws NoDriverAvailableException {
        for (Driver driver : drivers) {
            if (driver.available) {
                driver.available = false;
                return driver;
            }
        }
        throw new NoDriverAvailableException("No drivers available right now!");
    }

    public void bookRide(User user, double distance, FareCalculator calculator)
            throws NoDriverAvailableException {

        Driver driver = assignDriver();
        double fare = calculator.calculateFare(distance);

        Ride ride = new Ride(user, driver, distance, fare);
        rideHistory.add(ride);

        driver.available = true; // ride completed
        System.out.println("Ride booked successfully!");
    }

    public void showRideHistory() {
        for (Ride ride : rideHistory) {
            ride.displayRide();
        }
    }
}

public class CabBookingSystem {
    public static void main(String[] args) {

        RideService service = new RideService();

        service.addDriver(new Driver(1, "Amit"));
        service.addDriver(new Driver(2, "Rahul"));

        User user = new User(101, "Shashwat");

        try {
            service.bookRide(user, 5, new NormalFareCalculator());

            service.bookRide(user, 8, new PeakFareCalculator());

        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n--- Ride History ---");
        service.showRideHistory();
    }
}
