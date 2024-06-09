package Advanced.FunctionalProgramming.Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guest = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        Map<String, Predicate> predicates = new LinkedHashMap<>();

        while (true) {
            String commands = scanner.nextLine();
            if (commands.equals("Print")) {
                break;
            }
            String toDo = commands.split(";")[0];
            String condition = commands.split(";")[1];
            String criteria = commands.split(";")[2];
            String name = condition + criteria;

            if (toDo.contains("Add")) {
                Predicate<String> predicate = null;
                switch (condition) {
                    case "Starts with":
                        predicate = e -> e.startsWith(criteria);

                        break;
                    case "Ends with":
                        predicate = e -> e.endsWith(criteria);
                        break;
                    case "Contains":
                        predicate = e -> e.contains(criteria);
                        break;
                    case "Length":
                        predicate = e -> e.length() == Integer.parseInt(criteria);
                        break;
                }
                predicates.put(name, predicate);
            } else {
                predicates.remove(name);
            }
        }

        for (String g : guest) {
            boolean isGoing = true;
            for (Predicate predicate : predicates.values()) {
                if (predicate.test(g)) {
                    isGoing = false;
                }

            }
            if (isGoing) {
                System.out.print(g + " ");
            }
        }

    }
}
