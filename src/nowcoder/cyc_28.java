package nowcoder;

import leetcode.TreeNode;

public class cyc_28 {
    public static void main(String[] args) {
        System.out.println(isSymmetrical(TreeNode.create()));
    }

    private static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private static boolean isSymmetrical(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetrical(left.right, right.left) && isSymmetrical(right.right, left.left);
    }

}
