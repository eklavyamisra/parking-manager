package product1;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ParkingSlot {
    private final ParkingTicket[] parkingSlots = new ParkingTicket[6];
    private final Map<String, ParkingTicket> parkedCars = new HashMap<>();
    private int count = 0;
    private final int priceForSec = 5;

    public void enterCar(String numberPlate) {
        if (isParked(numberPlate)) {
            System.out.println("Vehicle " + numberPlate + " is already parked");
            return;
        }

        if (count == parkingSlots.length) {
            System.out.println("Slot is full");
            return;
        }

        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i] == null) {
                int slotNumber = i + 1;
                ParkingTicket ticket = new ParkingTicket(numberPlate, slotNumber, LocalTime.now());
                parkingSlots[i] = ticket;
                parkedCars.put(numberPlate, ticket);
                count++;
                System.out.println("Your vehicle " + numberPlate + " has been parked at slot " + slotNumber + " at " + ticket.getEntryTime());
                return;
            }
        }
    }

    public void removeCar(String numberPlate) {
        ParkingTicket ticket = parkedCars.remove(numberPlate);
        if (ticket == null) {
            System.out.println("Vehicle " + numberPlate + " is not parked");
            return;
        }

        for (int i = 0; i < parkingSlots.length; i++) {
            if (parkingSlots[i] == ticket) {
                parkingSlots[i] = null;
                count--;
                LocalTime exitTime = LocalTime.now();
                System.out.println("Vehicle " + numberPlate + " has been removed from slot " + ticket.getSlotNumber());
                payment(ticket, exitTime);
                return;
            }
        }
    }

    public void checkSlot() {
        for (int i = 0; i < parkingSlots.length; i++) {
            int index = i + 1;
            ParkingTicket ticket = parkingSlots[i];
            if (ticket == null) {
                System.out.println("Slot " + index + " is free");
            } else {
                System.out.println("Slot no. " + index + " is occupied by car no. " + ticket.getNumberPlate());
            }
        }
    }

    private void payment(ParkingTicket ticket, LocalTime exitTime) {
        Duration gap = Duration.between(ticket.getEntryTime(), exitTime);
        long seconds = gap.toSeconds();
        System.out.println("product1.Car no. " + ticket.getNumberPlate() + ", your bill is " + (priceForSec * seconds) + "$. Total parking time is " + seconds + " sec");
    }

    private boolean isParked(String numberPlate) {
        return parkedCars.containsKey(numberPlate);
    }
}
