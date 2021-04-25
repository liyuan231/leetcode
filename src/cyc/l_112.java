package cyc;

import leetcode.TreeNode;

public class l_112 {
    public static void main(String[] args) {
        System.out.println(hasPathSum(TreeNode.create(new Integer[]{1, 2}), 1));
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        if (root.left == null) {
            return hasPathSum(root.right, targetSum - root.val);
        }
        if (root.right == null) {
            return hasPathSum(root.left, targetSum - root.val);
        }
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }
}
