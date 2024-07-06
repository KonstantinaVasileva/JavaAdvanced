package Advanced.ExamPreparation.Oct21_2023;

import java.util.Arrays;
import java.util.Scanner;

public class FishingCompetition_02 {
    private static String[][] sea;
    private static int fish;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        sea = new String[size][size];

        int row = -1;
        int col = -1;
        for (int i = 0; i < size; i++) {
            sea[i] = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                if (sea[i][j].equals("S")) {
                    row = i;
                    col = j;
                    sea[i][j] = "-";
                }
            }
        }

        fish = 0;
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("collect the nets")) {
                break;
            }

            switch (command) {
                case "up":
                    row--;
                    if (!isValid(row, col)) {
                        row = size - 1;
                    }
                    break;
                case "down":
                    row++;
                    if (!isValid(row, col)) {
                        row = 0;
                    }
                    break;
                case "left":
                    col--;
                    if (!isValid(row, col)) {
                        col = size - 1;
                    }
                    break;
                case "right":
                    col++;
                    if (!isValid(row, col)) {
                        col = 0;
                    }
                    break;
            }
            if (checkMark(row, col)) {
                System.out.printf("You fell into a whirlpool! The ship sank and you lost the fish you caught. Last coordinates of the ship: [%d,%d]",
                        row, col);
                return;
            }

        }
        if (fish >= 20) {
            System.out.println("Success! You managed to reach the quota!");
        } else {
            System.out.printf(" You didn't catch enough fish and didn't reach the quota! You need %d tons of fish more.\n", 20 - fish);
        }
        if (fish > 0) {
            System.out.printf("Amount of fish caught: %d tons.\n", fish);
        }
        sea[row][col] = "S";
        print();

    }

    private static boolean checkMark(int row, int col) {
        if (sea[row][col].equals("W")) {
            sea[row][col] = "-";
            return true;
        }
        if (Character.isDigit(sea[row][col].charAt(0))) {
            fish += Integer.parseInt(sea[row][col]);
            sea[row][col] = "-";
        }
        return false;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < sea.length && col >= 0 && col < sea.length;
    }
    public static void print(){
        for (int i = 0; i < sea.length; i++) {
            Arrays.stream(sea[i]).forEach(System.out::print);
            System.out.println();
        }
    }
}
