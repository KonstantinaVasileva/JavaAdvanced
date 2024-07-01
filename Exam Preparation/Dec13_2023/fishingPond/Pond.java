package Advanced.ExamPreparation.Dec13_2023.fishingPond;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> fishes;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Fish> getFishes() {
        return fishes;
    }

    public void setFishes(List<Fish> fishes) {
        this.fishes = fishes;
    }

    public Pond(int capacity) {
        this.fishes = new ArrayList<>();
        this.capacity = capacity;
    }

    public void addFish(Fish fish) {
        if (fishes.size() < capacity) {
            fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        List<Fish> remove = this.fishes.stream().filter(e -> e.getSpecies().equals(species)).toList();
        return fishes.removeAll(remove);
    }

    public Fish getOldestFish() {
        return fishes.stream().max(Comparator.comparing(Fish::getAge)).orElse(null);
    }

    public Fish getFish(String species) {
        return fishes.stream().filter(e -> e.getSpecies().equals(species)).findFirst().orElse(null);
    }

    public int getCount(){
        return fishes.size();
    }

    public int getVacancies(){
        return capacity - fishes.size();
    }

    public String report(){
        StringBuilder report = new StringBuilder();
        report.append("Fishes in the pond:\n");
        for (Fish fish : fishes) {
            report.append(String.format("This %s is %d years old and reproduces through %s.\n",
                    fish.getSpecies(), fish.getAge(), fish.getMatingSeason()));
        }
        return report.toString();
    }
}
