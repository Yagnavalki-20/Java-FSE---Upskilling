// Car class definition
public class Car {
    // Attributes
    String make;
    String model;
    int year;

    // Constructor to initialize the Car object
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Car Make: " + make);
        System.out.println("Car Model: " + model);
        System.out.println("Manufacturing Year: " + year);
        System.out.println("---------------------------");
    }

    // Main method to create objects and test
    public static void main(String[] args) {
        // Create first car object
        Car car1 = new Car("Toyota", "Camry", 2020);
        // Create second car object
        Car car2 = new Car("Honda", "Civic", 2018);

        // Call displayDetails method for each car
        car1.displayDetails();
        car2.displayDetails();
    }
}
