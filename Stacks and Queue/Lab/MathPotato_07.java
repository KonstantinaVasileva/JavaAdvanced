package Advanced.StacksAndQueues_Lab;

import java.util.*;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> names = new PriorityQueue<>();

        Arrays.stream(scanner.nextLine().split(" ")).forEach(names::offer);

        int number = Integer.parseInt(scanner.nextLine());
        int count = 0;

        while (names.size() > 1) {
            count++;
            for (int i = 1; i < number; i++) {
                names.offer(names.poll());
            }
            if (isPrime(count) && count != 1) {
                System.out.println("Prime " + names.peek());
            } else {
                System.out.println("Removed " + names.poll());
            }
        }
        System.out.println("Last is " + names.poll());
    }

    public static boolean isPrime(int count) {
        for (int i = 2; i < count; i++) {
            if (count % i == 0) {
                return false;
            }
        }
        return true;
    }
}
