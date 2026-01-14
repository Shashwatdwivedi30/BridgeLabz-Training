package FlightBookingSystem;

import java.util.*;
public class FlightServices {
    Flight[] flights = {
        new Flight("F101","New Delhi", "Mumbai"),
        new Flight("F102", "Bangalore", "Chennai"),
        new Flight("F103", "Kolkata", "Hyderabad"),
        new Flight("F104", "Pune", "Goa"),
        new Flight("F105", "Delhi", "Bangalore")
    };

    List<Booking> bookings = new ArrayList<>();

    void searchFlight(String source, String destination){

        System.out.println("Available Flights:");
        for (int i = 0; i < flights.length; i++) {
            System.out.println(flights[i].flightId + " " +flights[i].source + " to " +flights[i].destination);
        }
        System.out.println();

        boolean found = false;
        for(Flight fl : flights){
            if(fl.source.equalsIgnoreCase(source) && fl.destination.equalsIgnoreCase(destination)){
                System.out.println(fl.flightId + " : " + fl.source + " to " + fl.destination);
                found = true;
                return;
            }
        }
        if(found){
            System.out.println("No flights found.");
        }
    }

    void bookFlight(String userName, String flightId){
        for(Flight fl : flights){
            if(fl.flightId.equalsIgnoreCase(flightId)){
                bookings.add(new Booking(userName, fl));
                System.out.println("Flight booked successfully");
                return;
            }
        }
        System.out.println("Flight ID not found.");
    }

    void displayBookings(){
        System.out.println("Booking Details");
        if(bookings.isEmpty()){
            System.out.println("No booking made yet.");
        }
        else{
            for (Booking b : bookings) {
                System.out.println(b.userName + " booked " + b.flight.flightId + " : " + b.flight.source + " to " + b.flight.destination);             
            }
        }
    }
}
