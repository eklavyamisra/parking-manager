import product1.Car;
import product1.ParkingManager;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");
        Car car4 = new Car("car4");
        Car car5 = new Car("car5");
        Car car6 = new Car("car6");
        Car car7 = new Car("car7");

        ParkingManager parkingManager = new ParkingManager();
        parkingManager.entry(car1);
        parkingManager.entry(car2);
        parkingManager.entry(car3);
        parkingManager.entry(car4);
        parkingManager.entry(car5);
        parkingManager.entry(car6);
        parkingManager.entry(car7);

        Thread.sleep(8000);
        parkingManager.exit(car1);

        Thread.sleep(9000);
        parkingManager.exit(car2);

        Thread.sleep(7000);
        parkingManager.exit(car3);
        parkingManager.entry(car7);
        parkingManager.check();
    }
}
