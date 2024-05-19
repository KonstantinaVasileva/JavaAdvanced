package Advanced.SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> countNumber = new LinkedHashMap<>();
        for (double number:input) {
            countNumber.putIfAbsent(number, 0);
            countNumber.put(number, countNumber.get(number) + 1);
        }

        for (Map.Entry<Double, Integer> num : countNumber.entrySet()) {
            System.out.printf("%.1f -> %d\n", num.getKey(), num.getValue());
        }
    }
}
