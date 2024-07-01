package Advanced.ExamPreparation.Apr12_2023;

import java.util.*;

public class RubberDuckDebuggers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> programmers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(programmers::offer);

        Stack<Integer> tasks = new Stack<>();
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(tasks::push);

        int darthVaderDucky = 0;
        int thorDucky = 0;
        int bigBlueRubberDucky = 0;
        int smallYellowRubberDucky = 0;

        while (!(programmers.isEmpty() && tasks.isEmpty())) {
            int programmer = programmers.poll();
            int task = tasks.pop();
            int result = programmer * task;

            if (result <= 60) {
                darthVaderDucky++;
            } else if (result <= 120) {
                thorDucky++;
            } else if (result <= 180) {
                bigBlueRubberDucky++;
            } else if (result <= 240) {
                smallYellowRubberDucky++;
            } else {
                programmers.offer(programmer);
                tasks.push(task - 2);
            }
        }

        System.out.println("Congratulations, all tasks have been completed! Rubber ducks rewarded:");
        System.out.println("Darth Vader Ducky: " + darthVaderDucky);
        System.out.println("Thor Ducky: " + thorDucky);
        System.out.println("Big Blue Rubber Ducky: " + bigBlueRubberDucky);
        System.out.println("Small Yellow Rubber Ducky: " + smallYellowRubberDucky);

    }
}
