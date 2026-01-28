import java.util.*;

class TableAlreadyReservedException extends Exception {
    public TableAlreadyReservedException(String message) {
        super(message);
    }
}

class Table {
    private int tableNumber;
    private int capacity;

    public Table(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getCapacity() {
        return capacity;
    }
}

class Reservation {
    private int tableNumber;
    private String customerName;
    private String timeSlot;

    public Reservation(int tableNumber, String customerName, String timeSlot) {
        this.tableNumber = tableNumber;
        this.customerName = customerName;
        this.timeSlot = timeSlot;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public String getTimeSlot() {
        return timeSlot;
    }
}

public class RestaurantReservationSystem {

    private Map<Integer, Table> tables = new HashMap<>();
    private List<Reservation> reservations = new ArrayList<>();

    public void addTable(Table table) {
        tables.put(table.getTableNumber(), table);
    }

    public void reserveTable(int tableNumber, String customerName, String timeSlot)
            throws TableAlreadyReservedException {

        for (Reservation r : reservations) {
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equalsIgnoreCase(timeSlot)) {

                throw new TableAlreadyReservedException(
                        "Table " + tableNumber + " is already reserved for " + timeSlot);
            }
        }

        reservations.add(new Reservation(tableNumber, customerName, timeSlot));
        System.out.println("✅ Table " + tableNumber + " reserved for " + customerName);
    }

    public void cancelReservation(int tableNumber, String timeSlot) {
        Iterator<Reservation> it = reservations.iterator();

        while (it.hasNext()) {
            Reservation r = it.next();
            if (r.getTableNumber() == tableNumber &&
                r.getTimeSlot().equalsIgnoreCase(timeSlot)) {

                it.remove();
                System.out.println("Reservation cancelled for table " + tableNumber);
                return;
            }
        }

        System.out.println("No reservation found.");
    }

    public void showAvailableTables(String timeSlot) {
        System.out.println("\nAvailable tables for " + timeSlot + ":");

        for (Table table : tables.values()) {
            boolean reserved = false;

            for (Reservation r : reservations) {
                if (r.getTableNumber() == table.getTableNumber() &&
                    r.getTimeSlot().equalsIgnoreCase(timeSlot)) {
                    reserved = true;
                    break;
                }
            }

            if (!reserved) {
                System.out.println("Table " + table.getTableNumber() +
                        " (Capacity: " + table.getCapacity() + ")");
            }
        }
    }

    public static void main(String[] args) {

        RestaurantReservationSystem system = new RestaurantReservationSystem();

        system.addTable(new Table(1, 4));
        system.addTable(new Table(2, 2));
        system.addTable(new Table(3, 6));

        try {
            system.reserveTable(1, "Alice", "7-8 PM");
            system.reserveTable(2, "Bob", "7-8 PM");

            system.reserveTable(1, "Charlie", "7-8 PM");

        } catch (TableAlreadyReservedException e) {
            System.out.println(e.getMessage());
        }

        system.showAvailableTables("7-8 PM");

        system.cancelReservation(2, "7-8 PM");
        system.showAvailableTables("7-8 PM");
    }
}