package Advanced.DefiningClasses.Exercise.Google_07;

public class Car {
    private String model;
    private int speed;

    public String getModel() {
        return model;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.model, this.speed);
    }
}
