package leetcode;

public class l_82 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ListNode listNode1 = deleteDuplicates(listNode);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(Integer.MAX_VALUE);
        ListNode ans = result;
        ListNode pre = new ListNode(Integer.MAX_VALUE);
        ListNode cur = head;
        pre.next = cur;
        ListNode next;
        while (cur.next != null) {
            next = cur.next;
            if (pre.val != cur.val && cur.val != next.val) {
                result.next = cur;
                result = result.next;
            }
            pre = cur;
            cur = cur.next;
        }
        if (pre.val != cur.val) {
            result.next = cur;
            result = result.next;
        }
        result.next = null;
        return ans.next;
    }
}
