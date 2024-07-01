package Advanced.ExamPreparation.Apr12_2023.magazine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Magazine {
    private String type;
    private int capacity;
    private List<Cloth> data;

    public Magazine(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addCloth(Cloth cloth) {
        if (capacity > data.size()) {
            data.add(cloth);
        }
    }

    public boolean removeCloth(String color) {
        return data.removeIf(e -> e.getColor().equals(color));
    }

    public Cloth getSmallestCloth() {
        return data.stream().min(Comparator.comparing(Cloth::getSize)).orElse(null);
    }

    public Cloth getCloth(String color) {
        return data.stream().filter(e -> e.getColor().equals(color)).findFirst().orElse(null);
    }

    public int getCount() {
        return data.size();
    }

    public String report() {
        String output = String.format("%s magazin contains\n", type);
        output += String.join("\n", data.stream().map(String::valueOf).collect(Collectors.joining()));
        return output;
    }
}
