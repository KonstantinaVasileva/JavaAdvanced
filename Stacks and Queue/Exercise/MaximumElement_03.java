package Advanced.StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] command = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            switch (command[0]) {
                case 1:
                    numbers.push(command[1]);
                    break;
                case 2:
                    numbers.pop();
                    break;
                case 3:
                    System.out.println(Collections.max(numbers));
                    break;
            }
        }

    }
}
