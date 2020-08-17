package algorithm;

import leetcode.ListNode;

import java.util.Scanner;

public class AnnularQueue {

    public static ListNode create(){
        Scanner input = new Scanner(System.in);
        int num;
        num = input.nextInt();
        if (num == -1) {
            return null;
        }
        ListNode head = new ListNode();
        head.val = num;
        ListNode p = head;
        while ((num = input.nextInt()) != -1) {
            ListNode listNode = new ListNode(num);
            p.next = listNode;
            p = p.next;
        }
        return head;
    }


}

