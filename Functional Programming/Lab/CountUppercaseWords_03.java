package Advanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = Arrays.stream(scanner.nextLine().split(" "))
                .filter(e -> Character.isUpperCase(e.charAt(0)))
                .collect(Collectors.toList()).toArray(new String[0]);

        System.out.println(words.length);
        Arrays.stream(words).forEach(System.out::println);


    }
}
