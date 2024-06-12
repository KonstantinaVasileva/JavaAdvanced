package Advanced.DefiningClasses.Lab.CarInfo_01;

public class Car {
    private String brand;
    private String model;
    private int horsepower;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }
    //"The car is: {brand} {model} – {horsePower} HP."

    public void carInfo(){
        System.out.printf("The car is: %s %s  %d HP.", brand, model, horsepower);
    }
}
