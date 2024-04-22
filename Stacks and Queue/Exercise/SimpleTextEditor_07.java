package Advanced.StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> history = new ArrayDeque<>();

        for (int i = 1; i <= numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            switch (command[0]) {
                case "1":
                    history.push(text.toString());
                    text.append(command[1]);
                    break;
                case "2":
                    history.push(text.toString());
                    int idx = Math.max(text.length() - Integer.parseInt(command[1]), 0);
                    text.delete(idx, text.length());
                    break;
                case "3":
                    System.out.println(text.charAt(Integer.parseInt(command[1]) - 1));
                    break;
                case "4":
                    if (!history.isEmpty())  {
                        text = new StringBuilder(history.pop());
                    }
                    break;
            }
        }

    }
}
