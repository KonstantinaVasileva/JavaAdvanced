package Advanced.StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();
        long n2 = 0;
        fibonacci.push(1L);
        if (number == 0) {
            System.out.println(0);
        } else {
            for (int i = 1; i <= number; i++) {
                long temp = n2 + fibonacci.peek();
                n2 = fibonacci.peek();
                fibonacci.push(temp);
            }
            System.out.println(fibonacci.peek());
        }
    }
}
