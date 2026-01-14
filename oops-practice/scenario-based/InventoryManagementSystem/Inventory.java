package InventoryManagementSystem;

import java.util.*;

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}


public class Inventory {
    private List<Product> products = new ArrayList<>();
    private AlertService alertService = new AlertServiceImpl();

    public void addProduct(Product product){
        products.add(product);
        System.out.println("Product added: " +product.getName());
    }

    public void updateStock(int productId, int amount) throws OutOfStockException{
        for(Product p : products){
            if(p.getId() == productId){
                p.reduceStock(amount);

                if(p.getQuantity() <= p.getMinStockLevel()){
                    alertService.sendLowStockAlert(p);
                }
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void showInventory(){
        System.out.println("\nInventory Status: ");
        for(Product p : products){
            System.out.println(p.getId()+ " | " +p.getName() + " | " + p.getQuantity());
        }
    }
}