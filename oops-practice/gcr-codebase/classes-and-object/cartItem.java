import java.util.Scanner;

class cartItem {
    String itemName;
    double price;
    int quantity;

    void addItem(int qty) {
        quantity = quantity + qty;
        System.out.println("Added " + qty + " of " + itemName + " to the cart.");
    }

    void removeItem(int qty) {
        if (quantity >= qty) {
            quantity = quantity - qty;
            System.out.println("Removed " + qty + " of " + itemName + " from the cart.");
        } else {
            System.out.println("Cannot remove more items than available.");
        }
    }

    void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Total cost: $" + total);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cartItem cart = new cartItem();

        System.out.print("Enter item name: ");
        cart.itemName = sc.nextLine();

        System.out.print("Enter item price: ");
        cart.price = sc.nextDouble();

        System.out.print("Enter initial quantity: ");
        cart.quantity = sc.nextInt();

        System.out.println("\nItem: " + cart.itemName +
                ", Price: $" + cart.price +
                ", Quantity: " + cart.quantity);

        System.out.print("\nEnter quantity to add: ");
        int addQty = sc.nextInt();
        cart.addItem(addQty);

        System.out.print("Enter quantity to remove: ");
        int removeQty = sc.nextInt();
        cart.removeItem(removeQty);

        cart.displayTotalCost();
        sc.close();
    }
}