package Advanced.StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        if (number == 0) {
            System.out.println(0);
            return;
        }
        ArrayDeque<Integer> binaryNum = new ArrayDeque<>();
        while (number != 0) {
            binaryNum.push(number % 2);
            number /= 2;
        }
        while (!binaryNum.isEmpty()) {
            System.out.print(binaryNum.pop());
        }
    }
}
