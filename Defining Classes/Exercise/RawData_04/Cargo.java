package Advanced.DefiningClasses.Exercise.RawData_04;

public class Cargo {
    private int weight;
    private String type;

    public String getType() {
        return type;
    }

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }
}
