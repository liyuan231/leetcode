package algorithm;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

public class a1_3_4 {
    public static void main(String[] args) {
        String s = "[()]{}{[()()]()}{[()]}{";
        System.out.println(isParentheses(s));
    }

    public static boolean isParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == parentheses(c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    private static Character parentheses(char c) {
        return switch (c) {
            case '}' -> '{';
            case ']' -> '[';
            case ')' -> '(';
            default -> '@';
        };
    }

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        int N = 50;
        while (N > 0) {
            stack.push(N % 2);
            N = N / 2;
        }
        for (int d : stack) {
            StdOut.print(d + " ");
        }
    }

    @Test
    public void test1() {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        for(int i:queue){
            System.out.print(i+" ");
        }
        System.out.println();
        while (!queue.isEmpty()){
            stack.push(queue.dequeue());
        }
        while (!stack.isEmpty()){
            queue.enqueue(stack.pop());
        }
        for(int i:queue){
            System.out.print(i+" ");
        }
    }
}
