package cyc;

import leetcode.TreeNode;

public class l_617 {

    public static void main(String[] args) {
        TreeNode.inorderTraversal(
                mergeTrees(
                        TreeNode.create(
                                new Integer[]{1,3,2,5}),
                        TreeNode.create(
                                new Integer[]{2,1,3,null,4,null,7})));
    }


    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode node = new TreeNode(root1.val + root2.val);
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root2.left, root2.left);
        return node;
    }
}
