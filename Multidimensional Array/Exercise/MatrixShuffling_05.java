package Advanced.MultidimensionalArray.Exercise;

import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        while (true) {
            String[] command = scanner.nextLine().split(" ");
            if (command[0].equals("END")) {
                break;
            }
            if (command.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }
            if (command[0].equals("swap")) {
                int row1 = Integer.parseInt(command[1]);
                int col1 = Integer.parseInt(command[2]);
                int row2 = Integer.parseInt(command[3]);
                int col2 = Integer.parseInt(command[4]);
                if (isValid(row1, rows) && isValid(col1, cols) && isValid(row2, rows) && isValid(col2, cols)) {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;
                    for (int i = 0; i < rows; i++) {
                        System.out.println(String.join(" ", matrix[i]));
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }

    private static boolean isValid(int index, int size) {
        return index >= 0 && index < size;
    }
}
