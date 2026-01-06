import java.util.*;

class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return name + " - " + phoneNumber;
    }
}

public class ContactManager {
    private List<Contact> contacts = new ArrayList<>();

    public void addContact(String name, String phoneNumber)
            throws InvalidPhoneNumberException {

        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException(
                    "Phone number must be exactly 10 digits");
        }

        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Duplicate contact not allowed.");
                return;
            }
        }

        contacts.add(new Contact(name, phoneNumber));
        System.out.println("Contact added successfully.");
    }

    public void deleteContact(String phoneNumber) {
        Iterator<Contact> it = contacts.iterator();
        while (it.hasNext()) {
            if (it.next().getPhoneNumber().equals(phoneNumber)) {
                it.remove();
                System.out.println("Contact deleted.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void searchContact(String phoneNumber) {
        for (Contact c : contacts) {
            if (c.getPhoneNumber().equals(phoneNumber)) {
                System.out.println("Found: " + c);
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {

        ContactManager manager = new ContactManager();

        try {
            manager.addContact("Alice", "9876543210");
            manager.addContact("Bob", "1234567890");
            manager.addContact("Alice2", "9876543210"); 
            manager.addContact("Invalid", "12345");    
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Exception: " + e.getMessage());
        }
        manager.searchContact("9876543210");
        manager.deleteContact("1234567890");
        manager.displayContacts();
    }
}