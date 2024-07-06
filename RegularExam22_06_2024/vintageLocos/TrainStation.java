package Advanced.RegularExam22_06_2024.vintageLocos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TrainStation {
    private String name;
    private int capacity;
    private int railGauge;
    private List<Locomotive> locomotives;

    public TrainStation(String name, int capacity, int railGauge) {
        this.name = name;
        this.capacity = capacity;
        this.railGauge = railGauge;
        this.locomotives = new ArrayList<>();
    }

    //•	Method addLocomotive(Locomotive locomotive) – adds an entity to the collection of locomotives
    // if a space for it and the rail gauge of the station matches the gauge of the locomotive, otherwise print:

    public void addLocomotive(Locomotive locomotive) {
        if (locomotives.size() == capacity) {
            System.out.println("This train station is full!");
        } else if (locomotive.getGouge() != railGauge) {
            System.out.printf("The rail gauge of this station does not match the locomotive gauge! Difference: %s mm\n",
                    Math.abs(railGauge - locomotive.getGouge()));
        } else {
            locomotives.add(locomotive);
        }
    }

    //o	"This train station is full!"
    //If the rail gauge of the station does not match the gauge of the locomotive print:
    //o	"The rail gauge of this station does not match the locomotive gauge! Difference:
    // {the difference between the station gauge and the locomotive gauge in absolute value} mm."

    public boolean removeLocomotive(String name) {
        return locomotives.removeIf(e -> e.getName().equals(name));
    }

    //•	Method removeLocomotive(String name) – removes a Locomotive by given name, if such exists,
    // and returns boolean (true if it is removed, otherwise – false)

    public String getFastestLocomotive() {
        if (locomotives.isEmpty()) {
            return "There are no locomotives.";
        }

        Locomotive fastestLocomotive = locomotives.stream().max(Comparator.comparing(Locomotive::getMaxSpeed)).orElse(null);

        return String.format("%s is the fastest locomotive with a maximum speed of %s km/h.",
                fastestLocomotive.getName(), fastestLocomotive.getMaxSpeed());
    }

    //•	Method getFastestLocomotive()– returns String - the fastest locomotive by the speed in the given train station if there is one,
    // in the following format:
    //o	"{locomotive name} is the fastest locomotive with a maximum speed of {locomotive maxSpeed} km/h."
    //If there are no locomotives in the station print:
    //o	"There are no locomotives."

    public Locomotive getLocomotive(String name) {
        return locomotives.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
    }

    //•	Method getLocomotive(String name) – returns the locomotive with the given name, otherwise – returns null

    public int getCount() {
        return locomotives.size();
    }

    //•	Method getCount() – returns the count of locomotives in the given train station

    public String getOldestLocomotive() {
        Locomotive locomotive = locomotives.stream().min(Comparator.comparing(Locomotive::getBuildData)).orElse(null);
        if (locomotive == null) {
            return "There are no locomotives.";
        }
        return locomotive.getName();
    }

    //•	Method getOldestLocomotive() – returns String – the name of the oldest Locomotive in the given train station. Otherwise print:
    //o	"There are no locomotives."

    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        if (locomotives.isEmpty()) {
            output.append(String.format("There are no locomotives departing from %s station.", name));
        } else {
            output.append(String.format("Locomotives departed from %s:\n", name));
            AtomicInteger n = new AtomicInteger(1);

            for (Locomotive locomotive : locomotives) {
                output.append(String.format("%d. %s|n", n.getAndIncrement(), locomotive.getName()));
            }
//            String collect = locomotives.stream().map(e ->
//                    String.format("%d. %s", n.getAndIncrement(), e.getName())).collect(Collectors.joining("\n"));
//            output.append(collect);
        }
        return String.valueOf(output);
    }

    //•	Method getStatistics() – returns a String in the following format (print the locomotives in order of addition):
    //o	"Locomotives departed from {tain station name}:
    //1. {locomotive name}
    //2. {locomotive name}
    //(…)
    //n.	{locomotive name}"
    //If there are no locomotives in some train stations print only this text:
    //o	"There are no locomotives departing from {rail station name} station."
}
