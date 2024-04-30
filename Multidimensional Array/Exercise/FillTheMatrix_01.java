package Advanced.MultidimensionalArray.Exercise;

import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];
        int[][] matrix = new int[size][size];
        if (pattern.equals("A")) {
            patternA(size, matrix);
        } else {
            patternB(size, matrix);
        }
        printMatrix(size, matrix);
    }

    private static void printMatrix(int size, int[][] matrix) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void patternA(int size, int[][] matrix) {
        int count = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[j][i] = count;
                count++;
            }
        }
    }

    private static void patternB(int size, int[][] matrix) {
        int count = 1;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < size; j++) {
                    matrix[j][i] = count;
                    count++;
                }
            } else {
                for (int j = size - 1; j >= 0; j--) {
                    matrix[j][i] = count;
                    count++;
                }
            }
        }
    }
}
