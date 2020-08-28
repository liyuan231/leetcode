package leetcode;

import java.util.*;

public class l_103 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        List<List<Integer>> lists = zigzagLevelOrder(treeNode);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        zigzagLevelOrder(root, result, 0);
        return result;
    }

    private static void zigzagLevelOrder(TreeNode root, List<List<Integer>> result, int depth) {
        if (root == null) {
            return;
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
            result.add(tmp);
        }
        for (int i = 1; i <result.size(); i=i+2) {
            Collections.reverse(result.get(i));
        }
    }

}
