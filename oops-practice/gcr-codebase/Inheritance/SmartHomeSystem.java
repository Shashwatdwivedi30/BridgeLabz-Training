class Device {
    String deviceId;
    String status; // "ON" or "OFF"

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    void displayStatus() {
        super.displayStatus(); 
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

public class SmartHomeSystem {
    public static void main(String[] args) {
        Thermostat thermostat1 = new Thermostat("T1001", "ON", 22.5);
        Thermostat thermostat2 = new Thermostat("T1002", "OFF", 18.0);

        thermostat1.displayStatus();
        System.out.println();
        thermostat2.displayStatus();
    }
}