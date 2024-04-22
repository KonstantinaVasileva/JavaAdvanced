package Advanced.StacksAndQueues_Exercise;

import java.util.*;

public class InfixToPostfix_08 {
    public static final String isSign = "*/+-";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        StringBuilder output = new StringBuilder();
        ArrayDeque<String> sign = new ArrayDeque<>();
        ArrayDeque<String> inParentheses = new ArrayDeque<>();
        int isOpen = 0;

        for (String symbol : input) {
            if (isOpen > 0) {
                if (symbol.equals(")")) {
                    output.append(expressionInParentheses(inParentheses));
                    isOpen --;
                } else if (symbol.equals("(")) {
                    isOpen++;
                    inParentheses.offer(symbol);
                } else {
                    inParentheses.offer(symbol);
                }
            } else {
                if (isSign.contains(symbol)) {
                    orderOfSign(symbol, sign, output);
                } else if (symbol.equals("(")) {
                    inParentheses.offer(symbol);
                    isOpen ++;
                } else {
                    output.append(symbol).append(" ");
                }
            }
        }
        feelSign(sign, output);

        System.out.println(output);

    }

    private static void feelSign(ArrayDeque<String> sign, StringBuilder output) {
        while (!sign.isEmpty()){
            output.append(sign.pop()).append(" ");
        }
    }

    private static void orderOfSign(String symbol, ArrayDeque<String> sign, StringBuilder output) {
        if (!sign.isEmpty() && priority(symbol) <= priority(sign.peek())) {
            output.append(sign.pop()).append(" ");
            sign.push(symbol);
        } else {
            sign.push(symbol);
        }
    }

    private static StringBuilder expressionInParentheses(ArrayDeque<String> inParentheses) {
        StringBuilder output = new StringBuilder();
        ArrayDeque<String> sign = new ArrayDeque<>();
        int isOpen = 0;
        while (!inParentheses.isEmpty()) {
            if (isSign.contains(inParentheses.peek())) {
                orderOfSign(inParentheses.pop(), sign, output);
               // sign.append(inParentheses.pop()).append(" ");
            } else if ("(".equals(inParentheses.peek())) {
                if (isOpen > 0) {
                    if (inParentheses.peek().equals(")")) {
                        output.append(expressionInParentheses(inParentheses));
                        isOpen --;
                    } else if (inParentheses.peek().equals("(")) {
                        isOpen++;
                        inParentheses.offer(inParentheses.peek());
                    } else {
                        inParentheses.offer(inParentheses.peek());
                    }
                } else {
                    if (isSign.contains(inParentheses.peek())) {
                        orderOfSign(inParentheses.peek(), sign, output);
                    } else if (inParentheses.peek().equals("(")) {
                        inParentheses.offer(inParentheses.peek());
                        isOpen ++;
                    } else {
                        output.append(inParentheses.peek()).append(" ");
                    }
                }
            } else {
                output.append(inParentheses.pop()).append(" ");
            }
        }
        feelSign(sign, output);

        return output;
    }

    public static int priority(String sign) {
        if (sign.equals("+") || sign.equals("-")) {
            return 2;
        }
        return 3;
    }
}

// 60/100