package corejava.Day_04_Abstract_Class_and_Interfaces;
abstract class Vehicle {
    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }
    abstract void move();
}
class Car extends Vehicle {

    Car(String brand) {
        super(brand);
    }

    @Override
    //Every subclass must provide its own implementation.
    void move() {
        System.out.println("Car drives");
    }
}
public class Main {
    public static void main(String[] args) {
        //Vehicle v = new Vehicle();  //❌error
        Vehicle v = new Car("Toyota");
//        v.move();
    }
}

//Notes
//An abstract class is:
//A class that cannot be instantiated.
//❌ Cannot create object of abstract class
// ❌ Cannot contain:
// Abstract+final
// Abstract+private
// Abstract+static


//Abstract class can contain:
//✔ Instance variables
//✔ Static variables
//✔ Constructors
//✔ Concrete methods
//✔ Abstract methods
//  Static Methods
//   Final Methods



//INTERFACE
//Java Does NOT Support Multiple Inheritance with Classes
//Because of a famous problem called the Diamond Problem
//       Animal
//       /   \
//     Dog   Cat
//       \   /
//       Hybrid
//class Animal {
//    void sound() { }
//}
//
//class Dog extends Animal {
//    void sound() { System.out.println("Bark"); }
//}
//
//class Cat extends Animal {
//    void sound() { System.out.println("Meow"); }
//}

//class Hybrid extends Dog, Cat {}
//Hybrid h = new Hybrid();
//h.sound();

//Then this would be ambiguous:
//Should it bark or meow?
//This confusion is the diamond problem.

//JAVA solves this using interfaces

interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {

    public void fly() {
        System.out.println("Duck flies");
    }

    public void swim() {
        System.out.println("Duck swims");
    }
}
//This works because interfaces originally contained only method declarations.
//No implementation → no conflict.

//All methods in an interface are implicitly abstract and public.
// Interfaces could also contain constants.
//int MAX_SPEED = 120;
//But the compiler actually treats it as:
//public static final int MAX_SPEED = 120;

//When implementing an interface method:The method must be public
// Each and every method defined in the interface must be implemented

//the two new kinds of methods added to interfaces in Java 8 are:

//Default methods: A default method is a method in an interface that has a body (implementation).
// Why Java Introduced Default Methods
//To allow adding new methods to interfaces without breaking existing implementations.

//Example problem before Java 8:
//If you added a new method to an interface, every class implementing it would break.
//Default methods solved this.

//Static methods: Static interface methods are called using the interface name, not through objects.

// Java 9 introduced:
//
//Private methods inside interfaces
//—but only to help reuse code between default methods.

interface Vehicle1 {

    default void start() {
        log();
    }

    private void log() {
        System.out.println("Starting vehicle...");
    }
}

// When two interfaces both have the same default method:
// interface A {
//    default void show() { System.out.println("A"); }
//}
//
//interface B {
//    default void show() { System.out.println("B"); }

//and a class does:
//class C implements A, B { }
//this will not compile, Because Java does not know which show() to inherit.A.show() ? OR B.show() ?
//Solution:Class must override the method.

//class C implements A, B {
//
//    @Override
//    public void show() {
//        System.out.println("Resolving conflict");
//    }
//
//}

//You Can Still Call Both Versions
//Inside the overriding method you can do:
//
//class C implements A, B {
//
//    @Override
//    public void show() {
//        A.super.show();
//        B.super.show();
//    }

//One More Important Interface Rule
//If an interface method conflicts with a method in a superclass, the class method wins.
class A {
    void show() {
        System.out.println("Class A");
    }
}

interface B {
    default void show() {
        System.out.println("Interface B");
    }
}

class C extends A implements B {
    public void display()
        {
        show();
    }

    @Override
    public void show() {
        B.super.show();
    }
//    @Override
//    public void show() {
//        B.super.show();
//    }
}

//Important Interface Feature
//Unlike classes, interfaces support multiple inheritance.

interface A {
    void show();
}

interface B {
    void display();
}

interface C extends A, B {
}

class D implements C {

    public void show() { }

    public void display() { }

}