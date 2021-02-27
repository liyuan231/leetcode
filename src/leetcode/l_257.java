package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class l_257 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.create();
        System.out.println(Arrays.toString(binaryTreePaths(treeNode).toArray()));

    }

    private static LinkedList<Integer> list = new LinkedList<>();
    private static List<String> res = new LinkedList<>();

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            System.out.println(Arrays.toString(list.toArray()));
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < list.size() - 1; i++) {
                tmp.append(list.get(i)).append("->");
            }
            tmp.append(list.get(list.size() - 1));
            res.add(tmp.toString());
        }
        binaryTreePaths(root.left);
        binaryTreePaths(root.right);
        list.removeLast();
        return res;
    }
}
