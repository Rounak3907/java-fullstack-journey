package corejava.Day_03_Inheritance_and_Polymorphism;

class Vehicle {
    protected String brand;
    Vehicle(String brand) {
        this.brand = brand;
        System.out.println("Vehicle constructor");
    }
    public void start() {
        System.out.println("Vehicle is starting");
    }
    public static void vehicleType() {
        System.out.println("Unknown");
    }
    final public void fuel() {
        System.out.println("Petrol");
    }
    public void move() {
        System.out.println("Vehicle moves");
    }

}

class Car extends Vehicle {

//    Method Overriding
//    Rule:
//    Same method name
//    Same parameters
//    Same return type (or covariant)
//    Cannot reduce visibility
//    Happens in child class
//    If a method is declared final, static, or private it cannot be overridden in a subclass.
Car(String brand) {
//    if there is no constructor in parent class, we do not need to write super, as java inserts a no params constructor by default, ans a "super()" by default, which implies to the no param super calling the no param  constructor.
//    When there is a constructor in parent class, we need to write super with correct parameters.
//    when there is a no argument constructor in parent class, we do not need to write super, as java by default adds "super()".
    super(brand);
    System.out.println("Car constructor");
}
    @Override
    public void start() {
    super.start();//Calls parent version.
        System.out.println("Car is starting");
    }
    //@Override // cannot over ride a static method,  it creates a new method.
    public static void vehicleType() {
        System.out.println("Car");
    }
    //cannot override final methods, throws error.
//    @Override
//    public void fuel() {
//        System.out.println("Diesel");
//    }
    public void drive() {
        System.out.println("Car is driving");
    }
    public void move() {
        System.out.println("Car moves");
    }
}

class Bike extends Vehicle {
    Bike(String brand) {
        super(brand);
    }
    @Override
    public void move() {
        System.out.println("Bike moves");
    }
}
//private     → only this class
//default     → same package
//protected   → same package + subclasses
//public      → everywhere

//when a method, field is called, the accessibility is always checked through, from which class it is being accessed, not through which method
public class Main {
    public static void main(String[] args) {
        Car c = new Car("Toyota");
        c.start();  // inherited method
        c.drive();  // own method
        //Casting
        //casting only works between inherited classes
        Vehicle v = new Car("Toyota"); // Upcasting
        // Down casting

        Vehicle v1 = new Vehicle("Toyota");
        //Car c1 = (Car) v1; //compiles but throws error at runtime, as the actual object is not of Car type

        Car c2 = (Car) v; // No Error, as the actual object is of Car type.


        v.vehicleType(); // executes vehicle clss method, even the object it contains,is a car type, and car has its own fuel method, as its a static method
        Vehicle v2 = new Bike("Ducati");
        v.move();
        v2.move();
//        One reference type → multiple behaviors.
//        That is REAL polymorphism.

    }
}


//NOTES


//overriding