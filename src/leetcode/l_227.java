package leetcode;


import org.junit.Test;

import java.util.Stack;

public class l_227 {
    public static void main(String[] args) {
        String str = "  3+5 / 2  ";
//        System.out.println(calculate(str));
        System.out.println(calculate2(str));
    }

    public static int calculate(String s) {
        Stack<Character> operator = new Stack<>();
        Stack<Integer> operand = new Stack<>();
        //思路，遍历两次，第一次处理*和/,第二次处理+，-
        //第一步，预处理，将所有的空格删掉
        int numIndex = 0;
        int flag = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                String tmp = s.substring(numIndex, i);
                int num = flag * Integer.parseInt(tmp.trim());
                if (c == '-') {
                    operator.push('+');
                    flag = -1;
                } else {
                    operator.push(c);
                    flag = 1;
                }
                operand.push(num);
                numIndex = i + 1;
            }
        }
        operand.push(flag * Integer.parseInt(s.substring(numIndex).trim()));
        for (int i = 0; i < operator.size(); i++) {
            Character c = operator.get(i);
            if (c == '*' || c == '/') {
                operator.remove(i);
                Integer num1 = operand.get(i);
                Integer num2 = operand.get(i + 1);
                int res = c == '*' ? num1 * num2 : num1 / num2;
                operand.set(i, res);
                operand.remove(i + 1);
                i--;
            }
        }
        for (Character character : operator) {
            Integer num1 = operand.pop();
            Integer num2 = operand.pop();
            operand.push(num1 + num2);
        }
        return operand.pop();
    }

    public static int calculate2(String s) {
        s=s.trim();
        int num = 0;
        Stack<Integer> operand = new Stack<>();
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c==' '){continue;}
            if (Character.isDigit(c)) {
                num = 10 * num + (c - 0x30);
            }
            if (!Character.isDigit(c) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        operand.push(num);
                        break;
                    case '-':
                        operand.push(-num);
                        break;
                    case '*':
                        operand.push(operand.pop() * num);
                        break;
                    case '/':
                        operand.push(operand.pop() / num);
                        break;
                }
                sign = c;
                num = 0;
            }
        }
        int ans = 0;
        while (!operand.empty()){
            ans+=operand.pop();
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(Integer.parseInt("1"));
    }
}
