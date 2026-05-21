package model;

public class ParkingSlot {

    private int slotId;
    private ParkingFloor floor;
    private boolean occupied;

    public ParkingSlot(int slotId,
                       ParkingFloor floor) {

        this.slotId = slotId;
        this.floor = floor;
    }

    public int getSlotId() {
        return slotId;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void occupy() {
        occupied = true;
    }

    public void release() {
        occupied = false;
    }
}