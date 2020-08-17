package leetcode;

public class l_92 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        int m = 2;
        int n = 4;
        ListNode listNode1 = reverseBetween(listNode, m, n);
        while (listNode1 != null) {
            System.out.print(listNode1.val + "->");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        for (int i = 0; i < m - 1; i++) {
            pre = cur;
            cur = cur.next;
        }
        ListNode first = cur;
        ListNode second = first.next;
        ListNode tmp = null;
        int offset = n - m;
        for (int i = 0; i < offset; i++) {
            tmp = second.next;
            second.next = first;
            first = second;
            second = tmp;
        }
        if (pre == null) {
            cur.next = second;
            head = first;
        }else {
            pre.next = first;
            cur.next = second;
        }
        return head;
    }
}
