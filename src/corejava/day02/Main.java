package corejava.day02;
class Car {
    private String brand= "unknown";  // This will store the car’s brand
    private int year=0;     // This will store the year of the car
    Car (){}
    Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }
    public void printDetails() {
        System.out.println("Car: " + brand + ", Year: " + year);
    }
    public void updateYear(int newYear) {
        this.year = newYear;
    }
}
public class Main {
    public static void main(String[] args) {
        Car myCar1 = new Car();
        Car myCar = new Car("Toyota", 2015);
        myCar.printDetails();
        myCar.updateYear(2022);
        myCar.printDetails();
        myCar1.printDetails();
    }
}
