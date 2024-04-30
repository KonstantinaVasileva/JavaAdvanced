package Advanced.MultidimensionalArray.Exercise;

import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        byte r = Byte.parseByte(input[0]);
        byte c = Byte.parseByte(input[1]);
        String[][] matrix = new String[r][c];

        for (byte i = 0; i < r; i++) {
            for (byte j = 0; j < c; j++) {
                matrix[i][j] = "" + (char)(97 + i) + (char) (97 + i + j) + (char)(97 + i);
            }

        }
        for (byte i = 0; i < r; i++) {
            System.out.println(String.join(" ", matrix[i]));
        }
    }
}
