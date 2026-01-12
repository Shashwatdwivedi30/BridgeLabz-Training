public class InventorySystem {

    // Node class
    static class Item {
        int itemId;
        String itemName;
        int quantity;
        double price;
        Item next;

        Item(int itemId, String itemName, int quantity, double price) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }
    }

    static Item head = null;

    // Add item at end
    static void addItem(int id, String name, int qty, double price) {
        Item newItem = new Item(id, name, qty, price);

        if (head == null) {
            head = newItem;
            return;
        }

        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // Remove item by ID
    static void removeItem(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Update quantity
    static void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                return;
            }
            temp = temp.next;
        }
    }

    // Search item by ID
    static void searchItem(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                System.out.println("Item Found: " + temp.itemName +
                        ", Qty: " + temp.quantity +
                        ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found");
    }

    // Calculate total inventory value
    static void totalValue() {
        double total = 0;
        Item temp = head;

        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: " + total);
    }

    // Display inventory
    static void displayItems() {
        Item temp = head;
        while (temp != null) {
            System.out.println(
                    temp.itemId + " | " +
                    temp.itemName + " | Qty: " +
                    temp.quantity + " | Price: " +
                    temp.price
            );
            temp = temp.next;
        }
    }

    // Sort by Item Name (Ascending)
    static void sortByName() {
        if (head == null) return;

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (i.itemName.compareToIgnoreCase(j.itemName) > 0) {
                    swapData(i, j);
                }
            }
        }
    }

    // Sort by Price (Ascending)
    static void sortByPrice() {
        if (head == null) return;

        for (Item i = head; i.next != null; i = i.next) {
            for (Item j = i.next; j != null; j = j.next) {
                if (i.price > j.price) {
                    swapData(i, j);
                }
            }
        }
    }

    // Swap data between two nodes
    static void swapData(Item a, Item b) {
        int tempId = a.itemId;
        String tempName = a.itemName;
        int tempQty = a.quantity;
        double tempPrice = a.price;

        a.itemId = b.itemId;
        a.itemName = b.itemName;
        a.quantity = b.quantity;
        a.price = b.price;

        b.itemId = tempId;
        b.itemName = tempName;
        b.quantity = tempQty;
        b.price = tempPrice;
    }

    // Main method
    public static void main(String[] args) {

        addItem(101, "Pen", 50, 10);
        addItem(102, "Notebook", 20, 50);
        addItem(103, "Pencil", 100, 5);
        addItem(104, "Eraser", 30, 8);

        System.out.println("Inventory List:");
        displayItems();

        sortByName();
        System.out.println("\nSorted by Item Name:");
        displayItems();

        sortByPrice();
        System.out.println("\nSorted by Price:");
        displayItems();

        totalValue();
    }
}