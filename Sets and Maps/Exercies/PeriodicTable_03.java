package Advanced.SetsAndMaps.Exercise;

import java.util.*;

public class PeriodicTable_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < number; i++) {
            elements.addAll(List.of(scanner.nextLine().split(" ")));
        }
        for (String element : elements) {
            System.out.print(element + " ");
        }
    }
}
