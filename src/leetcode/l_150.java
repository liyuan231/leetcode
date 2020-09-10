package leetcode;

import java.util.Stack;

public class l_150 {
    public static void main(String[] args) {
        String[] s = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(s));

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> operand = new Stack<>();
//        Stack<String> operator = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                Integer pop0 = operand.pop();
                Integer pop1 = operand.pop();
                int value;
                switch (token) {
                    case "+":
                        value = (pop0) + (pop1);
                        break;
                    case "-":
                        value = (pop1) - (pop0);
                        break;
                    case "*":
                        value = (pop1) * (pop0);
                        break;
                    case "/":
                        value = (pop1) / (pop0);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + token);
                }
                operand.push(value);
            } else {
                operand.push(Integer.parseInt(token));
            }
        }
        return operand.pop();
    }

    private static boolean isOperator(String token) {
        if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
            return true;
        }
        return false;
    }
}
