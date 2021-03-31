package nowcoder;

import leetcode.TreeNode;

public class cyc_55_1 {
    public static void main(String[] args) {
        System.out.println(TreeDepth(TreeNode.create()));
    }

    public static int TreeDepth(TreeNode root) {
        return depth(root, 0);
    }

    private static int depth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(depth(root.left, depth + 1), depth(root.right, depth) + 1);
    }
}
