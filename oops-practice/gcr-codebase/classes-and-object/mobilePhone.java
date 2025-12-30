import java.util.Scanner;

class mobilePhone {
    String brand;
    String model;
    double price;

    void display() {
        System.out.println("Brand of mobile: " + brand);
        System.out.println("Model of mobile: " + model);
        System.out.println("Price of mobile: " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        mobilePhone m = new mobilePhone();

        System.out.print("Enter mobile brand: ");
        m.brand = sc.nextLine();

        System.out.print("Enter mobile model: ");
        m.model = sc.nextLine();

        System.out.print("Enter mobile price: ");
        m.price = sc.nextDouble();

        m.display();
        sc.close();
    }
}
