package model;

import java.time.LocalDateTime;

public class ParkingTicket {

    private int ticketId;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double amount;

    public ParkingTicket(int ticketId,
                         Vehicle vehicle,
                         ParkingSlot slot,
                         double amount) {

        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.amount = amount;

        this.entryTime = LocalDateTime.now();
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public double getAmount() {
        return amount;
    }

    public void exit() {
        exitTime = LocalDateTime.now();
    }
}