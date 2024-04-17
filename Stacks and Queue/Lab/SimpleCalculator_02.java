package Advanced.StacksAndQueues_Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String[] input = scanner.nextLine().split(" ");

        for (String element : input) {
            stack.add(element);
        }
        int result = Integer.parseInt(stack.pop());
        while (stack.size()!=0){
            String currentSymbol = stack.pop();
            if (currentSymbol.equals("-")){
                result -= Integer.parseInt(stack.pop());
            } else if (currentSymbol.equals("+")) {
                result += Integer.parseInt(stack.pop());
            }
        }
        System.out.println(result);

    }
}
