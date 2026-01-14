package FlightBookingSystem;

public class Flight {
    String flightId;
    String source;
    String destination;

    Flight(String flightId, String source, String destination){
        this.flightId = flightId;
        this.source = source;
        this.destination =  destination;
    }
}