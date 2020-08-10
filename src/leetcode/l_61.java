package leetcode;

import java.util.Scanner;

public class l_61 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ListNode listNode = ListNode.create();
        int k = input.nextInt();
        ListNode listNode1 = rotateRight(listNode, k);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        ListNode pre = null;
        ListNode cur = head;
        for (int i = 0; i < length - (k % length); i++) {
            pre = cur;
            cur = cur.next;
        }
        if (cur == null) {
            return head;
        }
        pre.next = null;
        tail.next = head;
        return cur;
    }
}
