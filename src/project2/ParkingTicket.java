package project2;

import java.time.LocalDateTime;

public class ParkingTicket {

    private final String ticketId;
    private final Vehicles vehicle;
    private final ParkingSlot parkingSlot;
    private final LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public ParkingTicket(String ticketId, Vehicles vehicle, ParkingSlot parkingSlot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.entryTime = LocalDateTime.now();
    }

    public void closeTicket (){
        this.exitTime = LocalDateTime.now();
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public String getTicketId() {
        return ticketId;
    }
}