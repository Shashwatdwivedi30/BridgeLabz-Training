import java.util.Scanner;
class item {
    String itemCode;
    String itemName;
    double price;

    void display(int quantity) {
        double totalCost = price * quantity;

        System.out.println("itemCode : " + itemCode);
        System.out.println("itemPrice : " + price);
        System.out.println("itemName : " + itemName);
        System.out.println("Total Cost : " + totalCost);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        item item = new item();

        System.out.print("Enter item code: ");
        item.itemCode = sc.nextLine();

        System.out.print("Enter item name: ");
        item.itemName = sc.nextLine();

        System.out.print("Enter item price: ");
        item.price = sc.nextDouble();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        item.display(quantity);
        sc.close();
    }
}