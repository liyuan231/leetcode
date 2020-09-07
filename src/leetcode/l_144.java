package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_144 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        List<Integer> list = preorderTraversal(treeNode);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversal(root, result);
        return result;
    }

    private static void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
//            System.out.println(Arrays.toString(result.toArray()));
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left,result);
        preorderTraversal(root.right,result);
    }
}

