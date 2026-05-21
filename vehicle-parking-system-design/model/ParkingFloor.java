package model;

public class ParkingFloor {

    private int floorId;
    private String floorName;

    public ParkingFloor(int floorId,
                        String floorName) {

        this.floorId = floorId;
        this.floorName = floorName;
    }

    public int getFloorId() {
        return floorId;
    }

    public String getFloorName() {
        return floorName;
    }
}

