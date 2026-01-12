public class TicketReservationSystem {

    // Node class
    static class Ticket {
        int ticketId;
        String customerName;
        String movieName;
        String seatNumber;
        String bookingTime;
        Ticket next;

        Ticket(int ticketId, String customerName, String movieName,
               String seatNumber, String bookingTime) {
            this.ticketId = ticketId;
            this.customerName = customerName;
            this.movieName = movieName;
            this.seatNumber = seatNumber;
            this.bookingTime = bookingTime;
            this.next = null;
        }
    }

    static Ticket head = null;
    static Ticket tail = null;

    // Add ticket at end
    static void addTicket(int id, String customer, String movie,
                          String seat, String time) {

        Ticket newTicket = new Ticket(id, customer, movie, seat, time);

        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;   // circular link
            return;
        }

        tail.next = newTicket;
        newTicket.next = head;
        tail = newTicket;
    }

    // Remove ticket by Ticket ID
    static void removeTicket(int id) {
        if (head == null) return;

        Ticket curr = head;
        Ticket prev = tail;

        do {
            if (curr.ticketId == id) {

                if (curr == head && curr == tail) {
                    head = tail = null;
                } else {
                    prev.next = curr.next;
                    if (curr == head) head = curr.next;
                    if (curr == tail) tail = prev;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Display all tickets
    static void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked");
            return;
        }

        Ticket temp = head;
        do {
            System.out.println(
                    temp.ticketId + " | " +
                    temp.customerName + " | " +
                    temp.movieName + " | Seat: " +
                    temp.seatNumber + " | Time: " +
                    temp.bookingTime
            );
            temp = temp.next;
        } while (temp != head);
    }

    // Search by Customer Name
    static void searchByCustomer(String customer) {
        if (head == null) return;

        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(customer)) {
                System.out.println("Ticket Found: " + temp.ticketId +
                        " | Movie: " + temp.movieName);
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found");
    }

    // Search by Movie Name
    static void searchByMovie(String movie) {
        if (head == null) return;

        Ticket temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                System.out.println("Ticket Found: " + temp.ticketId +
                        " | Customer: " + temp.customerName);
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Ticket not found");
    }

    // Count total tickets
    static int countTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    // Main method
    public static void main(String[] args) {

        addTicket(101, "Amit", "Inception", "A1", "10:00 AM");
        addTicket(102, "Riya", "Avatar", "B3", "11:00 AM");
        addTicket(103, "Karan", "Inception", "C5", "12:00 PM");

        System.out.println("Booked Tickets:");
        displayTickets();

        searchByCustomer("Riya");
        searchByMovie("Inception");

        removeTicket(102);

        System.out.println("\nAfter Ticket Removal:");
        displayTickets();

        System.out.println("\nTotal Booked Tickets: " + countTickets());
    }
}