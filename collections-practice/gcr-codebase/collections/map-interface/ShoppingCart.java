import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        HashMap<String, Integer> prices = new HashMap<>();
        prices.put("Apple", 3);
        prices.put("Banana", 1);
        prices.put("Milk", 4);

        LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();
        addToCart("Apple", cart);
        addToCart("Milk", cart);
        addToCart("Banana", cart);

        System.out.println("Cart Order (LinkedHashMap): " + cart);

        TreeMap<String, Integer> sortedByPrice = new TreeMap<>(Comparator.comparingInt(prices::get));
        sortedByPrice.putAll(prices);

        System.out.println("Products sorted by price (TreeMap): " + sortedByPrice);
    }

    static void addToCart(String item, LinkedHashMap<String, Integer> cart) {
        cart.put(item, cart.getOrDefault(item, 0) + 1);
    }
}