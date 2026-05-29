package project2;

public enum Vehicles {
    BIKE(1),
    CAR(2),
    TRUCK(3);

    private final int size;

    Vehicles(int size) {
        this.size = size;
    }

    public boolean canFit(Vehicles vehicleType) {
        return size >= vehicleType.size;
    }

}
