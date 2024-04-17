package Advanced.StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> names = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" ")).forEach(names::offer);

        int number = Integer.parseInt(scanner.nextLine());

        while (names.size() > 1) {
            for (int i = 1; i < number; i++) {
                names.offer(names.poll());
            }
            System.out.println("Removed " + names.poll());
        }
        System.out.println("Last is " + names.poll());
    }
}
