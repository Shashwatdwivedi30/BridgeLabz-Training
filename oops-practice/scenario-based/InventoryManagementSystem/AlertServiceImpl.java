package InventoryManagementSystem;

interface AlertService {
    void sendLowStockAlert(Product product);
}


public class AlertServiceImpl implements AlertService {

    @Override
    public void sendLowStockAlert(Product product) {
        System.out.println(
            "Low Stock Alert: " + product.getName() +" | Remaining: " + product.getQuantity());
    }
}