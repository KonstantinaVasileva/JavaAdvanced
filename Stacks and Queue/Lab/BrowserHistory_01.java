package Advanced.StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

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
                stack.pop();
            } else {
                stack.push(command);
            }
            System.out.println(stack.peek());
        }

    }

}
