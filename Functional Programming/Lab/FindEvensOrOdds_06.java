package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");

        int firstNumber = Integer.parseInt(numbers[0]);
        int lastNumber = Integer.parseInt(numbers[1]);

        String range = scanner.nextLine();

        IntStream.rangeClosed(firstNumber, lastNumber)
                .filter(e -> range.equals("odd") == (e % 2 != 0))
                .forEach(e -> System.out.print(e + " "));
    }
}
