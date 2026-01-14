import java.util.*;

abstract class Room {
    int roomNumber;
    boolean isAvailable = true;

    Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    abstract double getPrice(); // Polymorphism
}

class StandardRoom extends Room {
    StandardRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    double getPrice() {
        return 2000; // normal price
    }
}

class DeluxeRoom extends Room {
    DeluxeRoom(int roomNumber) {
        super(roomNumber);
    }

    @Override
    double getPrice() {
        return 3500; // higher price
    }
}

class Guest {
    int id;
    String name;

    Guest(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Reservation {
    Guest guest;
    Room room;
    int days;

    Reservation(Guest guest, Room room, int days) {
        this.guest = guest;
        this.room = room;
        this.days = days;
    }
}

interface PricingStrategy {
    double calculateBill(Room room, int days);
}

class SeasonalPricing implements PricingStrategy {
    @Override
    public double calculateBill(Room room, int days) {
        return room.getPrice() * days * 1.1; // 10% seasonal increase
    }
}

class RoomNotAvailableException extends Exception {
    RoomNotAvailableException(String message) {
        super(message);
    }
}

class HotelService {
    Map<Integer, Reservation> reservations = new HashMap<>();
    PricingStrategy pricingStrategy = new SeasonalPricing();

    // Book room
    void bookRoom(Guest guest, Room room, int days) throws RoomNotAvailableException {
        if (!room.isAvailable) {
            throw new RoomNotAvailableException("Room not available!");
        }
        room.isAvailable = false;
        reservations.put(guest.id, new Reservation(guest, room, days));
        System.out.println("Room booked successfully.");
    }

    // Check-in
    void checkIn(Guest guest) {
        System.out.println(guest.name + " checked in.");
    }

    // Check-out & invoice
    void checkOut(Guest guest) {
        Reservation res = reservations.get(guest.id);
        double bill = pricingStrategy.calculateBill(res.room, res.days);
        res.room.isAvailable = true;
        reservations.remove(guest.id);
        System.out.println("Checked out. Total Bill: " + bill);
    }
}

public class HotelReservationSystem {
    public static void main(String[] args) {
        Guest guest = new Guest(1, "Alice");
        Room room = new DeluxeRoom(101);

        HotelService hotelService = new HotelService();

        try {
            hotelService.bookRoom(guest, room, 3);
            hotelService.checkIn(guest);
            hotelService.checkOut(guest);
        } catch (RoomNotAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}