package Advanced.SetsAndMaps.Lab;

import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        for (int i = 0; i < count; i++) {
            String[] data = scanner.nextLine().split(" ");

                String name = data[0];
                double grade = Double.parseDouble(data[1]);
                students.putIfAbsent(name, new ArrayList<>());
                students.get(name).add(grade);

        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double averageSum = 0.0;
            System.out.printf("%s -> ", entry.getKey());
            for (double value : entry.getValue()) {
                averageSum += value;
                System.out.printf("%.2f ", value);
            }
            averageSum /= entry.getValue().size();
            System.out.printf("(avg: %.2f)\n", averageSum);

        }

    }
}
