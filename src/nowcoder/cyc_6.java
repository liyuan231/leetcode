package nowcoder;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class cyc_6 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.create();
        System.out.println(Arrays.toString(printListFromTailToHead(listNode).toArray()));
    }


    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        travsel(list, listNode);
        return list;
    }

    private static void travsel(ArrayList<Integer> list, ListNode listNode) {
        if (listNode == null) {
            return;
        }
        travsel(list, listNode.next);
        list.add(listNode.val);
    }
}
