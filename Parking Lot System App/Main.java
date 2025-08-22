// Vijay Venkatesan
// Aug 22, 2025

public class Main {
    public static void main(String[] args) {
        int numCarSpots = 2;
        int numMotorcycleSpots = 2;
        int numTruckSpots = 1;

        ParkingLot lot = new ParkingLot(
            numCarSpots,
            numMotorcycleSpots,
            numTruckSpots
        );
        
        Vehicle car1 = new Vehicle(VehicleType.CAR);
        Vehicle car2 = new Vehicle(VehicleType.CAR);
        Vehicle bike1 = new Vehicle(VehicleType.MOTORCYCLE);
        Vehicle truck1 = new Vehicle(VehicleType.TRUCK);

        System.out.println("Parking car1: " + lot.assignParking(car1));
        System.out.println("Parking car2: " + lot.assignParking(car2));
        System.out.println("Parking bike1: " + lot.assignParking(bike1));
        System.out.println("Parking truck1: " + lot.assignParking(truck1));

        Vehicle car3 = new Vehicle(VehicleType.CAR);
        System.out.println("Parking car3: " + lot.assignParking(car3));

        lot.displayAvailableSpots();

        System.out.println("Double-parking car1: " + lot.assignParking(car1));

        System.out.println("Freeing car1: " + lot.freeParkingSpot(car1));
        System.out.println("Parking car3: " + lot.assignParking(car3));

        System.out.println("Freeing car1 again: " + lot.freeParkingSpot(car1));

        lot.displayAvailableSpots();

    }
    
}
