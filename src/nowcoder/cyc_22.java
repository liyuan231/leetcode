package nowcoder;

import leetcode.ListNode;

public class cyc_22 {
    public static void main(String[] args) {
        ListNode listNode = FindKthToTail(ListNode.create(), 6);
        System.out.println(listNode.val);
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if(head==null){return null;}
        if(k==0){return null;}
        ListNode p1 = head;
        ListNode p2 = head;
        while (k-- > 0&&p1!=null) {
            p1 = p1.next;
        }
        //若此时k>0,说明要寻找的数字太大了
        if(k>=0){return null;}
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p2;
    }
}
