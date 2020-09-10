package leetcode;

public class l_160 {
    public static void main(String[] args) {
        ListNode l1 = ListNode.create();
        ListNode l2 = ListNode.create();
        ListNode intersectionNode = getIntersectionNode(l1, l2);
        System.out.println(intersectionNode.val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            }
            pA = pA.next;
            if (pB == null) {
                pB = headA;
            }
            pB = pB.next;
        }
        return pA;
    }
}
