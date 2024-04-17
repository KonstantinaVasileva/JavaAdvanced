package Advanced.StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Home")) {
                break;
            }
            if (command.equals("back")) {
                if (stack.size() <= 1) {
                    System.out.println("no previous URLs");
                    continue;
                }
                queue.addFirst(stack.pop());

            } else if (command.equals("forward")) {
                if (queue.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    stack.push(queue.poll());
                    System.out.println(stack.peek());
                }
                continue;
            } else {
                queue.clear();
                stack.push(command);
            }
            System.out.println(stack.peek());
        }

    }
}
