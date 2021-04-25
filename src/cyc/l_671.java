package cyc;

import leetcode.TreeNode;

import java.util.PriorityQueue;

public class l_671 {
    public static void main(String[] args) {
        System.out.println(findSecondMinimumValue(TreeNode.create(new Integer[]{2,2,2})));
    }

    public static int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        travsel(root, queue);
        Integer poll = queue.poll();
        while (!queue.isEmpty() && poll.equals(queue.peek())) {
            queue.poll();
        }
        return queue.peek()==null?-1:queue.peek();
    }

    private static void travsel(TreeNode root, PriorityQueue<Integer> queue) {
        if (root == null) {
            return;
        }
        queue.add(root.val);
        travsel(root.left, queue);
        travsel(root.right, queue);
    }
}
