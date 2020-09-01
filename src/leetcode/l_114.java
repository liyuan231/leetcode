package leetcode;

import java.util.LinkedList;
import java.util.List;

public class l_114 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        flatten(treeNode);
        TreeNode.inorderTraversal(treeNode);
    }


    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> list = new LinkedList<>();
        TreeNode cur = root;
        flatten(root, list);
        for (TreeNode treeNode : list) {
            if (cur.left != null) {
                cur.left = null;
            }
            cur.right = treeNode;
            cur = cur.right;
            cur.right = null;
        }
    }
    public static void flatten(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
//        System.out.print(root.val+"->");
        list.add(root);
        flatten(root.left, list);
        flatten(root.right, list);
    }
}
