package Advanced.DefiningClasses.Exercise.Google_07;

public class Parents {
    private String name;
    private String birthday;

    public String getName() {
        return name;
    }

    public Parents(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.birthday);
    }
}
