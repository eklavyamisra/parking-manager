package project2;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class ParkingLot {

    private final ParkingSlot[] parkingSlots;

    /*
        Key   -> Vehicle Number
        Value -> Slot Number
     */
    private final Map<String, Integer> parkedVehicles =
            new HashMap<>();

    private final Map<String , ParkingTicket> activeTicket = new HashMap<>();

    public ParkingLot(int bikeSlots, int carSlots, int truckSlots) {
        if (bikeSlots < 0 || carSlots < 0 || truckSlots < 0) {
            throw new IllegalArgumentException("Slot counts cannot be negative.");
        }
        if (bikeSlots + carSlots + truckSlots < 1) {
            throw new IllegalArgumentException("Parking lot must have at least 1 slot.");
        }

        parkingSlots = new ParkingSlot[bikeSlots + carSlots + truckSlots];
        int index = 0;
        index = addSlots(index, bikeSlots, Vehicles.BIKE);
        index = addSlots(index, carSlots, Vehicles.CAR);
        addSlots(index, truckSlots, Vehicles.TRUCK);
    }

    public void parkVehicle(Vehicles vehicle) {

        validateVehicle(vehicle);

        ParkingSlot slot = getAvailableSlot(vehicle.getType());

        if (slot == null) {
            System.out.println("No Slot Available");
            return null;
        }

        slot.park(vehicle);

        String ticketId = java.util.UUID.randomUUID().toString();

        ParkingTicket ticket =
                new ParkingTicket(ticketId, vehicle, slot);

        activeTickets.put(ticketId, ticket);

        System.out.println("Vehicle parked successfully");
        System.out.println("Ticket Id : " + ticketId);
        System.out.println("Slot      : " + slot.getSlotNumber());
        System.out.println("EntryTime : " + ticket.getEntryTime());

        return ticketId;
    }

    public void exitVehicle(String vehicleNumber) {

        vehicleNumber = validateVehicle(vehicleNumber);

        Integer slotNumber = parkedVehicles.get(vehicleNumber);

        if (slotNumber == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        ParkingSlot parkingSlot =
                parkingSlots[slotNumber - 1];

        parkingSlot.vacate();

        parkedVehicles.remove(vehicleNumber);

        System.out.println(
                "Vehicle "
                        + vehicleNumber
                        + " exited from slot "
                        + slotNumber
        );
    }

    private ParkingSlot getAvailableSlot(Vehicles type) {

        for (ParkingSlot parkingSlot : parkingSlots) {

            if (parkingSlot.canPark(type)) {
                return parkingSlot;
            }
        }

        return null;
    }

    private String validateVehicle(String vehicleNumber) {

        if (vehicleNumber == null
                || vehicleNumber.trim().isEmpty()) {

            throw new IllegalArgumentException(
                    "Invalid vehicle number."
            );
        }

        return vehicleNumber.trim();
    }

    public void printParkingStatus() {

        System.out.println("\nParking Status:");

        for (ParkingSlot parkingSlot : parkingSlots) {

            if (parkingSlot.isOccupied()) {

                System.out.println(
                        "Slot "
                                + parkingSlot.getSlotNumber()
                                + " ("
                                + parkingSlot.getAllowedType()
                                + ")"
                                + " -> OCCUPIED by "
                                + parkingSlot.getVehicleNumber()
                );

            } else {

                System.out.println(
                        "Slot "
                                + parkingSlot.getSlotNumber()
                                + " ("
                                + parkingSlot.getAllowedType()
                                + ")"
                                + " -> AVAILABLE"
                );
            }
        }
    }

    private int addSlots(Integer index, int count, Vehicles allowedType) {
        for (int i = 0; i < count; i++) {
            parkingSlots[index] = new ParkingSlot(index + 1, allowedType);
            index++;
        }
        System.out.println(index);
        return index;
    }

}
