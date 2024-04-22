package Advanced.StacksAndQueues_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<Integer> plants = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int days = 0;

        days = checkForDeath(plants, days);
        System.out.println(days);
    }

    private static int checkForDeath(List<Integer> plants, int days) {
        boolean isDeath = false;
        for (int i = plants.size() - 1; i >= 1; i--) {
            if (plants.get(i) > plants.get(i - 1)) {
                isDeath = true;
                plants.remove(i);
            }
        }
        if (isDeath) {
            days++;
            days = checkForDeath(plants, days);
        }
        return days;
    }
}
