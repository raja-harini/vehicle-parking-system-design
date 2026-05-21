package service;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingService {

    private List<ParkingFloor> floors =
            new ArrayList<>();

    private List<ParkingSlot> slots =
            new ArrayList<>();

    private List<ParkingTicket> tickets =
            new ArrayList<>();

    private int ticketCounter = 1;

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void addSlot(ParkingSlot slot) {
        slots.add(slot);
    }

    public void parkVehicle(Vehicle vehicle) {

        for(ParkingSlot slot : slots) {

            if(!slot.isOccupied()) {

                slot.occupy();

                ParkingTicket ticket =
                        new ParkingTicket(
                                ticketCounter++,
                                vehicle,
                                slot,
                                generateAmount(
                                        vehicle
                                )
                        );

                tickets.add(ticket);

                System.out.println(
                        "\nVEHICLE PARKED"
                );

                System.out.println(
                        "Ticket ID : "
                                + ticket.getTicketId()
                );

                System.out.println(
                        "Vehicle : "
                                + vehicle.getVehicleNumber()
                );

                System.out.println(
                        "Floor : "
                                + slot.getFloor()
                                .getFloorName()
                );

                return;
            }
        }

        System.out.println(
                "NO SLOT AVAILABLE"
        );
    }

    private double generateAmount(
            Vehicle vehicle) {

        switch(vehicle.getVehicleType()) {

            case CAR:
                return 200;

            case BIKE:
                return 100;

            case TRUCK:
                return 400;
        }

        return 0;
    }

    public void occupancyReport() {

        Map<Integer,Integer> occupiedMap =
                new HashMap<>();

        Map<Integer,String> floorMap =
                new HashMap<>();

        for(ParkingSlot slot : slots) {

            if(slot.isOccupied()) {

                int floorId =
                        slot.getFloor()
                                .getFloorId();

                floorMap.put(
                        floorId,
                        slot.getFloor()
                                .getFloorName()
                );

                occupiedMap.put(
                        floorId,
                        occupiedMap.getOrDefault(
                                floorId,
                                0
                        ) + 1
                );
            }
        }

        List<Map.Entry<Integer,Integer>>
                list =
                new ArrayList<>(
                        occupiedMap.entrySet()
                );

        list.sort(
                (a,b) ->
                        b.getValue()
                                - a.getValue()
        );

        System.out.println(
                "\nOCCUPANCY REPORT"
        );

        for(Map.Entry<Integer,Integer>
                entry : list) {

            System.out.println(
                    "Floor ID : "
                            + entry.getKey()
            );

            System.out.println(
                    "Floor Name : "
                            + floorMap.get(
                            entry.getKey()
                    )
            );

            System.out.println(
                    "Occupied Slots : "
                            + entry.getValue()
            );

            System.out.println();
        }
    }

    public void revenueReport() {

        Map<VehicleType,Double> revenue =
                new HashMap<>();

        for(ParkingTicket ticket
                : tickets) {

            VehicleType type =
                    ticket.getVehicle()
                            .getVehicleType();

            revenue.put(
                    type,
                    revenue.getOrDefault(
                            type,
                            0.0
                    ) + ticket.getAmount()
            );
        }

        List<Map.Entry<VehicleType,Double>>
                list =
                new ArrayList<>(
                        revenue.entrySet()
                );

        list.sort(
                (a,b) ->
                        Double.compare(
                                b.getValue(),
                                a.getValue()
                        )
        );

        System.out.println(
                "\nREVENUE REPORT"
        );

        for(Map.Entry<VehicleType,Double>
                entry : list) {

            System.out.println(
                    "Vehicle Type : "
                            + entry.getKey()
            );

            System.out.println(
                    "Revenue : ₹"
                            + entry.getValue()
            );

            System.out.println();
        }
    }
}