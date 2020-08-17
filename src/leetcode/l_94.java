package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class l_94 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        List<Integer> list = new l_94().inorderTraversal(treeNode);
        System.out.println(Arrays.toString(list.toArray()));
    }

    private  List<Integer> result = new ArrayList<>();

    public  List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return result;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
        return result;
    }
}
