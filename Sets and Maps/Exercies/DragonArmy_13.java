package Advanced.SetsAndMaps.Exercise;

import java.util.*;

public class DragonArmy_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<Integer>>> dragons = new LinkedHashMap<>();

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split(" ");

            String type = input[0];
            String name = input[1];
            int damage = !input[2].equals("null") ? Integer.parseInt(input[2]) : 45;
            int health = !input[3].equals("null") ? Integer.parseInt(input[3]) : 250;
            int armor = !input[4].equals("null") ? Integer.parseInt(input[4]) : 10;

            dragons.putIfAbsent(type, new TreeMap<>());
            dragons.get(type).put(name, new ArrayList<>());
            dragons.get(type).get(name).addAll(Arrays.asList(damage, health, armor));
        }

        for (Map.Entry<String, Map<String, List<Integer>>> dragon : dragons.entrySet()) {
            double avrDamage = 0;
            double avrHealth = 0;
            double avrArmor = 0;
            for (List<Integer> value : dragon.getValue().values()) {
                avrDamage+= value.get(0);
                avrHealth+= value.get(1);
                avrArmor+= value.get(2);
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",
                    dragon.getKey(), avrDamage/dragon.getValue().size(), avrHealth/dragon.getValue().size(), avrArmor/dragon.getValue().size());
            for (Map.Entry<String, List<Integer>> entry : dragon.getValue().entrySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                        entry.getKey(), entry.getValue().get(0), entry.getValue().get(1), entry.getValue().get(2));
            }
        }

    }
}
//. Type is preserved as in the input order, but dragons are sorted alphabetically by name