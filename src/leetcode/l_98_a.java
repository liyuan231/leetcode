package leetcode;

public class l_98_a {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(isValidBST(treeNode));
    }

    public static boolean isValidBST(TreeNode root) {
        return dfs(root);
    }

    private static boolean dfs(TreeNode node) {
        return false;
    }
}
