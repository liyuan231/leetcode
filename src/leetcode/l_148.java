package leetcode;

public class l_148 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        ListNode listNode1 = sortList(listNode);
        while (listNode1 != null) {
            System.out.print(listNode1.val + " ");
            listNode1 = listNode1.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        ListNode dummy = head;
        int length = 0;
        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }
        dummy = new ListNode(-1);
        dummy.next = head;
        for (int size = 1; size < length; size = size + size) {
//            ListNode left = head;
//            ListNode right = left;
//            int offset = size;
//            while (offset != 0) {
//                right = right.next;
//            }

        }
        return null;
    }
}
