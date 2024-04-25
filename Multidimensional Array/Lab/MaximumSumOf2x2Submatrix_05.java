package Advanced.MultidimensionalArray.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();
        int[][] matrix = readMatrix(scanner, size);
        List<Integer> points = new ArrayList<>();

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length - 1; i++) {
            int sum;
            for (int j = 0; j < matrix[0].length - 1; j++) {
                sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    points.clear();
                    points.add(matrix[i][j]);
                    points.add(matrix[i][j + 1]);
                    points.add(matrix[i + 1][j]);
                    points.add(matrix[i + 1][j + 1]);
                }
            }
        }

        System.out.println(points.get(0) + " " + points.get(1));
        System.out.println(points.get(2) + " " + points.get(3));
        System.out.println(maxSum);

    }

    public static int[][] readMatrix(Scanner scanner, String size) {
        int row = Integer.parseInt(size.split(", ")[0]);
        int col = Integer.parseInt(size.split(", ")[0]);
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return matrix;
    }
}
