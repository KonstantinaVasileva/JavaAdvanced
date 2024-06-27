package Advanced.Generics.Lab.GenericScale_03;

public class Main {
    public static void main(String[] args) {

        Scale <String> scale = new Scale<>("a", "b");
        System.out.println(scale.getHeavier());

        Scale<Integer> scale1 = new Scale<>(5, 6);
        Scale<Integer> scale2 = new Scale<>(6, 5);
        System.out.println(scale1.getHeavier());
        System.out.println(scale2.getHeavier());
    }
}
