import java.util.*;

class InvalidFlightException extends Exception {
    public InvalidFlightException(String message) {
        super(message);
    }
}

class FlightUtil {
    public boolean validateFlightNumber(String flightNumber) throws InvalidFlightException {
        String regex = "FL-(\\d{4})";
        if (flightNumber.matches(regex)) {
            int number = Integer.parseInt(flightNumber.substring(3));
            if (number >= 1000 && number <= 9999) {
                return true;
            }
        }
        throw new InvalidFlightException("The flight number " + flightNumber + " is invalid");
    }

    public boolean validateFlightName(String flightName) throws InvalidFlightException {
        if (flightName.equals("SpiceJet") || flightName.equals("Vistara") ||
            flightName.equals("IndiGo") || flightName.equals("Air Arabia")) {
            return true;
        }
        throw new InvalidFlightException("The flight name " + flightName + " is invalid");
    }

    public boolean validatePassengerCount(int passengerCount, String flightName) throws InvalidFlightException {
        int maxCapacity = 0;
        switch (flightName) {
            case "SpiceJet":
                maxCapacity = 396;
                break;
            case "Vistara":
                maxCapacity = 615;
                break;
            case "IndiGo":
                maxCapacity = 230;
                break;
            case "Air Arabia":
                maxCapacity = 130;
                break;
        }

        if (passengerCount <= 0 || passengerCount > maxCapacity) {
            throw new InvalidFlightException("The passenger count " + passengerCount + " is invalid for " + flightName);
        }

        return true;
    }

    public double calculateFuelToFillTank(String flightName, double currentFuelLevel) throws InvalidFlightException {
        double maxFuel = 0;
        switch (flightName) {
            case "SpiceJet":
                maxFuel = 200000;
                break;
            case "Vistara":
                maxFuel = 300000;
                break;
            case "IndiGo":
                maxFuel = 250000;
                break;
            case "Air Arabia":
                maxFuel = 150000;
                break;
        }

        if (currentFuelLevel < 0 || currentFuelLevel > maxFuel) {
            throw new InvalidFlightException("Invalid fuel level for " + flightName);
        }

        return maxFuel - currentFuelLevel;
    }
}

public class AeroVigil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightUtil util = new FlightUtil();

        System.out.println("Enter flight details");
        String details = sc.nextLine();

        String[] parts = details.split(":");

        if (parts.length != 4) {
            System.out.println("Invalid input format! Use <FlightNumber>:<FlightName>:<PassengerCount>:<CurrentFuelLevel>");
            return;
        }

        String flightNumber = parts[0];
        String flightName = parts[1];
        int passengerCount = 0;
        double currentFuelLevel = 0;

        try {
            util.validateFlightNumber(flightNumber);
            util.validateFlightName(flightName);
            util.validatePassengerCount(passengerCount, flightName);

            double fuelNeeded = util.calculateFuelToFillTank(flightName, currentFuelLevel);
            System.out.println("Fuel required to fill the tank: " + fuelNeeded + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        }
    }
}