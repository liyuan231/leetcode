package cyc;

public class l_225 {
    private ListNode<Integer> root;
    private int N;

    private static class ListNode<T> {
        T val;
        ListNode<T> next;

        public ListNode(T val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    public l_225() {
        root = new ListNode<>(-1);
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        N++;
        ListNode<Integer> node = new ListNode<>(x);
        node.next = root.next;
        root.next = node;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (empty()) {
            throw new NullPointerException();
        }
        N--;
        ListNode<Integer> tmp = root.next;
        root.next = tmp.next;
        return tmp.val;

    }

    /**
     * Get the top element.
     */
    public int top() {
        return root.next.val;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return N == 0;
    }
}
