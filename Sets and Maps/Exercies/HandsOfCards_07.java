package Advanced.SetsAndMaps.Exercise;

import java.util.*;
import java.util.stream.Collectors;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playerCards = new LinkedHashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(": ");
            if (input[0].equals("JOKER")) {
                break;
            }
            String name = input[0];
            playerCards.putIfAbsent(name, new LinkedHashSet<>());

            List<String> cards = Arrays.stream(input[1].split(", ")).collect(Collectors.toList());
            Set<String> oldCards = playerCards.get(name);
            oldCards.addAll(cards);
            playerCards.put(name, oldCards);

        }
        for (Map.Entry<String, Set<String>> entry : playerCards.entrySet()) {
            System.out.printf("%s: %s\n", entry.getKey(), points(entry.getValue()));

        }

    }

    private static int points(Set<String> cards) {
        List<Integer> powers = new ArrayList<>();
        int point = 0;
        for (String card : cards) {
            String power = card.substring(0, card.length() - 1);
            String color = card.split("")[card.length() - 1];
            power = switch (power) {
                case "J" -> "11";
                case "Q" -> "12";
                case "K" -> "13";
                case "A" -> "14";
                default -> power;
            };
            switch (color) {
                case "S":
                    color = "4";
                    break;
                case "H":
                    color = "3";
                    break;
                case "D":
                    color = "2";
                    break;
                case "C":
                    color = "1";
                    break;
            }
            powers.add(Integer.parseInt(color) * Integer.parseInt(power));

        }
        point = powers.stream().mapToInt(Integer::intValue).sum();
        return point;
    }
}
