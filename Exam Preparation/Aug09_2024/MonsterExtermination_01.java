package Advanced.ExamPreparation.Aug09_2024;

import java.util.*;

public class MonsterExtermination_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> monsters = new ArrayDeque<>();
        Stack<Integer> strike = new Stack<>();

        Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).forEach(monsters::offer);
        Arrays.stream(scanner.nextLine().split(",")).map(Integer::parseInt).forEach(strike::push);
        int count = 0;

        while (!monsters.isEmpty() && !strike.isEmpty()) {
            if (monsters.peek() <= strike.peek()) {
                count++;
                int i = strike.pop() - monsters.poll();
                if (!strike.isEmpty()) {
                    strike.push(i + strike.pop());
                } else {
                    if (i != 0) {
                        strike.push(i);
                    }
                }
            } else {
                monsters.offer(monsters.poll() - strike.pop());
            }
        }

        if (monsters.isEmpty()) {
            System.out.println("All monsters have been killed!");
        } else {
            System.out.println("The soldier has been defeated.");
        }

        System.out.println("Total monsters killed: " + count);
    }
}
