package Advanced.ExamPreparation.Aug09_2024.vendingSystem;

import java.math.BigDecimal;

public class Drink {
    private String name;
    private BigDecimal price;
    private int volume;

    public Drink(String name, BigDecimal price, int volume) {
        this.name = name;
        this.price = price;
        this.volume = volume;
    }

    @Override
    public String toString(){
        return String.format("Name: %s, Price: $%s, Volume: %s ml", name, price, volume);
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }
}
