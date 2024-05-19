package Advanced.SetsAndMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrade = new TreeMap<>();

        for (int i = 0; i < number; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Double::parseDouble).collect(Collectors.toList());

            studentsGrade.putIfAbsent(name, grades);
        }

        //  studentsGrade.forEach((key, value) -> {
        //      double average = value.stream().mapToDouble(Double::doubleValue).sum() / value.size();
        //      System.out.println(String.format("%s is graduated with %s",
        //              key, average));
        //  });


        for (Map.Entry<String, List<Double>> entry : studentsGrade.entrySet()) {
            double sum = 0;
            for (Double v : entry.getValue()) {
                sum += v;
            }
            double average = sum / entry.getValue().size();
            System.out.printf("%s is graduated with %s\n", entry.getKey(), average);
        }

    }
}
