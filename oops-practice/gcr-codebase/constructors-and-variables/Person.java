public class Person {
    // Private attributes
    private String name;
    private int age;

    // Parameterized constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    public Person(Person p) {
        this.name = p.name;
        this.age = p.age;
    }

    // Method to display person details
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {

        // Original object
        Person p1 = new Person("Shashwat", 22);

        // Cloned object using copy constructor
        Person p2 = new Person(p1);

        p1.display();
        System.out.println();
        p2.display();
    }
}