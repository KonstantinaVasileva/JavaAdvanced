package Advanced.SetsAndMaps.Lab;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Voina_NumberGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        String[] input = scanner.nextLine().split(" ");
        for (String card : input) {
            firstPlayer.add(Integer.parseInt(card));
        }
        input = scanner.nextLine().split(" ");
        for (String card : input) {
            secondPlayer.add(Integer.parseInt(card));
        }

        for (int i = 0; i < 50; i++) {
            int firstPlayerCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstPlayerCard);
            int secondPlayerCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondPlayerCard);
            if (firstPlayerCard > secondPlayerCard) {
                firstPlayer.add(firstPlayerCard);
                firstPlayer.add(secondPlayerCard);
            }

            if (firstPlayerCard < secondPlayerCard) {
                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }
        }
        String output = "";

        if (firstPlayer.size()> secondPlayer.size()){
            output = "First player win!";
        } else if (secondPlayer.size()> firstPlayer.size()) {
            output = "Second player win!";
        } else {
            output = "Drow!";
        }

        System.out.println(output);
    }
}
