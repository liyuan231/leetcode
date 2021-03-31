package leetcode;

public class l_reverse {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ListNode n = reverse1(listNode);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

    private static ListNode reverse(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode last = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return last;
    }

    private static ListNode reverse1(ListNode node) {
        if (node == null) {
            return null;
        }
        ListNode head = node;
        ListNode pre = node;
        ListNode cur = node;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = null;
        return pre;
    }
}
