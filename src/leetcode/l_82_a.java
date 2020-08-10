package leetcode;

public class l_82_a {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ListNode listNode1 = deleteDuplicates(listNode);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){return head;}
        ListNode p1 = new ListNode(Integer.MAX_VALUE);
        ListNode ans = p1;
        ListNode p2 = p1;
        p1.next = head;
        while (p2.next.next != null) {
            if (p2.val != p2.next.val && p2.next.val != p2.next.next.val) {
                p1.next = p2.next;
                p1 = p1.next;
            }
            p2 = p2.next;
        }
        if (p2.val != p2.next.val) {
            p1.next = p2.next;
            p1 = p1.next;
        }
        p1.next = null;
        return ans.next;
    }
}
