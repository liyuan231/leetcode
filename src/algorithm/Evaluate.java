package algorithm;

import java.util.Stack;

public class Evaluate {
    public static void main(String[] args) {
        String s = "(1+((2+3)*(4*5)))";
        s = "(1+100)";
//        Collections.synchronizedCollection()
//        FixedCapa
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        Stack<Character> operator = new Stack<>();//操作符栈
        Stack<Integer> operand = new Stack<>();//操作数栈
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                operand.push(c - '0');
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                operator.push(c);
            } else if (c == ')') {
                char operand_ = operator.pop();
                int num1 = operand.pop();
                int num2 = operand.pop();
                int ans = -1;
                switch (operand_) {
                    case '+':
                        ans = num1 + num2;
                        break;
                    case '-':
                        ans = num2 - num1;
                        break;
                    case '*':
                        ans = num1 * num2;
                        break;
                    case '/':
                        ans = num2 / num1;
                        break;
                    default:
                        System.out.println("栈中符号出错");
                }
                operand.push(ans);
            }
        }
        return operand.pop();
    }
}
