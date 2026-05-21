import model.ParkingFloor;
import model.ParkingSlot;
import model.Vehicle;
import model.VehicleType;
import service.ParkingService;

public class Main {

    public static void main(String[] args) {

        ParkingService service =
                new ParkingService();

        ParkingFloor f1 =
                new ParkingFloor(
                        1,
                        "Ground Floor"
                );

        ParkingFloor f2 =
                new ParkingFloor(
                        2,
                        "First Floor"
                );

        service.addFloor(f1);
        service.addFloor(f2);

        service.addSlot(
                new ParkingSlot(1,f1)
        );

        service.addSlot(
                new ParkingSlot(2,f1)
        );

        service.addSlot(
                new ParkingSlot(3,f2)
        );

        service.addSlot(
                new ParkingSlot(4,f2)
        );

        service.parkVehicle(
                new Vehicle(
                        "TN01AA1111",
                        VehicleType.CAR
                )
        );

        service.parkVehicle(
                new Vehicle(
                        "TN02BB2222",
                        VehicleType.BIKE
                )
        );

        service.parkVehicle(
                new Vehicle(
                        "TN03CC3333",
                        VehicleType.TRUCK
                )
        );

        service.occupancyReport();

        service.revenueReport();
    }
}