package Advanced.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> name = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Party!")) {
                break;
            }

            String toDo = command.split(" ")[0];
            String condition = command.split(" ")[1];
            String criteria = command.split(" ")[2];

            Predicate<String> predicate = switch (condition) {
                case "StartsWith" -> e -> e.startsWith(criteria);
                case "EndsWith" -> e -> e.endsWith(criteria);
                case "Length" -> e -> e.length() == Integer.parseInt(criteria);
                default -> null;
            };

            if (toDo.equals("Remove")) {
                List<String> toRemove = new ArrayList<>();
                for (String s : name) {
                    assert predicate != null;
                    if (predicate.test(s)) {
                        toRemove.add(s);
                    }
                }
                name.removeAll(toRemove);
            } else {
                List<String> toAdd = new ArrayList<>();
                for (String s : name) {
                    assert predicate != null;
                    if (predicate.test(s)) {
                        toAdd.add(s);
                    }
                }
                name.addAll(toAdd);
            }
        }

        Collections.sort(name);
        System.out.println(name.isEmpty()? "Nobody is going to the party!":String.join(", ", name) + " are going to the party!");

    }
}
