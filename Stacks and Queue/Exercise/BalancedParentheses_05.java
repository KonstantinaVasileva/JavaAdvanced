package Advanced.StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s*");
        ArrayDeque<String> openBracelet = new ArrayDeque<>();

        for (String bracelet : input) {
            switch (bracelet) {
                case ")":
                    if (openBracelet.isEmpty() || !openBracelet.pop().equals("(")) {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case "}":
                    if (openBracelet.isEmpty() || !openBracelet.pop().equals("{")) {
                        System.out.println("NO");
                        return;
                    }
                    break;
                case "]":
                    if (openBracelet.isEmpty() || !openBracelet.pop().equals("[")) {
                        System.out.println("NO");
                        return;
                    }
                    break;
                default:
                    openBracelet.push(bracelet);
                    break;
            }
        }
        System.out.println("YES");
    }
}
