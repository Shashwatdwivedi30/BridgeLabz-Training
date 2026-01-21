import java.util.*;

abstract class WarehouseItem {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    abstract void displayInfo();
}

class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }

    void displayInfo() {
        System.out.println("Electronics: " + name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }

    void displayInfo() {
        System.out.println("Grocery: " + name);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }

    void displayInfo() {
        System.out.println("Furniture: " + name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    List<T> getItems() {
        return items;
    }
}

class WarehouseUtil {
    static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            item.displayInfo();
        }
    }
}

public class WarehouseManagementSystem {
    public static void main(String[] args) {

        Storage<Electronics> electronics = new Storage<>();
        Storage<Groceries> groceries = new Storage<>();
        Storage<Furniture> furniture = new Storage<>();

        electronics.addItem(new Electronics("Laptop"));
        electronics.addItem(new Electronics("TV"));

        groceries.addItem(new Groceries("Rice"));
        groceries.addItem(new Groceries("Milk"));

        furniture.addItem(new Furniture("Chair"));
        furniture.addItem(new Furniture("Table"));

        System.out.println("---- Electronics ----");
        WarehouseUtil.displayItems(electronics.getItems());

        System.out.println("---- Groceries ----");
        WarehouseUtil.displayItems(groceries.getItems());

        System.out.println("---- Furniture ----");
        WarehouseUtil.displayItems(furniture.getItems());
    }
}