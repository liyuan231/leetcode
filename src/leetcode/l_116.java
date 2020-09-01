package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class l_116 {
    public static void main(String[] args) {
        Node node = Node.create();
        Node connect = connect(node);

    }

    public static Node connect(Node root) {
        if(root==null){return root;}
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            Node prev = null;
            Node cur = null;
            for (int i = 0; i < n; i++) {
                Node node = queue.poll();
                prev = cur;
                cur = node;
                if (prev != null) {
                    prev.next = cur;
                }
                assert node != null;
                System.out.print(node.val + "->");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    static class Node {
        private static final Scanner input = new Scanner(System.in);
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right, Node next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }

        public static Node create() {
            int v = input.nextInt();
            if (v == -1) {
                return null;
            }
            Node node = new Node(v);
            node.left = create();
            node.right = create();
            return node;
        }

    }
}
