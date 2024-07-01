package Advanced.ExamPreparation.Apr12_2023.magazine;

public class Cloth {
    private String color;
    private int size;
    private String type;

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    public Cloth(String color, int size, String type) {
        this.color = color;
        this.size = size;
        this.type = type;
    }

    @Override
    public String toString(){
        return String.format("Product: %s with size %s, color %s\n", type, size  ,color);
    }
}
