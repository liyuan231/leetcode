package leetcode;

public class l_129 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(sumNumbers(treeNode));
    }

    public static int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Integer result = 0;
        return sumNumbers(root, stringBuilder, result);
    }

    private static int sumNumbers(TreeNode root, StringBuilder tmp, Integer result) {
        if (root == null) {
            return 0;
        }
        //保证为叶子节点
        if (root.left == null && root.right == null) {
            StringBuilder append = tmp.append(root.val);
            int i = Integer.parseInt(append.toString());
            tmp.deleteCharAt(tmp.length() - 1);
            return i;
        }
        int num1 = sumNumbers(root.left, tmp.append(root.val), result);
        tmp.deleteCharAt(tmp.length() - 1);
        int num2 = sumNumbers(root.right, tmp.append(root.val), result);
        tmp.deleteCharAt(tmp.length() - 1);
        return num1 + num2;
    }
}
