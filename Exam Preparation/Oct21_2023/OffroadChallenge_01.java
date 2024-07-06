package Advanced.ExamPreparation.Oct21_2023;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OffroadChallenge_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> fuel = new Stack<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(fuel::push);

        Queue<Integer> consumptionIndex = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(consumptionIndex::offer);

        Queue<Integer> quantities = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(quantities::offer);
        int n = 1;
        while (fuel.peek() - consumptionIndex.peek() >= quantities.peek()
                && !fuel.isEmpty()) {
            System.out.println("John has reached: Altitude " + n++);
            fuel.pop();
            consumptionIndex.poll();
            quantities.poll();
            if (quantities.isEmpty()) {
                System.out.println("John has reached all the altitudes and managed to reach the top!");
                return;
            }
        }
        if (!fuel.isEmpty()) {
            System.out.println("John did not reach: Altitude " + n);
        }
        if (n == 1) {
            System.out.println("""
                    John failed to reach the top.
                    John didn't reach any altitude.
                    """);
        } else {

            List<String> altitudes = IntStream.range(1, n)
                    .mapToObj(i -> "Altitude " + i)
                    .collect(Collectors.toList());

            String result = String.join(", ", altitudes);
            System.out.printf("""
                    John failed to reach the top.
                    Reached altitudes: %s
                    """, result);
        }
    }
}
