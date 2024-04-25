package Advanced.MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String size = scanner.nextLine();
        int[][] matrix = readMatrix(scanner, size);

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            sum += Arrays.stream(matrix[i]).sum();
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);
    }
    public static int[][] readMatrix(Scanner scanner, String size){
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
