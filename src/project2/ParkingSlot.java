package project2;

class ParkingSlot {

    private final int slotNumber;
    private final Vehicles allowedType;
    private String vehicleNumber;

    public ParkingSlot(int slotNumber, Vehicles allowedType) {
        this.slotNumber = slotNumber;
        this.allowedType = allowedType;
    }

    public Vehicles getAllowedType() {
        return allowedType;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public boolean isOccupied() {
        return vehicleNumber != null;
    }

    public boolean canPark(Vehicles vehicleType) {
        return !isOccupied() && allowedType.canFit(vehicleType);
    }

    public void park(String vehicleNumber, Vehicles vehicleType) {
        if (!canPark(vehicleType)) {
            throw new IllegalStateException("Vehicle is not compatible with this slot.");
        }
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void vacate() {
        vehicleNumber = null;
    }
}
