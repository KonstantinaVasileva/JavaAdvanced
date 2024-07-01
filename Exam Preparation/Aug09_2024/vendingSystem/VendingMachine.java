package Advanced.ExamPreparation.Aug09_2024.vendingSystem;

import java.util.*;

public class VendingMachine {
    private int buttonCapacity;
    private List<Drink> drinks;

    public VendingMachine(int buttonCapacity) {
        this.buttonCapacity = buttonCapacity;
        this.drinks = new ArrayList<>();
    }

    public int getCount() {
        return drinks.size();
    }

    public void addDrink(Drink drink) {
        if (drinks.size() < buttonCapacity) {
            drinks.add(drink);
        }
    }

    public boolean removeDrink(String name){
        return drinks.removeIf(d->d.getName().equals(name));
    }

    public Drink getLongest(){
        return drinks.stream().max(Comparator.comparing(Drink::getVolume)).orElse(null);
    }

    public Drink getCheapest(){
        return drinks.stream().min(Comparator.comparing(Drink::getPrice)).orElse(null);
    }
    public String buyDrink(String name){
        Optional<Drink> drink = drinks.stream().filter(e -> e.getName().equals(name)).findFirst();
        return drink.map(value -> value.toString().trim()).orElse("");
    }

    public String report(){
      //  return String.format("Drinks available: \n%s", drinks.stream().map(Objects::toString).collect(Collectors.joining("\n")));
        StringBuilder sb = new StringBuilder();

        sb.append("Drinks available:\n");

        for (Drink drink : drinks) {
            sb.append(drink.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

}
