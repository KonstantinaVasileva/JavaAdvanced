package Advanced.MultidimensionalArray.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int wrongNumber = matrix[scanner.nextInt()][scanner.nextInt()];
        Deque<Integer> rightNumbers = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongNumber) {
                    int num = 0;
                    if (i - 1 >= 0 && matrix[i - 1][j] != wrongNumber) {
                        num += matrix[i - 1][j];
                    }
                    if (i + 1 < size && matrix[i + 1][j] != wrongNumber) {
                        num += matrix[i + 1][j];
                    }
                    if (j - 1 >= 0 && j - 1 <  matrix[i].length && matrix[i][j - 1] != wrongNumber) {
                        num += matrix[i][j - 1];
                    }
                    if (j + 1 < matrix[i].length && matrix[i][j + 1] != wrongNumber) {
                        num += matrix[i][j + 1];
                    }
                    rightNumbers.offer(num);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongNumber) {
                    matrix[i][j] = rightNumbers.poll();
                }
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
