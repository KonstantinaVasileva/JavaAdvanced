package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CustomComparator_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted().toList();

        numbers.stream().filter(e -> e % 2 == 0).forEach(e -> System.out.print(e + " "));
        numbers.stream().filter(e -> e % 2 != 0).forEach(e -> System.out.print(e + " "));

    }
}
