package InventoryManagementSystem;

public class InventoryManagementSystem {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product(101, "Keyboard", 10, 3);
        Product p2 = new Product(102, "CPU", 5, 2);

        inventory.addProduct(p1);
        inventory.addProduct(p2);

        try{
            inventory.updateStock(101, 9);
            inventory.updateStock(102, 6);
        }
        catch(OutOfStockException e){
            System.out.println(e.getMessage());
        }

        inventory.showInventory();
    }
}