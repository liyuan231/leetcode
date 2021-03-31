package nowcoder;

import leetcode.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.Map;

public class cyc_7 {
    public static void main(String[] args) {
        int[] preorder = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] inorder = new int[]{3, 2, 4, 1, 6, 5, 7};
        TreeNode treeNode = reConstructBinaryTree(preorder, inorder);
        TreeNode.inorderTraversal(treeNode);
    }

    private static Map<Integer, Integer> indexForInOrders = new HashMap<>();

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for (int i = 0; i < in.length; i++) {
            indexForInOrders.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, 0);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if (preL > preR) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preL]);
        int leftTreeSize = indexForInOrders.get(root.val) - inL;
        root.left = reConstructBinaryTree(pre, preL + 1, preL + leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL + leftTreeSize + 1, preR, inL + leftTreeSize + 1);
        return root;
    }
}
