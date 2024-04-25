package Advanced.MultidimensionalArray.Lab;

import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int row = Integer.parseInt(input[0]);
        int column = Integer.parseInt(input[1]);

        String[][] matrix = new String[row][column];
        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split(" ");
        }

        String numberToFind = scanner.nextLine();
        boolean isFound = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j].equals(numberToFind)) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }
        if (!isFound){
            System.out.println("not found");
        }



    }
}
