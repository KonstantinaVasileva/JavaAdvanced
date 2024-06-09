package Advanced.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Function;

public class FindTheSmallestElement_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).toList();

        Integer min = Collections.min(numbers);
        System.out.println(numbers.lastIndexOf(min));

    }
}
