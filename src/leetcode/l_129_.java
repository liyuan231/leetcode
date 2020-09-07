package leetcode;

public class l_129_ {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(sumNumbers(treeNode));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }

    private static int sumNumbers(TreeNode root, int cur) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return cur*10+root.val;
        }
        int num1 = sumNumbers(root.left, cur * 10 + root.val);
        int num2 = sumNumbers(root.right, cur * 10 + root.val);
        return num1 + num2;
    }
}
