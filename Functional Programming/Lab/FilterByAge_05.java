package Advanced.FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> peoples = new LinkedHashMap<>();
        while (number-- > 0) {
            String[] input = scanner.nextLine().split(", ");
            peoples.put(input[0], Integer.parseInt(input[1]));
        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Consumer<Map.Entry<String, Integer>> print = e -> {
            if (format.equals("name")) {
                System.out.println(e.getKey());
            } else if (format.equals("age")) {
                System.out.println(e.getValue());
            } else {
                System.out.println(e.getKey() + " - " + e.getValue());
            }
        };

        Predicate<Map.Entry<String, Integer>> filter = e -> condition.equals("younger") ? e.getValue() <= age : e.getValue() >= age;

        peoples.entrySet().stream().filter(filter)
                .forEach(print);

    }
}