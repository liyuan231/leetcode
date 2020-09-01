package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l_113 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        List<List<Integer>> lists = pathSum(treeNode, 22);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> tmp = new LinkedList<>();
        pathSum(root, sum, result, tmp);
        return result;
    }

    private static void pathSum(TreeNode root, int sum, List<List<Integer>> result, LinkedList<Integer> tmp) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            tmp.add(root.val);
//            System.out.println(Arrays.toString(tmp.toArray()));
            if (0 == sum - root.val) {
                result.add(new LinkedList<>(tmp));
            }
            tmp.removeLast();
        }
        tmp.add(root.val);
        pathSum(root.left, sum - root.val, result, tmp);
        pathSum(root.right, sum - root.val, result, tmp);
        tmp.removeLast();
    }
}
