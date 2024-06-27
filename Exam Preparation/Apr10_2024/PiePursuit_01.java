package Advanced.ExamPreparation.Apr10_2024;

import java.util.*;
import java.util.stream.Collectors;

public class PiePursuit_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> queueContestants = new ArrayDeque<>();
        int[] contestants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < contestants.length; i++) {
            queueContestants.offer(contestants[i]);
        }
        Deque<Integer> stackPie = new ArrayDeque<>();
        int[] pie = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < pie.length; i++) {
            stackPie.push(pie[i]);
        }

        while (!stackPie.isEmpty() && !queueContestants.isEmpty()) {
            int piesOfPie = stackPie.poll();
            int piesToEat = queueContestants.poll();

            if (piesOfPie > piesToEat) {
                if (piesOfPie - piesToEat == 1 && !stackPie.isEmpty()){
                    piesOfPie = stackPie.poll() + 1;
                } else {
                    piesOfPie -= piesToEat;
                }
                stackPie.push(piesOfPie);
            } else if (piesOfPie < piesToEat) {
                piesToEat -= piesOfPie;
                queueContestants.offer(piesToEat);
            }
        }

        if (stackPie.isEmpty() && queueContestants.isEmpty()){
            System.out.println("We have a champion!");
        } else if (stackPie.isEmpty()) {
            System.out.println("We will have to wait for more pies to be baked!");
            String collect = queueContestants.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Contestants left: %s", collect);
        } else {
            System.out.println("Our contestants need to rest!");
            List<String> collect = stackPie.stream().map(String::valueOf).collect(Collectors.toList());
            Collections.reverse(collect);
            String collect1 = collect.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.printf("Pies left: %s", collect1);
        }
        System.out.println();
    }
}
