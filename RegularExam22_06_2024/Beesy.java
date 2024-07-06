package Advanced.RegularExam22_06_2024;

import java.util.Arrays;
import java.util.Scanner;

public class Beesy {
    public static String[][] matrix;
    public static int nectar = 0;
    public static int row;
    public static int coll;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        matrix = new String[size][size];
        row = -1;
        coll = -1;


        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().split("");
            for (int j = 0; j < size; j++) {
                if (matrix[i][j].equals("B")) {
                    row = i;
                    coll = j;
                    matrix[row][coll] = "-";
                }
            }
        }

        int count = 15;
        boolean isRefill = false;

        while (count-- > 0) {
            String move = scanner.nextLine();
            switch (move) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    coll--;
                    break;
                case "right":
                    coll++;
                    break;
            }

            if (!checkPosition() && nectar >= 30) {
                System.out.println("Great job, Beesy! The hive is full. Energy left: " + count);
                matrix[row][coll] = "B";
                printMatrix();
                return;
            } else if (!checkPosition()) {
                System.out.println("Beesy did not manage to collect enough nectar.");
                matrix[row][coll] = "B";
                printMatrix();
                return;
            }
            if (count == 0 && nectar >= 30 && !isRefill) {
                count += nectar - 30;
                isRefill = true;
            }
        }
        System.out.println("This is the end! Beesy ran out of energy.");

        matrix[row][coll] = "B";

        printMatrix();

    }

    private static void printMatrix() {
        Arrays.stream(matrix).forEach(e -> {
            System.out.println(String.join("", e));
        });
    }

    public static boolean checkPosition() {
        if (row < 0) {
            row = matrix.length - 1;
        } else if (row >= matrix.length) {
            row = 0;
        } else if (coll < 0) {
            coll = matrix.length - 1;
        } else if (coll >= matrix.length) {
            coll = 0;
        }

        if (matrix[row][coll].equals("H")) {
            return false;
        }
        if (Character.isDigit(matrix[row][coll].charAt(0))) {
            nectar += Integer.parseInt(matrix[row][coll]);
            matrix[row][coll] = "-";
        }
        return true;
    }
}
