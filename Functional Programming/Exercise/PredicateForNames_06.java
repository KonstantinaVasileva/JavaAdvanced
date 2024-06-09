package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split(" "))
                .toList();

        Predicate<String> filterBySize = e -> e.length() <= size;
        names.stream().filter(filterBySize).forEach(System.out::println);

    }
}
