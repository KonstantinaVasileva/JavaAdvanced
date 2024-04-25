package Advanced.MultidimensionalArray.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        String [][] firstMatrix;
        String [][] secondMatrix;

        firstMatrix = readMatrix(scanner, row);
        secondMatrix = readMatrix(scanner, row);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!firstMatrix[i][j].equals(secondMatrix[i][j])){
                    firstMatrix[i][j] = "*";
                }
            }
        }
        for (int i = 0; i < row; i++) {
            System.out.println(Arrays.toString(firstMatrix[i]).replaceAll("[\\[\\],]", ""));
        }
    }

    private static String[][] readMatrix(Scanner scanner, int row) {
        String[][] matrix = new String[row][];
        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        return matrix;
    }
}
