package Advanced.SetsAndMaps.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Set<String> words = new LinkedHashSet<>();

        for (int i = 0; i < number; i++) {
            words.add(scanner.nextLine());
        }

        for (String word : words) {
            System.out.println(word);
        }
    }
}
