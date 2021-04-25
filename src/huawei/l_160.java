package huawei;

import leetcode.ListNode;

public class l_160 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.create();
        ListNode l2 = ListNode.create();
        l1.next.next = l2.next.next.next;
        System.out.println(getIntersectionNode(l1, l2).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
