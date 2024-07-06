package Advanced.ExamPreparation.Feb18_2023;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ApocalypsePreparation_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue<Integer> textiles = new ArrayDeque<>();
        Stack<Integer> medicaments = new Stack<>();

        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(textiles::offer);
        Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).forEach(medicaments::push);
        Map<String, Integer> itemCount = new TreeMap<>();
        itemCount.put("Patch", 0);
        itemCount.put("Bandage", 0);
        itemCount.put("MedKit", 0);

        while (!textiles.isEmpty() && !medicaments.isEmpty()) {
            int textile = textiles.poll();
            int medicament = medicaments.pop();
            int sum = textile + medicament;
            if (sum == 30) {
                itemCount.put("Patch", itemCount.get("Patch") + 1);
            } else if (sum == 40) {
                itemCount.put("Bandage", itemCount.get("Bandage") + 1);
            } else if (sum == 100) {
                itemCount.put("MedKit", itemCount.get("MedKit") + 1);
            } else if (sum > 100) {
                sum -= 100;
                medicaments.push(medicaments.pop() + sum);
                itemCount.put("MedKit", itemCount.get("MedKit") + 1);
            } else {
                medicament += 10;
                medicaments.push(medicament);
            }
        }

        if (textiles.isEmpty() && medicaments.isEmpty()) {
            System.out.println("Textiles and medicaments are both empty.");
        } else if (textiles.isEmpty()) {
            System.out.println("Textiles are empty.");
        } else {
            System.out.println("Medicaments are empty.");
        }

        itemCount.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).filter(e -> e.getValue() != 0)
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

        if (textiles.isEmpty() && !medicaments.isEmpty()) {
            System.out.println("Medicaments left: " + medicaments.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        } else if (medicaments.isEmpty() && !textiles.isEmpty()) {
            System.out.println("Textiles left: " + textiles.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
    }
}
