package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();

        Function<int[], String> printNumber = arr->
                Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(printNumber.apply(numbers));

        int[] sortedNumbers = Arrays.stream(numbers).sorted().toArray();
        System.out.println(printNumber.apply(sortedNumbers));
    }
}
