package Advanced.SetsAndMaps.Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> count = new TreeMap<>();

        for (char c : text.toCharArray()) {
            count.putIfAbsent(c, 0);
            count.put(c, count.get(c) + 1);
        }
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            System.out.printf("%s: %d time/s\n", entry.getKey(), entry.getValue());
        }
    }
}
