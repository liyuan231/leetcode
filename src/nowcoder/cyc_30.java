package nowcoder;

public class cyc_30 {
    private Node root = new Node(-1);
    private Node stack = new Node(-1);
    private int N;

    private static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        cyc_30 c = new cyc_30();
        c.push(3);
        System.out.println(c.min());
        c.push(4);
        System.out.println(c.min());
        c.push(2);
        System.out.println(c.min());
        c.push(3);
        System.out.println(c.min());
        c.pop();
        System.out.println(c.min());
        c.pop();
        System.out.println(c.min());
        c.pop();
        System.out.println(c.min());
        c.push(0);
        System.out.println(c.min());
    }

    public void push(int node) {
        N++;
        Node p = new Node(node);
        if (stack.next == null || stack.next.val >= node) {
            Node n = new Node(node);
            n.next = stack.next;
            stack.next = n;
        }
        p.next = root.next;
        root.next = p;
    }

    public void pop() {
        if (!isEmpty()) {
            N--;
            int val = root.next.val;
            if (stack.next.val == val) {
                stack.next = stack.next.next;
            }
            root.next = root.next.next;
        }
    }

    private boolean isEmpty() {
        return N == 0;
    }

    public int top() {
        return root.next.val;
    }

    public int min() {
        return stack.next.val;
    }
}
