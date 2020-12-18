package leetcode;

import org.junit.Test;

import java.util.EmptyStackException;
import java.util.Stack;

public class l_225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

    @Test
    public void test01() {
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.peek());
    }
}


class MyStack {
    ListNode root;

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        root = new ListNode(-1);
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        ListNode node = new ListNode(x);
        node.next = root.next;
        root.next = node;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!empty()) {
            ListNode next = root.next;
            root.next = root.next.next;
            return next.val;
        }
        throw new EmptyStackException();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (!empty()) {
            return root.next.val;
        }
        throw new EmptyStackException();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return root.next == null;
    }


}

