package Advanced.MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class RadioactiveMutantVampireBunnies_10 {
    static String[][] lair;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        lair = new String[rows][cols];

        int playerRow = 0;
        int playerCol = 0;
        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            lair[i] = input.split("");
            if (input.contains("P")) {
                playerRow = i;
                playerCol = input.indexOf("P");
            }
        }
        String[] move = scanner.nextLine().split("");
        boolean isDead = false;

        for (String s : move) {
            lair[playerRow][playerCol] = ".";
            int[] lastCoordination = {playerRow, playerCol};
            switch (s) {
                case "L":
                    playerCol -= 1;
                    break;
                case "R":
                    playerCol += 1;
                    break;
                case "U":
                    playerRow -= 1;
                    break;
                case "D":
                    playerRow += 1;
                    break;
            }
            if (!isEscape(playerRow, playerCol)) {
                if (lair[playerRow][playerCol].equals("B")) {
                    isDead = true;
                } else {
                    lair[playerRow][playerCol] = "P";
                }
            }
            for (int j = 0; j < lair.length; j++) {
                extracted(j, isDead);
            }
            for (int j = 0; j < lair.length; j++) {
                extracted1(j);
            }


            String output = "";
            if (isEscape(playerRow, playerCol)) {
                output = String.format("won: %s %s", lastCoordination[0], lastCoordination[1]);
            } else if (isDead) {
                output = String.format("dead: %s %s", playerRow, playerCol);
            } else {
                continue;
            }
            printArr(lair);
            System.out.println(output);
            break;
        }

    }

    private static void extracted1(int j) {
        for (int k = 0; k < lair[j].length; k++) {
            if (lair[j][k].equals("b")) {
                lair[j][k] = "B";
            }
        }
    }

    private static void extracted(int j, boolean isDead) {
        for (int k = 0; k < lair[j].length; k++) {
            if (lair[j][k].equals("B")) {
                if (j + 1 < lair.length) {
                    if (lair[j + 1][k].equals(".")) {
                        lair[j + 1][k] = "b";
                    } else if (lair[j + 1][k].equals("P")) {
                        isDead = true;
                        lair[j + 1][k] = "b";
                    }
                }
                if (j - 1 >= 0) {
                    if (lair[j - 1][k].equals(".")) {
                        lair[j - 1][k] = "b";
                    } else if (lair[j - 1][k].equals("P")) {
                        isDead = true;
                        lair[j - 1][k] = "b";
                    }
                }
                if (k + 1 < lair[0].length) {
                    if (lair[j][k + 1].equals(".")) {
                        lair[j][k + 1] = "b";
                    } else if (lair[j][k + 1].equals("P")) {
                        isDead = true;
                        lair[j][k + 1] = "b";
                    }
                }
                if (k - 1 >= 0) {
                    if (lair[j][k - 1].equals(".")) {
                        lair[j][k - 1] = "b";
                    } else if (lair[j][k - 1].equals("P")) {
                        isDead = true;
                        lair[j][k - 1] = "b";
                    }
                }
            }
        }
    }

    private static void printArr(String[][] lair) {
        Arrays.stream(lair).map(strings -> String.join("", strings)).forEach(System.out::println);
    }

    private static boolean isEscape(int playerRow, int playerCol) {
        return playerRow < 0 || playerRow >= lair.length || playerCol < 0 || playerCol >= lair[0].length;
    }
}
