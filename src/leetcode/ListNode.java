package leetcode;

import java.util.Scanner;

public class ListNode {
    ListNode next;
    int val;

    public static ListNode create() {
        Scanner input = new Scanner(System.in);
        int num;
        num = input.nextInt();
        if (num == -100) {
            return null;
        }
        ListNode head = new ListNode();
        head.val = num;
        ListNode p = head;
        while ((num = input.nextInt()) != -100) {
            ListNode listNode = new ListNode(num);
            p.next = listNode;
            p = p.next;
        }
        return head;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }
}
