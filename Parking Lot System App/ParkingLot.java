// Vijay Venkatesan
// Aug 22, 2025

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class ParkingLot {
    private int availableCarSpots;
    private int availableMotorcycleSpots;
    private int availableTruckSpots;
    private List<ParkingSpot> carSpots;
    private List<ParkingSpot> motorcycleSpots;
    private List<ParkingSpot> truckSpots;
    private HashMap<Vehicle, ParkingSpot> vehicleToSpotMap;


    public ParkingLot(int availableCarSpots, int availableMotorcycleSpots, int availableTruckSpots) {
        this.availableCarSpots = availableCarSpots;
        this.availableMotorcycleSpots = availableMotorcycleSpots;
        this.availableTruckSpots = availableTruckSpots;
        this.carSpots = new ArrayList<>(this.availableCarSpots);
        this.motorcycleSpots = new ArrayList<>(this.availableMotorcycleSpots);
        this.truckSpots = new ArrayList<>(this.availableTruckSpots);
        this.vehicleToSpotMap = new HashMap<>();

        for (int i = 0; i < this.availableCarSpots; i++) {
            this.carSpots.add(new ParkingSpot());
        }

        for (int i = 0; i < this.availableMotorcycleSpots; i++) {
            this.motorcycleSpots.add(new ParkingSpot());
        }

        for (int i = 0; i < this.availableTruckSpots; i++) {
            this.truckSpots.add(new ParkingSpot());
        }
    }
    
    public boolean assignParking(Vehicle vehicle) {
        if (this.vehicleToSpotMap.containsKey(vehicle)) {
            return false;
        }
        
        List<ParkingSpot> spotsList = getSpotsList(vehicle.getVehicleType());
        
        for (ParkingSpot spot: spotsList) {
            if (!spot.getIsOccupied()) {
                spot.setIsOccupied(true);
                decrementAvailableSpots(vehicle.getVehicleType());
                this.vehicleToSpotMap.put(vehicle, spot);
                return true;
            }
        }

        return false;
    }

    public boolean freeParkingSpot(Vehicle vehicle) {
        if (this.vehicleToSpotMap.containsKey(vehicle)) {
            ParkingSpot spot = this.vehicleToSpotMap.get(vehicle);
            spot.setIsOccupied(false);
            incrementAvailableSpots(vehicle.getVehicleType());
            this.vehicleToSpotMap.remove(vehicle);
            return true;
        }

        return false;
    }

    public void displayAvailableSpots() {
        System.out.println("Available Car Spots: " + this.availableCarSpots);
        System.out.println("Available Motorcycle Spots: " + this.availableMotorcycleSpots);
        System.out.println("Available Truck Spots: " + this.availableTruckSpots);    
    }

    private List<ParkingSpot> getSpotsList(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return this.carSpots;
            case MOTORCYCLE:
                return this.motorcycleSpots;
            case TRUCK:
                return truckSpots;
            default:
                return null;
        }
    }

    private void decrementAvailableSpots(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                if (this.availableCarSpots > 0) {
                    this.availableCarSpots--;
                }
                break;
            case MOTORCYCLE:
                if (this.availableMotorcycleSpots > 0) {
                    this.availableMotorcycleSpots--;
                }
                break;
            case TRUCK:
                if (availableTruckSpots > 0) {
                    this.availableTruckSpots--;
                }
                break;
            default:
                break;
        }
    }

    private void incrementAvailableSpots(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                this.availableCarSpots++;
                break;
            case MOTORCYCLE:
                this.availableMotorcycleSpots++;
            case TRUCK:
                this.availableTruckSpots++;
            default:
                break;
        }
    }
    
}
