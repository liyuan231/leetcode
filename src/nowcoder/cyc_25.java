package nowcoder;

import leetcode.ListNode;

public class cyc_25 {
    public static void main(String[] args) {
        ListNode merge = Merge(ListNode.create(), ListNode.create());
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        ListNode res = new ListNode(-1);
        ListNode ans = res;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                res.next = p1;
                p1 = p1.next;
            } else {
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
        }
        while (p1 != null) {
            res.next = p1;
            res=res.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            res.next = p2;
            res=res.next;
            p2 = p2.next;
        }
        return ans.next;
    }

}
