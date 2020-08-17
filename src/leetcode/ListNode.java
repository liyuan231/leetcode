package leetcode;

import java.util.Scanner;

public class ListNode {
    public ListNode next;
    public int val;

    public static ListNode create() {
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

    public static ListNode delete(ListNode head, int k) {
        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        pre.next = head;
        for (int i = 0; i < k - 1; i++) {
            pre = pre.next;
            //超出链表长度直接返回
            if (pre.next == null) {
                return head;
            }
        }
        pre.next = pre.next.next;
        return result.next;
    }

    public void show() {
        ListNode head = this;
        while (head.next != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }

    public static int max(ListNode head) {
        int max = 0;
        while (head != null) {
            max = Math.max(max, head.val);
            head = head.next;
        }
        return max;
    }

    public static int max_(ListNode head) {
       return max__(head,Integer.MIN_VALUE);
    }
    private static int max__(ListNode listNode,int max){
        if(listNode.next==null){return listNode.val;}
        return Math.max(max,max__(listNode.next, listNode.val));
    }

    public boolean find(int key) {
        ListNode node = this;
        while (node != null) {
            if (node.val == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public static ListNode remove(ListNode head, int key) {
        ListNode pre = new ListNode(-1);
        ListNode result = pre;
        pre.next = head;
        while (pre != null && pre.next != null) {
            if (pre.next.val == key) {
                pre.next = pre.next.next;
            }
            pre = pre.next;
        }
        return result.next;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }
}
