package Advanced.MultidimensionalArray.Exercise;

import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }
        int row = rows - 1;
        int col = cols - 1;
        while (row >= 0) {
            int r = row;
            int c = col;
            while (c < cols) {
                System.out.print(matrix[r][c] + " ");
                r--;
                c++;
                if (r < 0) {
                    break;
                }
            }
            System.out.println();

            col--;
            if (col == -1) {
                col++;
                row--;
            }
        }
    }
}
