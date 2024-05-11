package Advanced.MultidimensionalArray.Exercise;

import java.util.Scanner;

public class TheMatrix_12 {
    static String[][] matrix;
    static int row;
    static int col;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        row = Integer.parseInt(size[0]);
        col = Integer.parseInt(size[1]);

        matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        String fillChar = scanner.nextLine();
        String[] startSize = scanner.nextLine().split(" ");
        int startRow = Integer.parseInt(startSize[0]);
        int startCol = Integer.parseInt(startSize[1]);

        String startChar = matrix[startRow][startCol];

            isStartChar(startRow, startCol, startChar, fillChar);

        for (String[] strings : matrix) {
            System.out.println(String.join("", strings));
        }
    }

    private static void isStartChar(int startRow, int startCol, String startChar, String fillChar) {
        if (isOutOfBounce(startRow, startCol) || !matrix[startRow][startCol].equals(startChar)) {
            return;
        }

        matrix[startRow][startCol] = fillChar;

        isStartChar(startRow + 1, startCol, startChar, fillChar);
        isStartChar(startRow - 1, startCol, startChar, fillChar);
        isStartChar(startRow, startCol + 1, startChar, fillChar);
        isStartChar(startRow, startCol - 1, startChar, fillChar);
    }

    private static boolean isOutOfBounce(int clickedRow, int clickedCol) {
        return clickedRow < 0 || clickedRow >= matrix.length || clickedCol < 0 || clickedCol >= matrix[clickedRow].length;
    }
}
