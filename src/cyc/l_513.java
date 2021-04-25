package cyc;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class l_513 {
    public static void main(String[] args) {
        System.out.println(findBottomLeftValue(TreeNode.create(new Integer[]{1, 2, 3, 4, null, 5, 6, null, null, 7, null, null, null})));
    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode poll = null;
        while (!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
            poll = queue.poll();
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
//        }
        return poll.val;
    }

}
