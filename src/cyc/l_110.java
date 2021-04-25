package cyc;

import leetcode.TreeNode;

public class l_110 {
    public static void main(String[] args) {
        System.out.println(isBalanced(TreeNode.create()));
    }

    private static boolean res = true;

    public static boolean isBalanced(TreeNode node) {
        maxDepth(node);
        return res;
    }

    private static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = maxDepth(node.left);
        int right = maxDepth(node.right);
        if (Math.abs(left - right) > 1) {
            res = false;
        }
        return Math.max(left, right) + 1;
    }
}
