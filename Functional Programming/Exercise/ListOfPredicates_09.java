package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numForDev = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());


        IntStream.rangeClosed(1, n).filter(num -> numForDev.stream().allMatch(e -> num % e == 0)).forEach(e -> System.out.print(e + " "));

    }
}
