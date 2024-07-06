package Advanced.ExamPreparation.Fev17_2024.ChasingSharks_03;

public class Shark {
    private String kind;
    private int length;
    private String food;
    private String habitation;

    public Shark(String kind, int length, String food, String habitation) {
        this.kind = kind;
        this.length = length;
        this.food = food;
        this.habitation = habitation;
    }

    public String getKind() {
        return kind;
    }

    public int getLength() {
        return length;
    }

    public String getFood() {
        return food;
    }

    public String getHabitation() {
        return habitation;
    }

    @Override
    public String toString() {
        return String.format("The %s is %d centimeters long, eats %s and inhabits %s.\n",
                this.kind, this.length, this.food, this.habitation);
    }
}
