package Advanced.MultidimensionalArray.Exercise;

import java.util.Scanner;

public class TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double damageToHeigan = Double.parseDouble(scanner.nextLine());
        int playerPoints = 18500;
        double heigenPoints = 3000000;
        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";

        while (true) {

            if (playerPoints > 0) {
                heigenPoints -= damageToHeigan;
            }
            if (lastSpell.equals("Cloud")) {
                playerPoints -= 3500;
            }
            if (heigenPoints <= 0 || playerPoints <= 0) {

                break;
            }
            String[] command = scanner.nextLine().split("\\s+");
            String spell = command[0];
            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);

            if (isHit(playerRow, playerCol, row, col)) {
                if (!isHit(playerRow - 1, playerCol, row, col)) {
                    playerRow = playerRow - 1;
                    lastSpell = "";
                } else if (!isHit(playerRow, playerCol + 1, row, col)) {
                    playerCol = playerCol + 1;
                    lastSpell = "";
                } else if (!isHit(playerRow + 1, playerCol, row, col)) {
                    playerRow = playerRow + 1;
                    lastSpell = "";
                } else if (!isHit(playerRow, playerCol - 1, row, col)) {
                    playerCol = playerCol - 1;
                    lastSpell = "";
                } else {
                    lastSpell = spell;
                    if (spell.equals("Cloud")) {
                        playerPoints -= 3500;
                    }
                    if (spell.equals("Eruption")) {
                        playerPoints -= 6000;
                    }
                }
            }
        }
        if (heigenPoints <= 0) {
            System.out.println("Heigan: Defeated!");
        } else {
            System.out.printf("Heigan: %.2f\n", heigenPoints);
        }
        if (playerPoints <= 0) {
            System.out.printf("Player: Killed by %s\n", lastSpell.equals("Cloud") ? "Plague Cloud" : lastSpell);
        } else {
            System.out.printf("Player: %s\n", playerPoints);
        }
        System.out.printf("Final position: %s, %s\n", playerRow, playerCol);
    }


    private static boolean isHit(int playerRol, int playerCol, int row, int col) {
        if ((playerRol >= row - 1 && playerRol <= row + 1) && (playerCol >= col - 1 && playerCol <= col + 1)
                || (playerRol < 0 || playerRol >= 15 || playerCol < 0 || playerCol >= 15)) {
            return true;
        }
        return false;
    }
}
