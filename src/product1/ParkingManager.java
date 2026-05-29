package product1;

public class ParkingManager {
    private final ParkingSlot parkingSlot;

    public ParkingManager() {
        parkingSlot = new ParkingSlot();
    }

    public void entry(Car car) {
        parkingSlot.enterCar(car.getNumberPlate());
    }

    public void exit(Car car) {
        parkingSlot.removeCar(car.getNumberPlate());
    }

    public void check() {
        parkingSlot.checkSlot();
    }
}
