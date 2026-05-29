package product1;

import java.time.LocalTime;

public class ParkingTicket {
    private final String numberPlate;
    private final int slotNumber;
    private final LocalTime entryTime;

    public ParkingTicket(String numberPlate, int slotNumber, LocalTime entryTime) {
        this.numberPlate = numberPlate;
        this.slotNumber = slotNumber;
        this.entryTime = entryTime;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }
}
