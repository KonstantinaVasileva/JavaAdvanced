package Advanced.ExamPreparation.Fev17_2024;

import java.util.Arrays;
import java.util.Scanner;

public class ClearSkies_02 {
    static int health = 300;
    static String[][] sky;
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        sky = new String[size][size];

        for (int i = 0; i < size; i++) {
            sky[i] = scanner.nextLine().split("");
        }

        int row = -1;
        int col = -1;

        for (int i = 0; i < sky.length; i++) {
            for (int j = 0; j < sky[i].length; j++) {
                if (sky[i][j].equals("J")) {
                    row = i;
                    col = j;
                    sky[i][j] = "-";
                }
            }
        }
        while (true) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            checkPosition(row, col);
            if (health == 0 || count == 4) {
                break;
            }
        }
        sky[row][col] = "J";
        if (health > 0) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        } else {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!\n", row, col);
        }
        Arrays.stream(sky).forEach(e -> System.out.printf("%s\n", String.join("", e)));
    }

    private static void checkPosition(int row, int col) {
        if (sky[row][col].equals("E")) {
            health -= 100;
            sky[row][col] = "-";
            count++;
        }
        if (sky[row][col].equals("R")) {
            health = 300;
            sky[row][col] = "-";
        }
    }
}
