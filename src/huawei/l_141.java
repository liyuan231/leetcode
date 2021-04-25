package huawei;

import leetcode.ListNode;

public class l_141 {
    public static void main(String[] args) {
//        System.out.println(has);
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (true) {
            if (slow == null ||fast==null|| fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
//        return false;
    }
}
