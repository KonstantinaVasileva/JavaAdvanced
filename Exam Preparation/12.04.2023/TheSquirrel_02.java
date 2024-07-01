package Advanced.ExamPreparation.Apr12_2023;

import java.util.Scanner;

public class TheSquirrel_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");
        String[][] matrix = new String[size][];

        int count = 0;
        int row = -1;
        int col = -1;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("");
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")) {
                    row = i;
                    col = j;
                }
            }
        }

        for (String command : commands) {
            switch (command) {
                case "up":
                    row--;
                    break;
                case "down":
                    row++;
                    break;
                case "left":
                    col--;
                    break;
                case "right":
                    col++;
                    break;
            }
            if (row < 0 || row >= size || col < 0 || col >= size) {
                System.out.println("The squirrel is out of the field.");
                System.out.println("Hazelnuts collected: " + count);
                return;
            }

            if (matrix[row][col].equals("h")) {
                matrix[row][col] = "*";
                count++;
            }

            if (count == 3) {
                System.out.println("Good job! You have collected all hazelnuts!");
                System.out.println("Hazelnuts collected: " + count);
                return;
            }
            if (matrix[row][col].equals("t")){
                System.out.println("Unfortunately, the squirrel stepped on a trap...");
                System.out.println("Hazelnuts collected: " + count);
                return;
            }
        }

        if (count<3){
            System.out.println("There are more hazelnuts to collect.");
            System.out.println("Hazelnuts collected: " + count);
        }
    }
}
