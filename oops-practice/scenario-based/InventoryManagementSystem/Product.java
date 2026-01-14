package InventoryManagementSystem;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int minStockLevel;

    public Product(int id, String name, int quantity, int minStockLevel) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.minStockLevel = minStockLevel;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getMinStockLevel() {
        return minStockLevel;
    }

    public void addStock(int amount) {
        quantity += amount;
    }

    public void reduceStock(int amount) throws OutOfStockException {
        if (amount > quantity) {
            throw new OutOfStockException("Not enough stock for " + name);
        }
        quantity -= amount;
    }
}