package leetcode;

public class l_203 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ListNode listNode1 = removeElements(listNode, 1);
        while (listNode1 != null) {
            System.out.print(listNode1.val + "->");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode p = pre;
        while (p.next != null) {
            if (p.next.val == val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return pre.next;
//        return result.next;
    }
}
