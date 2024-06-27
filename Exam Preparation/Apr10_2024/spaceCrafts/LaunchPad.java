package Advanced.ExamPreparation.Apr10_2024.spaceCrafts;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class LaunchPad {
    private String name;
    private int capacity;
    private List<Spacecraft> spacecrafts = new ArrayList<>();

    public LaunchPad(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void addSpacecraft(Spacecraft spacecraft) {
        if (hasSpace()) {
            this.spacecrafts.add(spacecraft);
        } else {
            System.out.println("This launchpad is at full capacity!");
        }
    }

    public boolean removeSpacecraft(String name) {
        List<Spacecraft> spacecraftStream = this.spacecrafts.stream().filter(e -> e.getName().equals(name)).toList();
        return this.spacecrafts.removeAll(spacecraftStream);
    }

    public String getHeaviestSpacecraft() {
        Spacecraft max = this.spacecrafts.stream()
                .max(Comparator.comparing(Spacecraft::getWeight))
                .orElse(null);
        return max != null ? String.format("%s - %skg.", max.getName(), max.getWeight()) : null;
    }

    public String getSpacecraft(String name) {
        return this.spacecrafts.stream().filter(e -> e.getName().equals(name)).toString();
    }

    public int getCount() {
        return this.spacecrafts.size();
    }

    public List<Spacecraft> getSpacecraftsByMissionType(String missionType) {
        List<Spacecraft> collect = this.spacecrafts.stream().filter(e -> e.getMissionType().equals(missionType)).collect(Collectors.toList());
        if (collect.isEmpty()){
            System.out.println("There are no spacecrafts to respond this criteria.");
        }
        return collect;
        //There are no spacecrafts to respond this criteria.
    }

    public String getStatistics() {
        String output;
        if (spacecrafts.isEmpty()) {
            output = String.format("Spacecrafts launched from %s:\nnone\n", this.name);
        } else {
            AtomicInteger n = new AtomicInteger(1);
            String spacecraftsName = this.spacecrafts.stream()
                    .map(e -> String.format("%d. %s", n.getAndIncrement(), e.getName())).collect(Collectors.joining("\n"));
            output = String.format("""
                    Spacecrafts launched from %s:
                    %s""", this.name, spacecraftsName);
        }
        return output;
    }

    public boolean hasSpace() {
        return this.capacity > this.spacecrafts.size();
    }
}
