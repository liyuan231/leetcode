package cyc;

import java.util.Stack;

public class l_232 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public static void main(String[] args) {
        l_232 s = new l_232();
//        s.push(1);
//        s.push(2);
//        System.out.println(s.pop());
//        System.out.println(s.pop());
        System.out.println(s.empty());

    }

    /**
     * Initialize your data structure here.
     */
    public l_232() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        peek();
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        throw new NullPointerException();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        if (stack2.isEmpty()) {
            throw new NullPointerException();
        }
        return stack2.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        peek();
        return stack2.isEmpty();
    }


}
