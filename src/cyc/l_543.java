package cyc;

import leetcode.TreeNode;

public class l_543 {
    public static void main(String[] args) {
        System.out.println(diameterOfBinaryTree(TreeNode.create(new Integer[]{1,2})));
    }

    private static int max = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
//        System.out.println(left+right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}
