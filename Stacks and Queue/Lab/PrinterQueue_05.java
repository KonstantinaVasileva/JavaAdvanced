package Advanced.StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<String> queue = new ArrayDeque<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("print")) {
                break;
            }
            if (input.equals("cancel")) {
                System.out.println(queue.isEmpty() ? "Printer is on standby" : "Canceled " + queue.poll());
            } else
                queue.offer(input);
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
