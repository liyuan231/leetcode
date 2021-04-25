package cyc;

import leetcode.TreeNode;

public class l_104 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
