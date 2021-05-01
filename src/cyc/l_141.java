package cyc;

import leetcode.ListNode;

public class l_141 {
    public static void main(String[] args) {
        System.out.println(hasCycle(ListNode.create()));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
