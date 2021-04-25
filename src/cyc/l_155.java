package cyc;

import java.util.Stack;

public class l_155 {
    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    int min;

    public static void main(String[] args) {
        l_155 l = new l_155();
       l.push(2);
       l.push(0);
       l.push(3);
       l.push(0);
        System.out.println(l.getMin());
        l.pop();
        System.out.println(l.getMin());
        l.pop();
        l.getMin();
        l.pop();
        System.out.println(l.getMin());

    }

    /**
     * initialize your data structure here.
     */
    public l_155() {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        dataStack.push(val);
        min = Math.min(min, val);
        minStack.push(min);

    }

    public void pop() {
        Integer pop = dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minStack.peek() ;
    }
}
