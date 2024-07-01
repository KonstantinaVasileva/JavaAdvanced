package Advanced.ExamPreparation.Dec13_2023.fishingPond;

public class Fish {
    private String species;
    private int age;
    private String matingSeason;

    public Fish(String species, int age, String matingSeason) {
        this.species = species;
        this.age = age;
        this.matingSeason = matingSeason;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMatingSeason(String matingSeason) {
        this.matingSeason = matingSeason;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getMatingSeason() {
        return matingSeason;
    }

    @Override
    public String toString(){
        return String.format("This %s is %s years old and reproduces through %s.\n",
                this.species, this.age, this.matingSeason);
    }
}
