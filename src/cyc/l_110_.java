package cyc;

import leetcode.TreeNode;

public class l_110_ {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(new Integer[]{3,9,null,null,20,15,7,null,null,null,null});
        System.out.println(isBalanced(treeNode));
    }

    private static boolean res = true;

    public static boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return res;
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(Math.abs(left-right)>1){
            res = false;
        }
        return Math.max(left, right) + 1;

    }
}
