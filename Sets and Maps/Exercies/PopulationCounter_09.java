package Advanced.SetsAndMaps.Exercise;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PopulationCounter_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> countryData = new LinkedHashMap<>();
        Map<String, Long> countryPopulation = new LinkedHashMap<>();
        while (true) {
            String[] input = scanner.nextLine().split("\\|");
            if (input[0].equals("report")) {
                break;
            }
            String city = input[0];
            String country = input[1];
            long population = Long.parseLong(input[2]);

            countryData.putIfAbsent(country, new LinkedHashMap<>());
            countryPopulation.putIfAbsent(country, 0L);
            countryPopulation.put(country, countryPopulation.get(country) + population);
            //Map<String, Integer> cityPopulation = countryData.get(country);
            countryData.get(country).put(city, population);
        }

        Map<String, Long> sortedByPopulation =
                countryPopulation.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        sortedByPopulation.forEach((key, value) -> {
            System.out.printf("%s (total population: %s)\n", key, value);
            LinkedHashMap<String, Long> sortedCitiesByPopulation = countryData.get(key).entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .collect(Collectors.toMap(
                            Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
            sortedCitiesByPopulation.forEach((key1, value1) -> System.out.printf("=>%s: %s\n", key1, value1));
        });


    }
}
