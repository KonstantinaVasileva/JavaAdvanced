package Advanced.MultidimensionalArray.Lab;

import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] chessboard = new String[8][8];

        for (int i = 0; i < 8; i++) {
            chessboard[i] = scanner.nextLine().split(" ");
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard[i][j].equals("q")) {
                    if (isAttacked(chessboard, i, j)) {
                        System.out.println(i + " " + j);
                    }
                }
            }
        }
    }

    public static boolean isAttacked(String[][] matrix, int row, int col) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (matrix[i][j].equals("q") &&
                        (i == row || j == col || isDiagonal(matrix, i, j))) {
                    if (!(i == row && j == col)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static boolean isDiagonal(String[][] matrix, int i, int j) {
        String[] diagonalsOne = new String[8];
        String[] diagonalsTwo = new String[8];

        for (int row = 0; row < 8; row++) {
            diagonalsOne[row] = matrix[row][row];
            diagonalsTwo[7 - row] = matrix[row][7 - row];
        }
        return true;
    }
}
