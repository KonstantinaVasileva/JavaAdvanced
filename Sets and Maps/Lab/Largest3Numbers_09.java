package Advanced.SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Largest3Numbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> sorted = numbers.stream().sorted(Comparator.reverseOrder()).toList();

        int idx = Math.min(3, sorted.size());

        for (int i = 0; i < idx; i++) {
            System.out.print(sorted.get(i) + " ");
        }

    }
}

