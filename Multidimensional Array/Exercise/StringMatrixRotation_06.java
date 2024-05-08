package Advanced.MultidimensionalArray.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = new ArrayList<>();
        String[] command = scanner.nextLine().split("\\(");
        int angle = Integer.parseInt(command[1].replace(")", ""));

        while (true) {
            String word = scanner.nextLine();
            if (word.equals("END")) {
                break;
            }
            input.add(word);
        }
        int row = input.size();
        int col = 0;
        for (String element : input) {
            if (element.length() > col) {
                col = element.length();
            }
        }
        char[][] matrix = new char[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < input.get(i).length(); j++) {
                String currentElement = input.get(i);
                matrix[i][j] = currentElement.charAt(j);
            }
            for (int j = input.get(i).length(); j < col; j++) {
                matrix[i][j] = ' ';
            }
        }
        int count = angle / 90;

        for (int i = 0; i < count; i++) {
            matrix = rotateMatrix(matrix);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] rotateMatrix(char[][] matrix) {
        int col = matrix.length;
        int row = matrix[0].length;
        char[][] rotatedMatrix = new char[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotatedMatrix[i][j] = matrix[col - 1 - j][i];
            }
        }
        return rotatedMatrix;
    }
}
