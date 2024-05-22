package Advanced.SetsAndMaps.Exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SurbianUnleashed_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Map<String, Integer>> venueNameTotalPrice = new LinkedHashMap<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("End")) {
                break;
            }
            String regex = "(?<name>[A-Za-z ]+) @(?<venue>[A-Za-z ]+) (?<price>[0-9]+) (?<count>[0-9]+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("name");
                String venue = matcher.group("venue");
                int ticketPrice = Integer.parseInt(matcher.group("price"));
                int ticketCount = Integer.parseInt(matcher.group("count"));

                venueNameTotalPrice.putIfAbsent(venue, new LinkedHashMap<>());
                venueNameTotalPrice.get(venue).putIfAbsent(name, 0);
                venueNameTotalPrice.get(venue).put(name, venueNameTotalPrice.get(venue).get(name) + ticketPrice * ticketCount);
            }
        }

        venueNameTotalPrice.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(e ->
                            System.out.printf("#  %s -> %d\n", e.getKey(), e.getValue()));
        });

    }
}
