package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            }

            switch (command) {
                case "add":
                    numbers = numbers.stream().map(e -> e + 1).collect(Collectors.toList());
                    break;
                case "multiply":
                    numbers = numbers.stream().map(e -> e * 2).collect(Collectors.toList());
                    break;
                case "subtract":
                    numbers = numbers.stream().map(e -> e - 1).collect(Collectors.toList());
                    break;
                case "print":
                    numbers.forEach(e -> System.out.print(e + " "));
                    System.out.println();
                    break;
            }
        }

    }
}
