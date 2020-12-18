package leetcode;

public class l_226 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.create();
        TreeNode treeNode = invertTree(root);
        TreeNode.inorderTraversal(treeNode);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
