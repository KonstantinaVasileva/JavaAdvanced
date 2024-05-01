package Advanced.MultidimensionalArray.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[3][3];

        for (int i = 0; i < r - 2; i++) {
            for (int j = 0; j < c - 2; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        sum += matrix[i + k][j + l];
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                    for (int k = 0; k < 3; k++) {
                        System.arraycopy(matrix[i + k], j, maxMatrix[k], 0, 3);
                    }
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(maxMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
