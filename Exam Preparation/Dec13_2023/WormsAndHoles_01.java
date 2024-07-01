package Advanced.ExamPreparation.Dec13_2023;

import java.util.*;

public class WormsAndHoles_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> wormsStack = new Stack<>();
        Queue<Integer> holesQueue = new ArrayDeque<>();

        int[] worms = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] holes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int worm : worms) {
            wormsStack.push(worm);
        }
        for (int hole : holes) {
            holesQueue.offer(hole);
        }

        int matchCount = 0;
        int size = wormsStack.size();
        while (!wormsStack.isEmpty() && !holesQueue.isEmpty()) {
            int hole = holesQueue.poll();
            int worm = wormsStack.pop();
            if (hole == worm) {
                matchCount++;
            } else if (worm - 3 > 0) {
                worm -= 3;
                wormsStack.push(worm);
            }
        }

        System.out.println(matchCount != 0 ? "Matches: " + matchCount : "There are no matches.");
        if (wormsStack.isEmpty()&&size==matchCount){
            System.out.println("Every worm found a suitable hole!");
        } else {
            System.out.printf("Worms left: %s\n", wormsStack.isEmpty()?"none":wormsStack.toString().replaceAll("[\\[\\]]", ""));
        }
        System.out.printf("Holes left: %s\n", holesQueue.isEmpty()?"none":holesQueue.toString().replaceAll("[\\[\\]]", ""));
    }
}
