package Advanced.ExamPreparation.Dec13_2023;

import java.util.Arrays;
import java.util.Scanner;

public class TheGambler_02 {
    private static int money = 100;
    private static String[][] gameBoard;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        gameBoard = new String[size][size];

        for (int i = 0; i < size; i++) {
            gameBoard[i] = scanner.nextLine().split("");
        }
        int row = -1;
        int col = -1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (gameBoard[i][j].equals("G")) {
                    gameBoard[i][j] = "-";
                    row = i;
                    col = j;
                }
            }
        }
        boolean hasLost = false;
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("end")) {
                break;
            }
            switch (command) {
                case "up" -> row--;
                case "down" -> row++;
                case "left" -> col--;
                case "right" -> col++;
            }
            if (!checkPosition(row, col)) {
                hasLost = true;
                break;
            }

            if (gameBoard[row][col].equals("W")) {
                money += 100;
            } else if (gameBoard[row][col].equals("P")) {
                money -= 200;
            } else if (gameBoard[row][col].equals("J")) {
                money += 100000;
                break;
            }
            gameBoard[row][col] = "-";
            if (money <= 0) {
                hasLost = true;
                break;
            }
        }
        if (gameBoard[row][col].equals("J")) {
            System.out.printf("""
                    You win the Jackpot!
                    End of the game. Total amount: %d$
                    """, money);
        } else if (hasLost) {
            System.out.println("Game over! You lost everything!");
            return;
        } else {
            System.out.printf("End of the game. Total amount: %d$\n", money);
        }
        gameBoard[row][col] = "G";
        Arrays.stream(gameBoard).forEach(e-> System.out.println(Arrays.toString(e).replaceAll("[\\[\\], ]", "")));
    }

    public static boolean checkPosition(int row, int col) {
        return row >= 0 && row < gameBoard.length && col >= 0 && col < gameBoard.length;
    }
}
