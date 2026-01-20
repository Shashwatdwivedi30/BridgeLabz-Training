public class AddressBookMain {

    public static void main(String[] args) {

        System.out.println("=================================");
        System.out.println(" Welcome to Address Book Program ");
        System.out.println("=================================");

        Contact contact = new Contact(
                "Shashwat", "Dwivedi", "Rajajipuram",
                "Lucknow", "Uttar Pradesh",
                "226017", "9876543210", "sd@gmail.com");

        contact.displayContact();
    }
}

// Contact class (same file, NOT public)
class Contact {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;

    public Contact(String firstName, String lastName, String address,
                   String city, String state, String zip,
                   String phoneNumber, String email) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void displayContact() {
        System.out.println("\nContact Details:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("State: " + state);
        System.out.println("ZIP: " + zip);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }
}