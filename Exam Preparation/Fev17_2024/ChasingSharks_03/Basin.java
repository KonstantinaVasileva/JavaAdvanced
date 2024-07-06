package Advanced.ExamPreparation.Fev17_2024.ChasingSharks_03;

import java.util.*;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark(Shark shark) {
        if (this.sharks.size() < capacity) {
            this.sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark(String kind) {
        List<Shark> sharkStream = this.sharks.stream().filter(e -> e.getKind().equals(kind)).toList();
        return this.sharks.removeAll(sharkStream);
    }

    public Shark getLargestShark() {
        return this.sharks.stream().max(Comparator.comparing(Shark::getLength)).orElse(null);
    }

    public Shark getShark(String kind) {
//        String stringStream = this.sharks.stream().filter(e -> e.getKind().equals(kind)).map(String::valueOf).toString();
//        return stringStream.isEmpty() ? null : stringStream;
        return sharks.stream().filter(f -> f.getKind().equals(kind)).findFirst().orElse(null);
    }

    public int getCount(){
        return this.sharks.size();
    }
    public int getAverageLength(){
        return (int)this.sharks.stream()
                .mapToDouble(Shark::getLength)
                .average()
                .orElse(0);
    }
    public String report(){

        return String.format("Sharks in %s:\n%s",
                this.name, this.sharks.toString().trim().replaceAll("[\\[\\],]", "").trim());

        //Sharks in {basin name}:
        //The {kind} is {length} centimeters long, eats {food} and inhabits {habitation}.
    }

}
