package nowcoder;

import leetcode.ListNode;

public class cyc_35 {
    public static void main(String[] args) {
        String s1="123";
        String s2="123";
        String s3=new String("123");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s2==s3);
        System.out.println(s1.equals(s3));



    }


    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1 == null ? pHead2 : p1.next;
            p2 = p2 == null ? pHead1 : p2.next;
        }
        return p1;
    }


}
