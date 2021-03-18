package nowcoder;

import leetcode.ListNode;

public class cyc_23 {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        p3.next = p3;
        System.out.println(EntryNodeOfLoop(p1).val);
    }


    public static ListNode EntryNodeOfLoop(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                break;
            }
        }
        if(p2==null||p2.next==null){
            return null;
        }
        p1 = head;
        while (p1!=p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
