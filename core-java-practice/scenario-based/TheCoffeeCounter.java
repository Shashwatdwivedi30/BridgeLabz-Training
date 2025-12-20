// Problem Statement : The Coffee Counter Chronicles ☕
// Ravi runs a café. Each customer orders different coffee types with quantities. Write a program
// that:
// ● Asks for coffee type (switch)
// ● Calculates total bill (price * quantity)
// ● Adds GST using arithmetic operators
// Use while to continue for the next customer and break when "exit" is typed.
import java.util.*;

public class TheCoffeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //while loop for next customers
        while (true){
            System.out.println("Enter coffee type (Latte, Espresso, Cappuccino, Mocha) or type 'exit' to stop:");
            String coffee = sc.next();

            //"exit" to break the loop
            if (coffee.equalsIgnoreCase("exit")) {
                System.out.println("Thank you for visiting Ravi's Café ☕");
                break;
            }
            System.out.println("Enter quantity:");
            int quantity = sc.nextInt();
            double bill = 0.0;

            //Switch case to choose different type of coffee's
            switch (coffee) {
                case "Latte":{
                    bill = 180 * quantity;
                    break;
                }
                case "Espresso":{
                    bill = 199 * quantity;
                    break;
                }
                case "Cappuccino":{
                    bill = 150 * quantity;
                    break;
                }
                case "Mocha":{
                    bill = 229 * quantity;
                    break;
                }
                default:{
                    System.out.println("Invalid coffee type!");
                    continue;
                }
            }
            double GST = bill * 0.18;             //GST on the bill
            double total_bill = bill + GST;       //Total bill of the coffee along with GST
            System.out.println("The total bill is "+total_bill);
        } 
    }
}