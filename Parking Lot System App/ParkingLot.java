import java.util.List;
import java.util.ArrayList;

public class ParkingLot {
    private int availableCarSpots;
    private int availableMotorcycleSpots;
    private int availableTruckSpots;
    private List<ParkingSpot> carSpots;
    private List<ParkingSpot> motorcycleSpots;
    private List<ParkingSpot> truckSpots;

    public ParkingLot(int availableCarSpots, int availableMotorcycleSpots, int availableTruckSpots) {
        this.availableCarSpots = availableCarSpots;
        this.availableMotorcycleSpots = availableMotorcycleSpots;
        this.availableTruckSpots = availableTruckSpots;
        this.carSpots = new ArrayList<>(this.availableCarSpots);
        this.motorcycleSpots = new ArrayList<>(this.availableMotorcycleSpots);
        this.truckSpots = new ArrayList<>(this.availableTruckSpots);

        for (int i = 0; i < this.availableCarSpots; i++) {
            this.carSpots.add(new ParkingSpot(VehicleType.CAR));
        }

        for (int i = 0; i < this.availableMotorcycleSpots; i++) {
            this.motorcycleSpots.add(new ParkingSpot(VehicleType.MOTORCYCLE));
        }

        for (int i = 0; i < this.availableTruckSpots; i++) {
            this.truckSpots.add(new ParkingSpot(VehicleType.TRUCK));
        }
    }
    
    public boolean asssignParking(Vehicle vehicle) {
        boolean parkedVehicle = false;

        if ((vehicle.getVehicleType() == VehicleType.CAR) &&
            (this.availableCarSpots > 0)) {
                this.availableCarSpots -= 1;
                int last_index = this.carSpots.size() - 1;
                ParkingSpot parkingSpot = this.carSpots.get(last_index);
                parkingSpot.setIsOccupied(true);
                parkedVehicle = true;
            } else if ((vehicle.getVehicleType() == VehicleType.MOTORCYCLE) && 
                        (this.availableMotorcycleSpots > 0)) {
                            this.availableMotorcycleSpots -= 1;
                            int last_index = this.motorcycleSpots.size() - 1;
                            ParkingSpot parkingSpot = this.motorcycleSpots.get(last_index);
                            parkingSpot.setIsOccupied(true);
                            parkedVehicle = true;
            } else if ((vehicle.getVehicleType() == VehicleType.TRUCK) && 
                        (this.availableTruckSpots > 0)) {
                            this.availableTruckSpots -= 1;
                            int last_index = this.truckSpots.size() - 1;
                            ParkingSpot parkingSpot = this.truckSpots.get(last_index);
                            parkingSpot.setIsOccupied(true);
                            parkedVehicle = true;
            }
        
        return parkedVehicle;
    }

    public void freeParkingSpot(Vehicle vehicle) {

    }

    public void displayAvailableSpots() {
        
    }
    
}
