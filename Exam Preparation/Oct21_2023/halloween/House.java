package Advanced.ExamPreparation.Oct21_2023.halloween;

import java.util.ArrayList;
import java.util.List;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void addKid(Kid kid) {
        if (this.data.size() < this.capacity) {
            this.data.add(kid);
        }
    }

    public boolean removeKid(String name) {
        List<Kid> list = this.data.stream().filter(e -> e.getName().equals(name)).toList();
        return this.data.removeAll(list);
    }

    public Kid getKid(String street){
        return this.data.stream().filter(e->e.getStreet().equals(street)).findFirst().orElse(null);
    }

    public int getAllKids(){
        return this.data.size();
    }

    public String getStatistics(){
        String output = "";
        output = "Children who visited a house for candy:\n";
        for (int i = 0; i < this.data.size(); i++) {
            output += String.format("%s from %s street\n",
                    this.data.get(i).getName(), this.data.get(i).getStreet());
        }
        return output;
    }
}
