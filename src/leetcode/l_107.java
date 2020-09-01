package leetcode;

import java.util.*;

public class l_107 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        List<List<Integer>> lists = levelOrderBottom(treeNode);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.pollFirst();
                tmp.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(0,tmp);
        }
        return result;
    }
}
