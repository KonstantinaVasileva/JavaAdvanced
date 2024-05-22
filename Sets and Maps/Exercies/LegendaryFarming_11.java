package Advanced.SetsAndMaps.Exercise;

import java.util.*;

public class LegendaryFarming_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //   scanner.useDelimiter("\\s+|\\n");

        Map<String, Integer> materials = new TreeMap<>();
        Map<String, Integer> junks = new TreeMap<>();
        String legendary = "";
        boolean isCollect = false;

        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        do {
            String[] input = scanner.nextLine().split(" ");

            for (int i = 0; i < input.length / 2; i++) {
                int quantity = Integer.parseInt(input[i * 2]);
                String material = input[i * 2 + 1].toLowerCase();

                switch (material) {
                    case "shards", "fragments", "motes":
                        materials.put(material, materials.get(material) + quantity);
                        break;
                    default:
                        junks.putIfAbsent(material, 0);
                        junks.put(material, junks.get(material) + quantity);
                }
                if (materials.containsKey(material) && materials.get(material) >= 250) {
                    switch (material) {
                        case "shards" -> {
                            materials.put(material, materials.get(material) - 250);
                            legendary = "Shadowmourne obtained!";
                        }
                        case "fragments" -> {
                            materials.put(material, materials.get(material) - 250);
                            legendary = "Valanyr obtained!";
                        }
                        case "motes" -> {
                            materials.put(material, materials.get(material) - 250);
                            legendary = "Dragonwrath obtained!";
                        }
                    }
                    isCollect = true;
                    break;
                }
            }
        } while (!isCollect);

        System.out.println(legendary);
        materials.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(e -> System.out.printf("%s: %d\n", e.getKey(), e.getValue()));

        junks.forEach((key, value) ->
                System.out.printf("%s: %s\n", key, value));


    }
}

// 123 silver 6 shards 8 shards 5 motes 9 fangs 75 motes 103 MOTES 8 Shards 86 Motes 7 stones 19 silver