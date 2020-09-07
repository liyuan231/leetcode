package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class l_138 {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Node node = Node.create();
        node.random = null;
        node.next.random.next = node.next;
        node.next.random.val = 1;
        node.next.next.random = null;
        Node node1 = copyRandomList(node);
    }


    public static Node copyRandomList(Node head) {
        Map<Integer, Node> map = new HashMap<>();
        Node p = head;
        Node pre = new Node(-1);
        Node preHead = pre;
        while (p != null) {
            pre.next = new Node(p.val);
            p = p.next;
            pre = pre.next;
        }
        int count = 0;
        p = preHead.next;
        while (p != null) {
            map.put(count++, p);
            p = p.next;
        }
        p = head;
        Node pp = preHead.next;
        while (p != null) {
            Node random = p.random;
            pp.random = random == null ? null : map.get(random.val);
            p = p.next;
            pp = pp.next;
        }
        return preHead.next;
    }


    static class Node {
        int val;
        Node next;
        Node random;
        private static int count;

        public Node(int val) {
            this.val = val;
        }

        public static Node create() {
            int val = input.nextInt();
            if (val == -1) {
                return null;
            }
            Node head = new Node(val);
            count++;
            Node p = head;
            while ((val = input.nextInt()) != -1) {
                p.next = new Node(val);
//                Node rand = head;
//                for (int i = 0; i < Math.random() * count; i++) {
//                    rand = rand.next;
//                }
//                p.random = rand;
                p = p.next;
                count++;
            }
            return head;
        }
    }

}
