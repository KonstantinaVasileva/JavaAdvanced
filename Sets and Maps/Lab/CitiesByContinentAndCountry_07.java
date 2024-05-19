package Advanced.SetsAndMaps.Lab;

import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> citiesByCountryAndContinents = new LinkedHashMap<>();

        for (int i = 0; i < number; i++) {
            String[] data = scanner.nextLine().split(" ");
            String continents = data[0];
            String country = data[1];
            String city = data[2];
            citiesByCountryAndContinents.putIfAbsent(continents, new LinkedHashMap<>());
            citiesByCountryAndContinents.get(continents).putIfAbsent(country, new ArrayList<>());
            citiesByCountryAndContinents.get(continents).get(country).add(city);
        }

        citiesByCountryAndContinents.forEach((key, value) -> {
            System.out.printf("%s:\n", key);
            value.forEach((key1, value1) -> {
                System.out.printf("%s -> %s\n", key1, String.join(", ", value1));
            });
        });

    }
}
