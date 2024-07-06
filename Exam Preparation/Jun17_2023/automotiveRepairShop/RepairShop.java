package Advanced.ExamPreparation.Jun17_2023.automotiveRepairShop;

import java.util.*;
import java.util.stream.Collectors;

public class RepairShop {
    private int capacity;
    private List<Vehicle> vehicles;

    public RepairShop(int capacity) {
        this.capacity = capacity;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicles.size() < capacity) {
            vehicles.add(vehicle);
        }
    }

    public boolean removeVehicle(String vin) {
        List<Vehicle> vehicleForRemove = vehicles.stream().filter(v -> v.getVIN().equals(vin)).collect(Collectors.toList());
        return vehicles.removeAll(vehicleForRemove);
    }

    public int getCount() {
        return this.vehicles.size();
    }

    public Vehicle getLowestMileage() {
        return vehicles.stream().min(Comparator.comparing(Vehicle::getMileage)).orElse(null);
    }

    public String report() {
        return String.format("Vehicles in the preparatory:\n" + vehicles.stream().map(Objects::toString).collect(Collectors.joining("\n")));

    }
}
