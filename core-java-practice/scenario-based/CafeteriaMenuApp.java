import java.util.Scanner;

public class CafeteriaMenuApp {

    static String[] menuItems = {
        "Veg Sandwich",
        "Cheese Burger",
        "Pasta",
        "Pizza",
        "French Fries",
        "Coffee",
        "Tea",
        "Cold Drink",
        "Noodles",
        "Ice Cream"
    };

    // Method to display menu
    static void displayMenu() {
        System.out.println("----- Cafeteria Menu -----");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println(i + " : " + menuItems[i]);
        }
    }

    // Method to get item by index
    static String getItemByIndex(int index) {
        if (index >= 0 && index < menuItems.length) {
            return menuItems[index];
        }
        return "Invalid item selection";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        displayMenu();

        System.out.print("\nEnter item index to order: ");
        int choice = sc.nextInt();

        String orderedItem = getItemByIndex(choice);
        System.out.println("You ordered: " + orderedItem);

        sc.close();
    }
}