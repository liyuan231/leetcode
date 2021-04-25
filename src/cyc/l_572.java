package cyc;

import leetcode.TreeNode;

public class l_572 {
    public static void main(String[] args) {
        System.out.println(isSubtree(TreeNode.create(new Integer[]{3, 4, 5, 1, 2, null, null}),
                TreeNode.create(new Integer[]{4,1,2})));
    }

    public static boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }
        return isSubTreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private static boolean isSubTreeWithRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return isSubTreeWithRoot(s.left, t.left) && isSubTreeWithRoot(s.right, t.right);
    }
}
