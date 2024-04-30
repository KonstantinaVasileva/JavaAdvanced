package Advanced.MultidimensionalArray.Lab;

import java.util.*;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[size][size];
        String[] diagonalsOne = new String[size];
        String[] diagonalsTwo = new String[size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().split(" ");
            diagonalsOne[i] = matrix[i][i];
            diagonalsTwo[size - 1 - i] = matrix[i][size - 1 - i];
        }
        System.out.println(String.join(" ", diagonalsOne));
        System.out.println(String.join(" ", diagonalsTwo));

    }
}
