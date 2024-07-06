package Advanced.ExamPreparation.Jun17_2023;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MouseInTheKitchen_02 {
    private static String[][] area;
    private static int cheeseCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = size[0];
        int m = size[1];

        area = new String[n][m];
        int row = -1;
        int col = -1;

        for (int i = 0; i < n; i++) {
            area[i] = scanner.nextLine().split("");
            for (int j = 0; j < m; j++) {
                if (area[i][j].equals("M")) {
                    row = i;
                    col = j;
                    area[i][j] = "*";
                }
                if (area[i][j].equals("C")){
                    cheeseCount++;
                }
            }
        }
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("danger")) {
                break;
            }
            int lastRow = row;
            int lastCol = col;
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
            if(!isValid(row, col)){
                row = lastRow;
                col = lastCol;
                System.out.println("No more cheese for tonight!");
                break;
            }
            if(!checkPosition(row, col, lastRow, lastCol)){
                break;
            }
            if (cheeseCount == 0) {
                System.out.println("Happy mouse! All the cheese is eaten, good night!");
                break;
            }
        }
        area[row][col] = "M";
        Arrays.stream(area).forEach(e-> System.out.println(Arrays.stream(e).map(String::valueOf).collect(Collectors.joining(""))));
    }

        private static boolean checkPosition(int row, int col, int lastRow, int lastCol) {
        if (area[row][col].equals("C")){
            cheeseCount--;
            area[row][col] = "*";
        } else if (area[row][col].equals("@")) {
            row = lastRow;
            col = lastCol;
        } else if (area[row][col].equals("T")) {
            System.out.println("Mouse is trapped!");
            return false;
        }
        return true;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < area.length && col >= 0 && col < area[0].length;
    }
}
