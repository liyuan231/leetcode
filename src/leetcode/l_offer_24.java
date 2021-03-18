package leetcode;

public class l_offer_24 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ListNode listNode1 = reverseList(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode next ;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next=null;
        return pre;
//        new WebSock
    }
}
