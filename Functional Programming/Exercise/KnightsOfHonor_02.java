package Advanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(e-> System.out.println("Sir " + e));

    }
}
