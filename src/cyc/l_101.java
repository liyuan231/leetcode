package cyc;

import leetcode.TreeNode;

public class l_101 {
    public static void main(String[] args) {
        System.out.println(isSymmetric(TreeNode.create(new Integer[]{1, 2, 2, 3, 4, 4, 5})));
    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }

}
