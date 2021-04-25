package cyc;

import leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class l_637 {
    public static void main(String[] args) {
        System.out.println(averageOfLevels(TreeNode.create(new Integer[]{3,9,20,null,null,15,7})));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Double> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                TreeNode left = node.left;
                if (left != null) {
                    queue.add(left);
                }
                TreeNode right = node.right;
                if (right != null) {
                    queue.add(right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}
