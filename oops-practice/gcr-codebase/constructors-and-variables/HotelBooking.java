public class HotelBooking {
    // Private attributes
    private String guestName;
    private String roomType;
    private int nights;

    // Default constructor
    public HotelBooking() {
        this.guestName = "null";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking booking) {
        this.guestName = booking.guestName;
        this.roomType = booking.roomType;
        this.nights = booking.nights;
    }

    // Method to display booking details
    public void displayBooking() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    public static void main(String[] args) {

        // Using default constructor
        HotelBooking b1 = new HotelBooking();
        b1.displayBooking();
        System.out.println();

        // Using parameterized constructor
        HotelBooking b2 = new HotelBooking("Shashwat", "Deluxe", 3);
        b2.displayBooking();

        System.out.println();

        // Using copy constructor
        HotelBooking b3 = new HotelBooking(b2);
        b3.displayBooking();
    }
}
