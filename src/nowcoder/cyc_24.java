package nowcoder;

import leetcode.ListNode;

public class cyc_24 {
    public static void main(String[] args) {
        ListNode listNode = ReverseList(ListNode.create());
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
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
