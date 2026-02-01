import java.util.*;

abstract class GoodsTransport {

    protected String transportId;
    protected String transportDate;
    protected int transportRating;

    public GoodsTransport(String transportId, String transportDate, int transportRating) {
        this.transportId = transportId;
        this.transportDate = transportDate;
        this.transportRating = transportRating;
    }

    public String getTransportId() { return transportId; }
    public String getTransportDate() { return transportDate; }
    public int getTransportRating() { return transportRating; }

    public abstract String vehicleSelection();
    public abstract float calculateTotalCharge();
}

class BrickTransport extends GoodsTransport {

    private float brickSize;
    private int brickQuantity;
    private float brickPrice;

    public BrickTransport(String transportId, String transportDate, int transportRating,
                          float brickSize, int brickQuantity, float brickPrice) {
        super(transportId, transportDate, transportRating);
        this.brickSize = brickSize;
        this.brickQuantity = brickQuantity;
        this.brickPrice = brickPrice;
    }

    public int getBrickQuantity() { return brickQuantity; }
    public float getBrickPrice() { return brickPrice; }

    @Override
    public String vehicleSelection() {
        if (brickQuantity < 300) return "Truck";
        else if (brickQuantity <= 500) return "Lorry";
        return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {
        float price = brickPrice * brickQuantity;
        float tax = price * 0.3f;

        float discount = 0;
        if (transportRating == 5) discount = price * 0.20f;
        else if (transportRating == 3 || transportRating == 4) discount = price * 0.10f;

        int vehicleCost = switch (vehicleSelection().toLowerCase()) {
            case "truck" -> 1000;
            case "lorry" -> 1700;
            default -> 3000;
        };

        return price + vehicleCost + tax - discount;
    }
}


class TimberTransport extends GoodsTransport {

    private float timberLength;
    private float timberRadius;
    private String timberType;
    private float timberPrice;

    public TimberTransport(String transportId, String transportDate, int transportRating,
                           float timberLength, float timberRadius, String timberType, float timberPrice) {
        super(transportId, transportDate, transportRating);
        this.timberLength = timberLength;
        this.timberRadius = timberRadius;
        this.timberType = timberType;
        this.timberPrice = timberPrice;
    }

    public String getTimberType() { return timberType; }
    public float getTimberPrice() { return timberPrice; }

    @Override
    public String vehicleSelection() {
        double area = 2 * 3.147 * timberRadius * timberLength;

        if (area < 250) return "Truck";
        else if (area <= 400) return "Lorry";
        return "MonsterLorry";
    }

    @Override
    public float calculateTotalCharge() {

        double volume = 3.147 * timberRadius * timberRadius * timberLength;
        double typeMultiplier = timberType.equalsIgnoreCase("Premium") ? 0.25 : 0.15;

        double price = volume * timberPrice * typeMultiplier;
        double tax = price * 0.30;

        double discount = 0;
        if (transportRating == 5) discount = price * 0.20;
        else if (transportRating == 3 || transportRating == 4) discount = price * 0.10;

        int vehicleCost = switch (vehicleSelection().toLowerCase()) {
            case "truck" -> 1000;
            case "lorry" -> 1700;
            default -> 3000;
        };

        return (float)(price + vehicleCost + tax - discount);
    }
}

class Utility {

    public GoodsTransport parseDetails(String input) {

        String[] data = input.split(":");

        String id = data[0];
        String date = data[1];
        int rating = Integer.parseInt(data[2]);
        String type = data[3];

        if (type.equalsIgnoreCase("BrickTransport")) {
            float size = Float.parseFloat(data[4]);
            int qty = Integer.parseInt(data[5]);
            float price = Float.parseFloat(data[6]);

            return new BrickTransport(id, date, rating, size, qty, price);
        } else {
            float length = Float.parseFloat(data[4]);
            float radius = Float.parseFloat(data[5]);
            String timberType = data[6];
            float timberPrice = Float.parseFloat(data[7]);

            return new TimberTransport(id, date, rating, length, radius, timberType, timberPrice);
        }
    }

    public boolean validateTransportId(String transportId) {
        if (!transportId.matches("RTS[0-9]{3}[A-Z]")) {
            System.out.println("Transport id " + transportId + " is invalid");
            return false;
        }
        return true;
    }

    public String findObjectType(GoodsTransport obj) {
        if (obj instanceof TimberTransport) return "TimberTransport";
        return "BrickTransport";
    }
}

public class FutureLogistics {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Utility util = new Utility();

        System.out.println("Enter the Goods Transport details");
        String input = sc.nextLine();

        GoodsTransport gt = util.parseDetails(input);

        if (!util.validateTransportId(gt.getTransportId())) {
            System.out.println("Please provide a valid record");
            return;
        }

        System.out.println("Transporter id : " + gt.getTransportId());
        System.out.println("Date of transport : " + gt.getTransportDate());
        System.out.println("Rating of the transport : " + gt.getTransportRating());

        String type = util.findObjectType(gt);

        if (type.equals("BrickTransport")) {
            BrickTransport b = (BrickTransport) gt;
            System.out.println("Quantity of bricks : " + b.getBrickQuantity());
            System.out.println("Brick price : " + b.getBrickPrice());
            System.out.println("Vehicle for transport : " + b.vehicleSelection());
            System.out.println("Total charge : " + b.calculateTotalCharge());
        } else {
            TimberTransport t = (TimberTransport) gt;
            System.out.println("Type of the timber : " + t.getTimberType());
            System.out.println("Timber price per kilo : " + t.getTimberPrice());
            System.out.println("Vehicle for transport : " + t.vehicleSelection());
            System.out.println("Total charge : " + t.calculateTotalCharge());
        }

        sc.close();
    }
}