package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_98 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(isValidBST(treeNode));
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);
        System.out.println(Arrays.toString(list.toArray()));
        if (list.size() < 2) {
            return true;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }
        return true;
    }


    private static void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }
}
