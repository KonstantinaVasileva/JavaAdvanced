package Advanced.MultidimensionalArray.Exercise;

import java.util.Scanner;

public class ParkingSystem_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split(" ");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        boolean[][] parking = new boolean[row][col];

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("stop")) {
                break;
            }
            int entryRow = Integer.parseInt(input[0]);
            int r = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            int path = 0;
            boolean isParked = false;

            for (int i = c; i > 0; i--) {
                if (!parking[r][i]) {
                    parking[r][i] = true;
                    path = Math.abs(r - entryRow) + i + 1;
                    isParked = true;
                    break;
                }
            }
            if (!isParked) {
                for (int i = c + 1; i < col; i++) {
                    if (!parking[r][i]) {
                        parking[r][i] = true;
                        path = Math.abs(r - entryRow) + i + 1;
                        isParked = true;
                        break;
                    }
                }
            }
            if (isParked){
                System.out.println(path);
            } else {
                System.out.printf("Row %d full\n", r);
            }
        }
    }
}

// 77/100
