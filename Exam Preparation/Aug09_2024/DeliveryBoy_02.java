package Advanced.ExamPreparation.Aug09_2024;

import java.util.Arrays;
import java.util.Scanner;

public class DeliveryBoy_02 {
    private static String[][] road;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = size[0];
        int m = size[1];
        int row = -1;
        int col = -1;

        road = new String[n][m];

        for (int i = 0; i < n; i++) {
            road[i] = scanner.nextLine().split("");
            for (int j = 0; j < m; j++) {
                if (road[i][j].equals("B")) {
                    row = i;
                    col = j;
                }
            }
        }

        int startRow = row;
        int startCol = col;
        label:
        while (true) {
            String command = scanner.nextLine();
            switch (command) {
                case "up" -> {
                    row--;
                    if (!isValid(row, col)) {
                        road[startRow][startCol] = " ";
                        System.out.println("The delivery is late. Order is canceled.");
                        break label;
                    } else if ((road[row][col].equals("*"))) {
                        row++;
                    }
                }
                case "down" -> {
                    row++;
                    if (!isValid(row, col)) {
                        road[startRow][startCol] = " ";
                        System.out.println("The delivery is late. Order is canceled.");
                        break label;
                    } else if ((road[row][col].equals("*"))) {
                        row--;
                    }
                }
                case "left" -> {
                    col--;
                    if (!isValid(row, col)) {
                        road[startRow][startCol] = " ";
                        System.out.println("The delivery is late. Order is canceled.");
                        break label;
                    } else if ((road[row][col].equals("*"))) {
                        col++;
                    }
                }
                case "right" -> {
                    col++;
                    if (!isValid(row, col)) {
                        road[startRow][startCol] = " ";
                        System.out.println("The delivery is late. Order is canceled.");
                        break label;
                    } else if ((road[row][col].equals("*"))) {
                        col--;
                    }
                }
            }
            checkMark(row, col);
            if (road[row][col].equals("P")){
                break;
            }
        }
        printRoad();
    }

    private static void checkMark(int row, int col) {
        if (road[row][col].equals("P")) {
            System.out.println("Pizza is collected. 10 minutes for delivery.");
            road[row][col] = "R";
        } else if (road[row][col].equals("A")) {
            System.out.println("Pizza is delivered on time! Next order...");
            road[row][col] = "P";
        } else if (road[row][col].equals("-")) {
            road[row][col] = ".";
        }
    }

    private static void printRoad() {
        Arrays.stream(road).forEach(e -> System.out.println(String.join("", e)));
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < road.length && col >= 0 && col < road[0].length;
    }
}
