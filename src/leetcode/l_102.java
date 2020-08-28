package leetcode;

import java.util.*;

public class l_102 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        List<List<Integer>> lists = levelOrder(treeNode);
        for (List<Integer> list : lists) {
            System.out.println(Arrays.toString(list.toArray()));
        }

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        BFS(root, result);
        return result;
    }

    /**
     * 广度优先遍历
     *
     * @param root
     * @param result
     */
    private static void BFS(TreeNode root, List<List<Integer>> result) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
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
    }
}
