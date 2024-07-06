package Advanced.ExamPreparation.Jun17_2023;

import java.util.*;
import java.util.stream.Collectors;

public class TempleOfDoom_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> tools = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(tools::offer);
        Stack<Integer> substance = new Stack<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(substance::push);
        List<Integer> challenges = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            boolean isResolved = false;
            int result = tools.peek() * substance.peek();
            for (Integer challenge : challenges) {
                if (challenge.equals(result)) {
                    tools.poll();
                    substance.pop();
                    challenges.remove(challenge);
                    isResolved = true;
                    break;
                }
            }
            if (!isResolved) {
                tools.offer(tools.poll() + 1);
                if (substance.peek() != 1) {
                    substance.push(substance.pop() - 1);
                } else {
                    substance.pop();
                }
            }
            if ((tools.isEmpty() || substance.isEmpty()) && !challenges.isEmpty()) {
                System.out.println("Harry is lost in the temple. Oblivion awaits him.");
                break;
            } else if (challenges.isEmpty()) {
                System.out.println("Harry found an ostracon, which is dated to the 6th century BCE.");
                break;
            }
        }
        System.out.printf(tools.isEmpty()? "":"Tools: %s\n", String.join(", ", tools.stream().map(String::valueOf).toList()));
        System.out.printf(challenges.isEmpty()? "":"Challenges: %s\n", String.join(", ", challenges.stream().map(String::valueOf).toList()));
        System.out.printf(substance.isEmpty()? "":"Substances: %s\n", String.join(", ", substance.stream().map(String::valueOf).toList()));
    }
}
