class Animal {
    String name;
    int age;

    // Constructor
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Subclass Dog
class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }
    @Override
    void makeSound() {
        System.out.println(name + " says: Bark");
    }
}

// Subclass Cat
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }
    @Override
    void makeSound() {
        System.out.println(name + " says: Meow");
    }
}

// Subclass Bird
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }
    @Override
    void makeSound() {
        System.out.println(name + " says: Chirp");
    }
}

// Main class
public class AnimalHierarchy {
    public static void main(String[] args) {
        // Polymorphism
        Animal a1 = new Dog("Buddy", 3);
        Animal a2 = new Cat("Whiskers", 2);
        Animal a3 = new Bird("Tweety", 1);

        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}
