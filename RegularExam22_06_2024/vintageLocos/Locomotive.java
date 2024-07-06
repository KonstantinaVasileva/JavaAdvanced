package Advanced.RegularExam22_06_2024.vintageLocos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Locomotive {
    private String name;
    private String builder;
    private LocalDate buildData;
    private int gouge;
    private int weight;
    private int maxSpeed;

    public Locomotive(String name, String builder, LocalDate buildData, int gouge, int weight, int maxSpeed) {
        this.name = name;
        this.builder = builder;
        this.buildData = buildData;
        this.gouge = gouge;
        this.weight = weight;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public String getBuilder() {
        return builder;
    }

    public LocalDate getBuildData() {
        return buildData;
    }

    public int getGouge() {
        return gouge;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString(){
        return String.format("This %s is made by %s at %s.",
                this.name, this.builder, this.buildData.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")));
    }
}
