package Advanced.StacksAndQueues_Exercise;

import java.util.*;

public class Robotics_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> robots = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split(";");

        for (int i = 0; i < input.length; i++) {
            robots.put(input[i].split("-")[0], Integer.parseInt(input[i].split("-")[1]));
        }

        int[] startTime = Arrays.stream(scanner.nextLine().split(":"))
                .mapToInt(Integer::parseInt).toArray();
        int[] endTime;
        ArrayDeque<String> products = new ArrayDeque<>();

        while (true) {
            String product = scanner.nextLine();
            if (product.equals("End")) {
                break;
            }
            products.offer(product);
        }

        int count = 0;
        while (!products.isEmpty()) {
            int position = 0;
            for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                count++;
                position++;
                endTime = time(startTime);
                if (count <= robots.size() || (count - position) % entry.getValue() == 0) {
                    String timeToPrint = String.format("%02d:%02d:%02d", endTime[0], endTime[1], endTime[2]);
                    System.out.println(entry.getKey() + " - " + products.poll() + " [" + timeToPrint + "]");
                } else {
                    products.offer(products.poll());
                }
            }
        }

        System.out.println();
    }

    public static int[] time(int[] startTime) {
        int index = startTime.length - 1;
        startTime[index] = startTime[index] + 1;

        rightTime(startTime, index);
        return startTime;
    }

    private static int[] rightTime(int[] startTime, int index) {
        if (startTime[index] == 60) {
            startTime[index] = 0;
            index--;
            startTime[index] = startTime[index] + 1;
            if (index > 0) {
                startTime = rightTime(startTime, index);
            }
        }
        return startTime;
    }
}

// 20/100