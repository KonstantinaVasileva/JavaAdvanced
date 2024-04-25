package Advanced.MultidimensionalArray.Lab;

import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] firstMatrix = fillMatrix(scanner);
        String[][] secondMatrix = fillMatrix(scanner);
        boolean isEqual = true;
        if (firstMatrix.length != secondMatrix.length){
            isEqual = false;
        } else {
            for (int i = 0; i < firstMatrix.length; i++) {
                if (firstMatrix[i].length != secondMatrix[i].length) {
                    isEqual = false;
                    break;
                } else {
                    for (int j = 0; j < firstMatrix[i].length; j++) {
                        if (!firstMatrix[i][j].equals(secondMatrix[i][j])){
                            isEqual = false;
                            break;
                        }
                    }
                }

            }
        }
        if (isEqual){
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

        System.out.println();
    }

    private static String[][] fillMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);
        String[][] matrix = new String[row][column];
        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        return matrix;
    }
}
