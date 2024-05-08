package Advanced.MultidimensionalArray.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        List<List<Integer>> matrix = new ArrayList<>();

        fillMatrix(row, col, matrix);

        while (true) {
            String command = scanner.nextLine();
            if (command.equals("Nuke it from orbit"))
                break;
            int r = Integer.parseInt(command.split("\\s+")[0]);
            int c = Integer.parseInt(command.split("\\s+")[1]);
            int radius = Integer.parseInt(command.split("\\s+")[2]);

            for (int currentRow = r - radius; currentRow <= r + radius; currentRow++) {
                if (isValid(currentRow, c, matrix)) {
                    matrix.get(currentRow).set(c, 0);
                }
            }
            for (int currentCol = c - radius; currentCol <= c + radius; currentCol++) {
                if (isValid(r, currentCol, matrix)) {
                    matrix.get(r).set(currentCol, 0);
                }
            }
            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    if (matrix.get(i).get(j) == 0) {
                        matrix.get(i).remove(j);
                        j--;
                    }
                }
                if (matrix.get(i).size() == 0) {
                    matrix.remove(i);
                    i--;
                }
            }
        }
        for (int i = 0; i < matrix.size(); i++) {
            matrix.get(i).forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    private static boolean isValid(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size()
                && col >= 0 && col < matrix.get(row).size();
    }

    private static void fillMatrix(int row, int col, List<List<Integer>> matrix) {
        int count = 1;
        for (int i = 0; i < row; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                arr.add(count);
                count++;
            }
            matrix.add(arr);
        }
    }
}
