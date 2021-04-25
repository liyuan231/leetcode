package cyc;

import leetcode.TreeNode;

public class l_226 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create(new Integer[]{4,2,7,1,3,6,9});
        TreeNode.inorderTraversal(treeNode);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = invertTree(root.right);
        root.right = invertTree(root.left);
        return root;
    }
}
