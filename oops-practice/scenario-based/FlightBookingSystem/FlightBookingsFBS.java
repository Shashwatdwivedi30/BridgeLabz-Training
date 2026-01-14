package FlightBookingSystem;

public class FlightBookingsFBS {
    public static void main(String[] args) {
        FlightServices service = new FlightServices();
        service.searchFlight("Delhi", "Banglore");

        service.bookFlight("Shashwat", "F102");
        service.displayBookings();
    }
}