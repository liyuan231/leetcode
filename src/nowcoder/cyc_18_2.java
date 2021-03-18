package nowcoder;

import leetcode.ListNode;

public class cyc_18_2 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ListNode listNode1 = deleteDuplication(listNode);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode res = pre;
        ListNode cur = head;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next!=null&&cur.val == cur.next.val) {
                    cur = cur.next;
                }
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return res.next;
    }
}
