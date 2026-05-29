package project2;

public class ParkingManager {

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(2, 2, 1);

        parkingLot.parkVehicle("BIKE123", Vehicles.BIKE);
        parkingLot.parkVehicle("RJ22CA1234", Vehicles.CAR);
        parkingLot.parkVehicle("TRUCK999", Vehicles.TRUCK);
        parkingLot.parkVehicle("RJ19AB5678", Vehicles.CAR);

        parkingLot.printParkingStatus();

        parkingLot.exitVehicle("RJ22CA1234");

        parkingLot.printParkingStatus();
    }
}
