public class ParkingSpot {
    private boolean isOccupied;
    private VehicleType designatedVehicleType;

    public ParkingSpot(VehicleType designatedVehicleType) {
        this.isOccupied = false;
        this.designatedVehicleType = designatedVehicleType;
    }
    
}
