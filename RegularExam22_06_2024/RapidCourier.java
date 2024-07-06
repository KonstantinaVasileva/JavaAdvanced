package Advanced.RegularExam22_06_2024;

import java.util.*;
import java.util.stream.Collectors;

public class RapidCourier {
    public static void main(String[] args) {

        Stack<Integer> packages = new Stack<>();
        Queue<Integer> couriers = new ArrayDeque<>();

        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(packages::push);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(couriers::offer);
        int totalDelivery = 0;

        while (!packages.isEmpty() && !couriers.isEmpty()) {
            int packageForDelivery = packages.pop();
            int courier = couriers.poll();

            if (packageForDelivery <= courier) {
                courier -= packageForDelivery * 2;
                totalDelivery += packageForDelivery;
                if (courier > 0) {
                    couriers.offer(courier);
                }
            } else {
                packageForDelivery -= courier;
                totalDelivery += courier;
                packages.push(packageForDelivery);
            }
        }

        System.out.printf("Total weight: %s kg\n", totalDelivery);

        if (packages.isEmpty() && couriers.isEmpty()) {
            System.out.println("Congratulations, all packages were delivered successfully by the couriers today.");
        } else if (couriers.isEmpty()) {
            System.out.printf("Unfortunately, there are no more available couriers to deliver the following packages: %s\n",
                    String.join(", ", packages.stream().map(String::valueOf).collect(Collectors.joining(", "))));
        } else {
            System.out.printf("Couriers are still on duty: %s but there are no more packages to deliver.\n",
                    couriers.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
