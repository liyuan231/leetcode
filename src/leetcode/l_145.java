package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_145 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        List<Integer> list = postorderTraversal(treeNode);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversal(root, result);
        return result;
    }

    private static void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
