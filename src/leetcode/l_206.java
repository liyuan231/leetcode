package leetcode;

public class l_206 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ListNode listNode1 = reverseList(listNode);
        while (listNode1 != null) {
            System.out.print(listNode1.val + "->");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode p = head;
        ListNode tmp = null;
        while (p != null) {
            tmp=p.next;
            p.next = pre;
            pre=p;
            p=tmp;
        }
//        System.out.println(1);
        return pre;
    }
}
