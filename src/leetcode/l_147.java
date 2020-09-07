package leetcode;

public class l_147 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ListNode listNode1 = insertionSortList(listNode);
        while (listNode1 != null) {
            System.out.print(listNode1.val + "->");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head;
        ListNode next = null;
        ListNode pre = null;
        while (cur != null && cur.next != null) {
            if (cur.next.val>cur.val){
                cur=cur.next;
                continue;
            }
            pre=dummy;
            while (pre.next.val<cur.next.val){
                pre=pre.next;
            }
            next = cur.next;
            cur.next = next.next;
            next.next=pre.next;
            pre.next = next;
        }
        return dummy.next;
    }
}
