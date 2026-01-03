interface Worker {
    void performDuties();
}

class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

class Chef extends Person implements Worker {

    Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Chef is preparing and cooking meals.");
    }
}

class Waiter extends Person implements Worker {

    Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Waiter is taking orders and serving food.");
    }
}

public class RestaurantManagementSystem {
    public static void main(String[] args) {

        Worker chef = new Chef("Rahul", 101);
        Worker waiter = new Waiter("Amit", 102);

        ((Person) chef).displayInfo();
        chef.performDuties();
        System.out.println();

        ((Person) waiter).displayInfo();
        waiter.performDuties();
    }
}