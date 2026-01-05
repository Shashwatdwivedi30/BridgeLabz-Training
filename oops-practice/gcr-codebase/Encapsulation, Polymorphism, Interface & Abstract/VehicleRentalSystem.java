import java.util.*;

// Interface
interface Insurable {
    double calculateInsurance(int days);
    String getInsuranceDetails();
}

// Abstract class
abstract class Vehicle {
    // Encapsulation
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber; 

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String policyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = policyNumber;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    protected double getRentalRate() {
        return rentalRate;
    }

    public void setInsurancePolicyNumber(String policyNumber) {
        this.insurancePolicyNumber = policyNumber;
    }

    protected String getMaskedPolicyNumber() {
        return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }

    public void displayVehicleDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
    }
}

class Car extends Vehicle implements Insurable {

    public Car(String number, double rate, String policy) {
        super(number, "Car", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance(int days) {
        return 200 * days; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance (Policy: " + getMaskedPolicyNumber() + ")";
    }
}

class Bike extends Vehicle implements Insurable {

    public Bike(String number, double rate, String policy) {
        super(number, "Bike", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.9; 
    }

    @Override
    public double calculateInsurance(int days) {
        return 100 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance (Policy: " + getMaskedPolicyNumber() + ")";
    }
}

class Truck extends Vehicle implements Insurable {

    public Truck(String number, double rate, String policy) {
        super(number, "Truck", rate, policy);
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500; 
    }

    @Override
    public double calculateInsurance(int days) {
        return 300 * days;
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance (Policy: " + getMaskedPolicyNumber() + ")";
    }
}

public class VehicleRentalSystem {

    public static void main(String[] args) {

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("MH12AB1234", 1500, "CAR987654"));
        vehicles.add(new Bike("MH14XY5678", 500, "BIKE123456"));
        vehicles.add(new Truck("MH01TR9999", 3000, "TRUCK654321"));

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            v.displayVehicleDetails();

            double rentalCost = v.calculateRentalCost(rentalDays);
            double insuranceCost = 0;

            if (v instanceof Insurable) {
                Insurable i = (Insurable) v;
                insuranceCost = i.calculateInsurance(rentalDays);
                System.out.println("Insurance: " + i.getInsuranceDetails());
            }

            System.out.println("Rental Days: " + rentalDays);
            System.out.println("Rental Cost: " + rentalCost);
            System.out.println("Insurance Cost: " + insuranceCost);
            System.out.println("Total Cost: " + (rentalCost + insuranceCost));
            System.out.println("---------------------------");
        }
    }
}