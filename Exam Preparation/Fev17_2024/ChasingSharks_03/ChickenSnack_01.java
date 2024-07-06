package Advanced.ExamPreparation.Fev17_2024;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ChickenSnack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> moneyStack = new ArrayDeque<>();
        Deque<Integer> priceQueue = new ArrayDeque<>();

        int[] money = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] prices = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int j : money) {
            moneyStack.push(j);
        }
        for (int price : prices) {
            priceQueue.offer(price);
        }

        int count = 0;
        while (!moneyStack.isEmpty() && !priceQueue.isEmpty()) {
            int handOfMoney = moneyStack.pop();
            int price = priceQueue.poll();

            if (handOfMoney >= price) {
                handOfMoney -= price;
                if (!moneyStack.isEmpty()) {
                    moneyStack.push(moneyStack.pop() + handOfMoney);
                }

                count++;
            }
        }
        if (count >= 4) {
            System.out.printf("Gluttony of the day! Henry ate %d foods.", count);
        } else if (count == 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else {
            System.out.printf("Henry ate: %d %s.", count,
                    count == 1 ? "food" : "foods");
        }

    }
}
