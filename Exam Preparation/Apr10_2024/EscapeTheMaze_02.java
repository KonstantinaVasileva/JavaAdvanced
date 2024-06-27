package Advanced.ExamPreparation.Apr10_2024;

import java.util.Arrays;
import java.util.Scanner;

public class EscapeTheMaze_02 {
    static String[][] maze;
    static int health = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        maze = new String[size][size];

        for (int i = 0; i < size; i++) {
            maze[i] = scanner.next().split("");
        }

        int[] position = findPosition();
        int row = position[0];
        int col = position[1];
        boolean isOver = false;
        while (true) {
            String move = scanner.nextLine();

            switch (move) {
                case "left":
                    if (isValid(row, col - 1)) {
                        maze[row][col] = "-";
                        col -= 1;
                        isOver = checkPosition(row, col);
                    }
                    break;
                case "right":
                    if (isValid(row, col + 1)) {
                        maze[row][col] = "-";
                        col += 1;
                        isOver = checkPosition(row, col);
                    }
                    break;
                case "up":
                    if (isValid(row - 1, col)) {
                        maze[row][col] = "-";
                        row -= 1;
                        isOver = checkPosition(row, col);
                    }
                    break;
                case "down":
                    if (isValid(row + 1, col)) {
                        maze[row][col] = "-";
                        row += 1;
                        isOver = checkPosition(row, col);
                    }
                    break;
            }
            if (isOver){
                break;
            }
        }
        maze[row][col] = "P";

        Arrays.stream(maze).forEach(e->{
            Arrays.stream(e).forEach(System.out::print);
            System.out.println();
        });

    }

    private static boolean checkPosition(int row, int col) {
        if (maze[row][col].equals("M")) {
            health -= 40;
            if (health < 0) {
                health = 0;
            }
            if (health > 0) {
                maze[row][col] = "-";
            }
            if (health == 0){
                System.out.print("""
                        Player is dead. Maze over!
                        Player's health: 0 units
                        """);
                return true;
            }
        }
        if (maze[row][col].equals("H")) {
            health += 15;
            if (health > 100) {
                health = 100;
            }
            maze[row][col] = "-";
        }
        if (maze[row][col].equals("X")){
            System.out.printf("""
                    Player escaped the maze. Danger passed!
                    Player's health: %s units
                    """, health);
            return true;
        }
        return false;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze.length;
    }

    private static int[] findPosition() {
        int row = -1;
        int col = -1;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                if (maze[i][j].equals("P")) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        return new int[]{row, col};
    }
}
