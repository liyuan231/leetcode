package leetcode;

public class l_112 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(hasPathSum(treeNode, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
