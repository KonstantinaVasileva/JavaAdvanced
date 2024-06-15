package Advanced.DefiningClasses.Exercise.SpeedRacing_03;

public class Car {
    //Model, fuel amount, fuel cost for 1 kilometer, and distance traveled
    private String model;
    private double fuelAmount;
    private double fuelCostFor1km;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostFor1km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostFor1km = fuelCostFor1km;
        this.distanceTraveled = 0;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(int kilometers) {
        fuelAmount -= fuelCostFor1km * kilometers;
    }

    public void setDistanceTraveled(int kilometers) {
        this.distanceTraveled = this.distanceTraveled + kilometers;
    }

    public boolean isEnoughFuel(int kilometers) {
        return fuelCostFor1km * kilometers <= fuelAmount;
    }
}
