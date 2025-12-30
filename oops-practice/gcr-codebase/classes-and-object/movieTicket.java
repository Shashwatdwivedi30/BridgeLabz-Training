import java.util.Scanner;

class movieTicket {
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked = false;

    void bookTicket(String mName, String sNumber, double p) {
        if (isBooked) {
            System.out.println("House full!!! sorry..... Ticket already booked");
        } else {
            movieName = mName;
            seatNumber = sNumber;
            price = p;
            isBooked = true;

            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
        }
    }

    void displayTicket() {
        if (!isBooked) {
            System.out.println("Ticket have not booked yet....");
        } else {
            System.out.println("Price: $" + price);
            System.out.println();
            System.out.println("Ticket booked for movie: " + movieName);
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        movieTicket ticket = new movieTicket();

        ticket.displayTicket();
        System.out.print("\nEnter movie name: ");
        String movie = sc.nextLine();

        System.out.print("Enter seat number: ");
        String seat = sc.nextLine();

        System.out.print("Enter ticket price: ");
        double price = sc.nextDouble();

        ticket.bookTicket(movie, seat, price);
        sc.close();
    }
}
